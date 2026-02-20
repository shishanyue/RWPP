package io.github.rwpp.android.impl.unit

import io.github.rwpp.android.impl.AbstractUnitAgentInternal
import io.github.rwpp.android.impl.UnitRefInternal
import io.github.rwpp.appKoin
import io.github.rwpp.game.Player
import io.github.rwpp.game.comp.UnitComp
import io.github.rwpp.game.units.AbstractUnitTypeBase
import io.github.rwpp.game.units.UnitRef
import io.github.rwpp.inject.NewField
import io.github.rwpp.inject.SetInterfaceOn

@SetInterfaceOn([UnitRefInternal::class])
interface UnitRefImpl : UnitRef {
    val self: UnitRefInternal

    @NewField
    var _comp: UnitComp?

    override var comp: UnitComp
        get(){
            _comp = _comp ?: appKoin.get<UnitComp>()
            return _comp!!
        }
        set(value) { _comp = value }

    override val player: Player
        get() = self.bZ as Player

    override val isDead: Boolean
        get() = self.bX

    override val type: AbstractUnitTypeBase
        get() = self.dB as AbstractUnitTypeBase

    override val health: Float
        get() = self.cw

    override val maxAttackRange: Float
        get() = (self as? AbstractUnitAgentInternal)?.l() ?: 0f

    override val maxHealth: Float
        get() = self.cx

    override val target: UnitRef?
        get() = (self as? AbstractUnitAgentInternal)?.T as UnitRef?

    override val x: Float
        get() = self.eq

    override val y: Float
        get() = self.er
}