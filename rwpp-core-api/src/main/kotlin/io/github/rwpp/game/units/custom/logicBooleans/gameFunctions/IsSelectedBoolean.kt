package io.github.rwpp.game.units.custom.logicBooleans.gameFunctions

import io.github.rwpp.game.units.AbstractUnitAgent
import io.github.rwpp.game.units.custom.logicBooleans.LogicBoolean

interface IsSelectedBoolean: LogicBoolean {
    override fun read(abstractUnitAgent: AbstractUnitAgent?): Boolean {
        return abstractUnitAgent?.isSelected ?: false
    }
    override fun getMatchFailReasonForPlayer(abstractUnitAgent: AbstractUnitAgent?): String? {
        return "IsSelected"
    }
}