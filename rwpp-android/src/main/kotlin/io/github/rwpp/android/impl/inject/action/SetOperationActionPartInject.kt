package io.github.rwpp.android.impl.inject.action

import android.graphics.PointF
import io.github.rwpp.android.impl.AbstractActionDataInternal
import io.github.rwpp.android.impl.CustomActionInternal
import io.github.rwpp.android.impl.CustomUnitInternal
import io.github.rwpp.android.impl.SetOperationActionPartInternal
import io.github.rwpp.android.impl.UnitConfigInternal
import io.github.rwpp.android.impl.UnitTypeRefBaseInternal
import io.github.rwpp.android.impl.game.PlayerImpl
import io.github.rwpp.android.impl.unit.custom.logicBooleans.LogicBooleanImpl
import io.github.rwpp.android.impl.utility.UnitConfigImpl
import io.github.rwpp.game.units.AbstractUnitAgent
import io.github.rwpp.game.units.UnitRef
import io.github.rwpp.inject.Inject
import io.github.rwpp.inject.InjectClass
import io.github.rwpp.inject.InjectMode

@InjectClass(SetOperationActionPartInternal::class)
object SetOperationActionPartInject {
    var changeAlliance: LogicBooleanImpl? = null

    @Inject("a", InjectMode.InsertAfter,"parser")
    fun SetOperationActionPartInject.parser(
        unitTypeRefBaseInternal: UnitTypeRefBaseInternal,
        unitConfigInternal: UnitConfigInternal,
        sectionName: String, key: String,
        customActionInternal: CustomActionInternal) {
        val unitConfigImpl = unitConfigInternal as UnitConfigImpl

        changeAlliance = unitConfigImpl.getValueAsLogicBoolean()
    }

    @Inject("a", InjectMode.InsertAfter,"trigger")
    fun SetOperationActionPartInject.trigger(customUnitInternal: CustomUnitInternal,
                                             abstractActionDataInternal: AbstractActionDataInternal?,
                                             pointF: PointF?, unitRef: UnitRef?, i: Int)
    {
        changeAlliance?.let { val toToeam = PlayerImpl.getTeamId(it.readNumber(customUnitInternal as AbstractUnitAgent).toInt()) }
    }
}