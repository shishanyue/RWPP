package io.github.rwpp.desktop.impl.unit

import io.github.rwpp.appKoin
import io.github.rwpp.desktop.impl.AbstractUnitAgentInternal
import io.github.rwpp.desktop.impl.UnitRefInternal
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
        get() = self.bX as Player

    override val isDead: Boolean
        get() = self.bV

    override val type: AbstractUnitTypeBase
        get() = self.dz as AbstractUnitTypeBase

    override val x: Float
        get() = self.eo

    override val y: Float
        get() = self.ep

    override val target: UnitRef?
        get() = (this as? AbstractUnitAgentInternal)?.R as? UnitRef

    override val health: Float
        get() = self.cu

    override val maxAttackRange: Float
        get() = (this as? AbstractUnitAgentInternal)?.m() ?: 0f

    override val maxHealth: Float
        get() = self.cv
}