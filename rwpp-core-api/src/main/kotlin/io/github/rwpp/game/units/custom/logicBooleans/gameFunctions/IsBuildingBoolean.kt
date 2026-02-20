package io.github.rwpp.game.units.custom.logicBooleans.gameFunctions

import io.github.rwpp.game.units.AbstractUnitAgent
import io.github.rwpp.game.units.custom.logicBooleans.LogicBoolean

interface IsBuildingBoolean: LogicBoolean {
    override fun read(abstractUnitAgent: AbstractUnitAgent?): Boolean {
        return abstractUnitAgent?.isBuilding ?: false
    }
    override fun getMatchFailReasonForPlayer(abstractUnitAgent: AbstractUnitAgent?): String? {
        return "IsBuilding"
    }
}