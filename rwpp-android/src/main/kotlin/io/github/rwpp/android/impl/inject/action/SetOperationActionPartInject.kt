package io.github.rwpp.android.impl.inject.action

import android.graphics.PointF
import io.github.rwpp.android.impl.AbstractActionDataInternal
import io.github.rwpp.android.impl.CustomActionInternal
import io.github.rwpp.android.impl.CustomUnitInternal
import io.github.rwpp.android.impl.SetOperationActionPartInternal
import io.github.rwpp.android.impl.UnitConfigInternal
import io.github.rwpp.android.impl.UnitRefInternal
import io.github.rwpp.android.impl.UnitTypeRefBaseInternal
import io.github.rwpp.android.impl.action.CustomActionImpl
import io.github.rwpp.android.impl.action.actionPart.SetOperationActionPartImpl
import io.github.rwpp.android.impl.base.PointFImpl
import io.github.rwpp.android.impl.unit.custom.logicBooleans.LogicBooleanImpl
import io.github.rwpp.android.impl.utility.UnitConfigImpl
import io.github.rwpp.game.action.AbstractActionData
import io.github.rwpp.game.units.UnitRef
import io.github.rwpp.game.units.custom.CustomUnit
import io.github.rwpp.game.units.custom.UnitTypeRefBase
import io.github.rwpp.game.units.custom.logicBooleans.LogicBooleanReturnType
import io.github.rwpp.inject.Inject
import io.github.rwpp.inject.InjectClass
import io.github.rwpp.inject.InjectMode

@InjectClass(SetOperationActionPartInternal::class)
object SetOperationActionPartInject {
    var changeAlliance: LogicBooleanImpl? = null

    val self: SetOperationActionPartImpl = this as SetOperationActionPartImpl

    @Inject("a", InjectMode.InsertAfter)
    fun SetOperationActionPartInternal.parser(
        unitTypeRefBaseInternal: UnitTypeRefBaseInternal?,
        unitConfigInternal: UnitConfigInternal?,
        sectionName: String?, key: String?,
        customActionInternal: CustomActionInternal?) {
        val unitConfigImpl = unitConfigInternal as UnitConfigImpl

        changeAlliance = unitConfigImpl.getValueAsLogicBoolean(unitTypeRefBaseInternal as UnitTypeRefBase,sectionName,key+"changeAlliance",
            LogicBooleanReturnType.Number) as LogicBooleanImpl

        if(changeAlliance != null) {
            val setOperationActionPartImpl = SetOperationActionPartImpl()
            setOperationActionPartImpl.changeAlliance = changeAlliance

            (customActionInternal as CustomActionImpl).actionParts.add(setOperationActionPartImpl)
        }
    }

    @Inject("a", InjectMode.InsertAfter)
    fun SetOperationActionPartInternal.trigger(customUnitInternal: CustomUnitInternal?,
                                             abstractActionDataInternal: AbstractActionDataInternal?,
                                             pointF: PointF?, unitRefInternal: UnitRefInternal?, i: Int)
    {
        self.trigger(customUnitInternal as CustomUnit,abstractActionDataInternal as AbstractActionData,
            pointF?.let { PointFImpl(it) },unitRefInternal as UnitRef,i)

    }
}