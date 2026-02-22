package io.github.rwpp.android.impl.action.actionPart

import io.github.rwpp.android.impl.game.PlayerImpl
import io.github.rwpp.android.impl.unit.custom.CustomUnitImpl
import io.github.rwpp.android.impl.unit.custom.logicBooleans.LogicBooleanImpl
import io.github.rwpp.game.action.AbstractActionData
import io.github.rwpp.game.base.PointF
import io.github.rwpp.game.units.AbstractUnitAgent
import io.github.rwpp.game.units.UnitRef
import io.github.rwpp.game.units.custom.CustomUnit

class SetOperationActionPartImpl: SetOperationActionPartBaseImpl {
    override var changeAlliance: LogicBooleanImpl? = null

    override fun trigger(
        customUnit: CustomUnit?,
        abstractActionData: AbstractActionData?,
        pointF: PointF?,
        unitRef: UnitRef?,
        i: Int
    ): Boolean {
        changeAlliance?.let { changeAlliance ->
            val toTeam = PlayerImpl.getTeamId(changeAlliance.readNumber(customUnit as AbstractUnitAgent).toInt())
            val customUnitImpl = customUnit as CustomUnitImpl
            toTeam?.let { (customUnitImpl.player as PlayerImpl).team = it.team }
        }
        return true
    }
}