/*
 * Copyright 2023-2025 RWPP contributors
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 * https://github.com/Minxyzgo/RWPP/blob/main/LICENSE
 */

package io.github.rwpp.desktop.impl.inject

import android.graphics.Color
import com.corrodinggames.rts.game.units.a.p
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope
import com.corrodinggames.rts.gameFramework.f.am
import com.corrodinggames.rts.gameFramework.f.g
import io.github.rwpp.appKoin
import io.github.rwpp.config.Settings
import io.github.rwpp.desktop.impl.FClassInternal
import io.github.rwpp.desktop.impl.GameEngineInternal
import io.github.rwpp.desktop.impl.GameViewInternal
import io.github.rwpp.game.Game
import io.github.rwpp.game.units.UnitRef
import io.github.rwpp.i18n.readI18n
import io.github.rwpp.inject.Inject
import io.github.rwpp.inject.InjectClass
import io.github.rwpp.inject.InjectMode
import io.github.rwpp.utils.Reflect
import kotlin.math.roundToInt


@InjectClass(GameViewInternal::class)
object GameViewInject {
    var buttons: java.util.ArrayList<Any?>? = null
    val render: g by lazy { GameEngineInternal.B().bS }
    var unitGroups: ArrayList<am>? = null
    val room by lazy { appKoin.get<Game>().gameRoom }
    val settings by lazy { appKoin.get<Settings>() }

    @Inject("a", InjectMode.InsertAfter)
    fun GameViewInternal.onAddGameAction(am: com.corrodinggames.rts.game.units.am?, arrayList: java.util.ArrayList<Any?>?) {
        buttons = buttons ?: Reflect.get(this, "aq")

        if (settings.showExtraButton && GameEngineInternal.B().bS.bZ.isEmpty()) {
            buttons!!.add(ShowAttackRangeBuilding)
            buttons!!.add(ShowAttackRangeUnits)
        }

        if (settings.showExtraButton
            && GameEngineInternal.B().bS.bZ.size == 1
            && (GameEngineInternal.B().bS.bZ.first() as UnitRef).player.team != room.localPlayer.team)  {
            buttons!!.add(
                ShowAttackRange
            )
        }
    }

    object ShowAttackRange : p("c__cut_enable") {
        // com.corrodinggames.rts.game.units.a.s
        override fun b(): String {
            return readI18n("settings.showAttackRange")
        }

        override fun compareTo(other: Any?): Int {
            return 0
        }

        // com.corrodinggames.rts.game.units.a.s
        override fun a(): String {
            return "Show Attack Range"
        }

        // com.corrodinggames.rts.game.units.a.s
        override fun c(amVar: com.corrodinggames.rts.game.units.am?, z: Boolean): Boolean {
            //GameEngineInternal.B().bS.g.n()
            val unit = GameEngineInternal.B().bS.bZ.firstOrNull()
            if (unit != null) {
                (unit as UnitRef).comp.showAttackRange = !unit.comp.showAttackRange
            }
            return true
        }
    }

    object ShowAttackRangeBuilding : com.corrodinggames.rts.game.units.a.p("c_show_attack_range_building") {
        override fun b(): String? {
            return "显示建筑攻击范围"
        }

        override fun a(): String? {
            return "Show Attack Range Building"
        }

        override fun compareTo(other: Any?): Int {
            return 0
        }

        override fun c(amVar: com.corrodinggames.rts.game.units.am?, z: Boolean): Boolean {
            //GameEngineInternal.B().bS.g.n()

            settings.showBuildingAttackRange = !settings.showBuildingAttackRange
            return true
        }
    }

    object ShowAttackRangeUnits : com.corrodinggames.rts.game.units.a.p("c_show_attack_range_units") {

        override fun b(): String? {
            return "显示单位攻击范围\n${settings.showAttackRangeUnit}"
        }

        override fun a(): String? {
            return "Show Attack Range Units"
        }

        override fun compareTo(other: Any?): Int {
            return 0
        }

        override fun c(amVar: com.corrodinggames.rts.game.units.am?, z: Boolean): Boolean {
            //GameEngineInternal.B().bS.g.n()
            val index = Settings.unitAttackRangeTypes.indexOf(settings.showAttackRangeUnit)
            settings.showAttackRangeUnit = Settings.unitAttackRangeTypes.getOrNull(index + 1) ?: Settings.unitAttackRangeTypes.first()
            return true
        }
    }

    @Inject("e", InjectMode.Override)
    fun GameViewInternal.unitGroupUI(f: Float) {
        unitGroups = unitGroups ?: Reflect.get(this, "aA")
        val B = GameEngineInternal.B()
        val i = (B.cH - (30.0f * B.cj))
        val i3 = ((B.cq - 20.0f).roundToInt()) / 3
        var i2 = ((B.cl - B.cq) - i3 * (settings.maxDisplayUnitGroupCount - 3) - settings.displayUnitGroupXOffset + 10)
        val i4 = i3 - 5
        for (i5 in 0..<unitGroups!!.size) {
            val amVar = unitGroups!![i5]
            if (amVar.h) {
                amVar.e()
                amVar.h = false
            }
            amVar.d()
            if (B.bQ.keyboardSupport && i5 < B.bT.ai.size) {
                if (B.bT.ak.get(i5).a()) {
                    amVar.b()
                    amVar.c()
                }
                if (B.bT.aj.get(i5).a()) {
                    render!!.l()
                    amVar.a()
                }
                if (B.bT.ai.get(i5).a()) {
                    render!!.l()
                    render!!.y()
                    amVar.a()
                }
            }
            if (B.bQ.showUnitGroups && i5 < settings.maxDisplayUnitGroupCount) {
                val str = if (amVar.a.size == 0) {
                    if (render!!.bN) {
                        "Empty"
                    } else {
                        "(" + (i5 + 1) + ")"
                    }
                } else {
                    VariableScope.nullOrMissingString + amVar.a.size
                }
                amVar.d = FClassInternal.a(amVar.d, 0.01f * f)
                amVar.e = FClassInternal.a(amVar.e, 0.01f * f)
                amVar.f = FClassInternal.a(amVar.f, 0.01f * f)

                render!!.a(
                    i2.roundToInt(),
                    i.roundToInt(),
                    i4,
                    (31.0f * B.cj).roundToInt(),
                    str,
                    com.corrodinggames.rts.gameFramework.f.i.a,
                    true,
                    Color.a(
                        50,
                        (100.0f + (amVar.f * 100.0f)).roundToInt(),
                        (100.0f + (amVar.e * 100.0f)).roundToInt(),
                        (100.0f + (amVar.d * 100.0f)).roundToInt()
                    )
                )
                i2 += i3
            }
        }
    }

}