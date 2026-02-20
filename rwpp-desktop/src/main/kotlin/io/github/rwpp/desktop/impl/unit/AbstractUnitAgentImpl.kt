package io.github.rwpp.desktop.impl.unit

import io.github.rwpp.desktop.impl.AbstractUnitAgentInternal
import io.github.rwpp.game.units.AbstractUnitAgent
import io.github.rwpp.inject.SetInterfaceOn

@SetInterfaceOn([AbstractUnitAgentInternal::class])
interface AbstractUnitAgentImpl: AbstractUnitAgent {
    val self: AbstractUnitAgentInternal

    override var isSelected: Boolean
        get() = self.cI
        set(value) {self.cI = value}

    override val isBuilding: Boolean
    get() = true
}