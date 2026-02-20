package io.github.rwpp.game.units.custom.logicBooleans.numberFunctions

import io.github.rwpp.game.units.AbstractUnitAgent
import io.github.rwpp.game.units.custom.logicBooleans.LogicBoolean

interface LogicNumberOnly: LogicBoolean {
    fun getName(): String

    override fun read(abstractUnitAgent: AbstractUnitAgent?): Boolean {
        return false
    }

    override fun getMatchFailReasonForPlayer(abstractUnitAgent: AbstractUnitAgent?): String?{
        return getName()
    }

}