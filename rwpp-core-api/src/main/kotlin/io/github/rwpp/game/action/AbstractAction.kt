package io.github.rwpp.game.action

import io.github.rwpp.game.base.PointF
import io.github.rwpp.game.units.UnitRef
import io.github.rwpp.game.units.custom.CustomUnit


interface AbstractAction {
    abstract fun trigger(
        customUnit: CustomUnit?,
        abstractActionData: AbstractActionData?,
        pointF: PointF?,
        unitRef: UnitRef?,
        i: Int
    ): Boolean

}