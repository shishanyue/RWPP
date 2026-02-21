package io.github.rwpp.android.impl.game

import io.github.rwpp.android.impl.GameEngineInternal
import io.github.rwpp.android.impl.PlayerInternal
import io.github.rwpp.android.impl.StaticTeamInfoInternal
import io.github.rwpp.appKoin
import io.github.rwpp.core.Logic
import io.github.rwpp.game.Game
import io.github.rwpp.game.GameRoom
import io.github.rwpp.game.Player
import io.github.rwpp.game.StaticTeamInfo
import io.github.rwpp.game.data.PlayerData
import io.github.rwpp.game.data.PlayerStatisticsData
import io.github.rwpp.inject.NewField
import io.github.rwpp.inject.SetInterfaceOn
import io.github.rwpp.net.Client
import io.github.rwpp.utils.Reflect
import kotlin.math.roundToInt
import kotlin.text.get

@SetInterfaceOn([PlayerInternal::class])
interface PlayerImpl : Player {
    companion object{
        val neutralTeam = StaticTeamInfoInternal(-2)
        val aggressiveTeam = StaticTeamInfoInternal(-1)
        
        val allPlayers: Array<Player?> = appKoin.get<Game>().gameRoom.getAllPlayers()

        fun getTeamId(number: Int): Player?{

            if (number == -1) {
                return neutralTeam as Player;
            }
            if (number == -2) {
                return aggressiveTeam as Player;
            }
            if (number >= Player.maxPlayerCount) {
                GameEngineInternal.f("team index too high: $number");
                return null;
            }
            if (number < 0) {
                GameEngineInternal.f("team index too low: $number");
                return null;
            }
            return allPlayers[number];
        }
    }

    private val room: GameRoom
        get() = appKoin.get<Game>().gameRoom

    val self: PlayerInternal

    @NewField
    var _connectHexId: String?

    @NewField
    var _data: PlayerData?

    override val connectHexId: String
        get() = self.S ?: run {
            _connectHexId = if (_connectHexId == null || _connectHexId == "0") {
                Logic.getNextPlayerId().toString()
            } else {
                _connectHexId
            }
            _connectHexId!!
        }
    override var spawnPoint: Int
        get() = self.l
        set(value) {
            applyConfigChange(spawnPoint = value)
        }
    override var team: Int
        get() = self.s
        set(value) {
            if (room.isHost) self.s = value
            else if (room.isHostServer) {
                val t = GameEngineInternal.t()
                t.bU.b(self, value)
            }
        }
    override var name: String
        get() = self.w ?: ""
        set(value) {
            if (room.isHost) self.w = value
        }
    override val ping: String
        get() {
            val t = self.t()
            return if(t == -99) {
                "HOST"
            } else if(isAI) {
                "-"
            } else if(t == -1) {
                "N/A"
            } else if(t == -2) {
                "-"
            } else {
                if(self.T == 1) "$t (HOST)" else java.lang.String.valueOf(t)
            }
        }
    override var startingUnit: Int
        get() = self.B ?: -1
        set(value) {
            if (room.isHost) self.B = if (value == -1) null else value
        }
    override var color: Int
        get() = self.D ?: -1
        set(value) {
            if (room.isHost) self.D = if (value == -1) null else value
        }
    override val isSpectator: Boolean
        get() = team == -3
    override val isAI: Boolean
        get() = self.x
    override var difficulty: Int?
        get() = if(isAI) self.y else null
        set(value) { if(room.isHost) self.y = value!! }

    override var credits: Int
        get() = self.p.roundToInt()
        set(value) { self.p = value.toDouble() }
    override val statisticsData: PlayerStatisticsData
        get() = with(GameEngineInternal.t().bV.a(self)) {
            PlayerStatisticsData(c, d, e, f, g, h)
        }
    override val income: Int
        get() = self.q()
    override val isDefeated: Boolean
        get() = isWipedOut || isDefeatedTech
    override val isWipedOut: Boolean
        get() = self.J
    override val isDefeatedTech: Boolean
        get() = self.I
    override val data: PlayerData
        get() = _data ?: run {
            _data = PlayerData()
            _data!!
        }
    override val client: Client?
        get() = GameEngineInternal.t().bU.c(self) as? Client

    override val allPlayers: Array<Player?>
        get() = PlayerImpl.allPlayers

    override fun applyConfigChange(
        spawnPoint: Int,
        team: Int,
        color: Int?,
        startingUnits: Int?,
        aiDifficulty: Int?,
        autoTeamMode: Boolean
    ) {
        val t = GameEngineInternal.t()
        var bl: Boolean
        var n: Int
        var n2: Int
        var n3: Int
        var n4: Int
        run block31@{
            run block29@{
                run block30@{
                    n4 = 1;
                    n3 = (aiDifficulty) ?: -99
                    //k.d("newAiDifficultyValue:".concat(String.valueOf(n3)));
                    if(t.bU.D) {
                        self.A = if(n3 == -99) null else Integer.valueOf(n3);
                    }
                    n3 = startingUnits ?: -99
                    //k.d("startingUnits:" + this.c);
                    if(t.bU.D) {
                        self.B = if(n3 == -99) null else Integer.valueOf(n3);
                    }
                    n3 = color ?: -99
                    //k.d("newPlayerColorValue:".concat(String.valueOf(n3)));
                    if(t.bU.D) {
                        self.D = if(n3 == -99) null else Integer.valueOf(n3);
                    }
                    n3 = spawnPoint
                    if(n3 == -3 || n3 > PlayerInternal.c - 1) {
                        n2 = -3;
                        n3 = 1;
                    } else {
                        n2 = n3;
                        if(n3 < 0) {
                            n2 = 0;
                        }
                        if(n2 > PlayerInternal.c - 1) {
                            n2 = PlayerInternal.c - 1;
                            n3 = 0;
                        } else {
                            n3 = 0;
                        }
                    }
                    n = team
                    n3 = if(n3 != 0) -3 else n;
                    if(n3 == 0 || autoTeamMode) {
                        n3 = n2 % 2;
                        val p = PlayerInternal.i(spawnPoint)
                        if (p != null) {
                            n3 = p.s
                        } else if (room.teamMode != null) {
                            n3 = room.teamMode!!.autoTeamAssign(room, spawnPoint, this)
                        }
                        bl = true;
                    } else if(n3 != -1) {
                        --n3;
                        bl = false;
                    } else {
                        bl = false;
                    }
                    if(n3 == -1 || self.s == n3) return@block29
                    if(!t.bU.D) return@block30
                    self.s = n3;
                    n = 0;
                    return@block31
                }
                n = n4;
                if(t.bU.I) return@block31
                n = n4;
                if(t.bU.A == self) return@block31
                //t.a("row.setOnClickListener", "Clicked but not server or proxy controller");
            }
            n = 0;
        }
        n4 = n;
        if(self.l != n2) {
            n4 = n;
            if(n2 != -1) {
                if(t.bU.D) {
                    t.bU.a(self, n2);
                    n4 = n;
                } else if(t.bU.I || t.bU.A == self) {
                    n = if(bl) -1 else n3;
                    val ae2 = t.bU;
                    val p2 = self;
                    var n5: Integer? = Integer(n);
                    var obj = "";
                    if(n5 != null) {
                        obj = " " + n5;
                    }
                    if(!ae2.I && ae2.A == p2) {
                        ae2.i("-self_move " + (n2 + 1) + obj);
                        n4 = 0;
                    } else {
                        ae2.i("-move " + (p2.l + 1) + " " + (n2 + 1) + obj);
                        n4 = 0;
                    }
                } else {
                    //k.a("row.setOnClickListener", "Clicked but not server or proxy controller");
                    n4 = n;
                }
            }
        }
        if(n4 != 0) {
            if(bl) {
                t.bU.b(self, -1);
            } else {
                t.bU.b(self, n3);
            }
        }
        t.bU.b();
        t.bU.p();
    }

    override fun getTeamId(number: Int): Player? {
        return super.getTeamId(number)
    }
}