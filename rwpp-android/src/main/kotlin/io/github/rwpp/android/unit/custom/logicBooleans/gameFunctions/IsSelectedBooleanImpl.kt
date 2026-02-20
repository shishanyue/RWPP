package io.github.rwpp.android.unit.custom.logicBooleans.gameFunctions

import io.github.rwpp.android.impl.AbstractUnitAgentInternal
import io.github.rwpp.android.impl.LogicBooleanInternal
import io.github.rwpp.android.impl.UnitTypeRefBaseInternal
import io.github.rwpp.android.impl.unit.AbstractUnitAgentImpl
import io.github.rwpp.game.units.AbstractUnitAgent
import io.github.rwpp.game.units.custom.UnitTypeRefBase
import io.github.rwpp.game.units.custom.logicBooleans.gameFunctions.IsSelectedBoolean

class IsSelectedBooleanImpl: IsSelectedBoolean, LogicGameFunctionBaseImpl() {
    override fun read(abstractUnitAgent: AbstractUnitAgent?): Boolean {
        return (abstractUnitAgent as AbstractUnitAgentImpl).isSelected
    }
}