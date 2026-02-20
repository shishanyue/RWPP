package io.github.rwpp.android.unit.custom.logicBooleans.gameFunctions

import io.github.rwpp.android.impl.AbstractUnitAgentInternal
import io.github.rwpp.android.impl.LogicBooleanInternal
import io.github.rwpp.android.impl.UnitTypeRefBaseInternal
import io.github.rwpp.game.units.AbstractUnitAgent
import io.github.rwpp.game.units.custom.UnitTypeRefBase
import io.github.rwpp.game.units.custom.logicBooleans.LogicBoolean

abstract class LogicGameFunctionBaseImpl:LogicBoolean, LogicBooleanInternal() {

    override fun getMatchFailReasonForPlayer(abstractUnitAgent: AbstractUnitAgentInternal?): String? {
        return getMatchFailReasonForPlayer(abstractUnitAgent as AbstractUnitAgent)
    }

    override fun setArgumentsRaw(arguments: String?, unitTypeRefBase: UnitTypeRefBase?, key: String?) {
        setArgumentsRaw(arguments, unitTypeRefBase as UnitTypeRefBaseInternal, key)
    }
    override fun read(abstractUnitAgentInternal: AbstractUnitAgentInternal?): Boolean {
        return read(abstractUnitAgentInternal as AbstractUnitAgent)
    }
}