package io.github.rwpp.desktop.unit.custom.logicBooleans.gameFunctions

import io.github.rwpp.desktop.impl.unit.AbstractUnitAgentImpl
import io.github.rwpp.game.units.AbstractUnitAgent
import io.github.rwpp.game.units.custom.logicBooleans.gameFunctions.IsSelectedBoolean

class IsSelectedBooleanImpl: IsSelectedBoolean, LogicGameFunctionBaseImpl() {
    override fun read(abstractUnitAgent: AbstractUnitAgent?): Boolean {
        return (abstractUnitAgent as AbstractUnitAgentImpl).isSelected
    }
}