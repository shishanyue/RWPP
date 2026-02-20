package io.github.rwpp.desktop.unit.custom.logicBooleans.numberFunctions

import io.github.rwpp.desktop.impl.BooleanParseExceptionInternal
import io.github.rwpp.desktop.impl.LogicBooleanContextInternal
import io.github.rwpp.desktop.impl.LogicBooleanInternal
import io.github.rwpp.desktop.impl.LogicBooleanParameterInternal
import io.github.rwpp.desktop.impl.LogicBooleanReturnTypeInternal
import io.github.rwpp.desktop.impl.LogicNumberFunctionInternal
import io.github.rwpp.desktop.impl.UnitTypeRefBaseInternal
import io.github.rwpp.game.units.AbstractUnitAgent
import io.github.rwpp.game.units.custom.UnitTypeRefBase
import io.github.rwpp.game.units.custom.logicBooleans.LogicBoolean
import io.github.rwpp.game.units.custom.logicBooleans.numberFunctions.LogicNumberFunctionRawArgs
import io.github.rwpp.game.units.custom.logicBooleans.logicBooleanLoader.LogicBooleanContext

abstract class LogicNumberFunctionRawArgsBaseImpl: LogicNumberFunctionRawArgs, LogicNumberFunctionInternal() {
    @LogicBooleanParameterInternal(type = LogicBooleanReturnTypeInternal.number)
    override var value: LogicBoolean? = null

    override fun validateNumberOfArguments(i: Int) {
        if (i != 1) {
            throw BooleanParseExceptionInternal("Expected 1 argument");
        }
    }

    override fun getMatchFailReasonForPlayer(abstractUnitAgent: AbstractUnitAgent?): String? {
        return "${name}(${this.value!!.getMatchFailReasonForPlayer(abstractUnitAgent)})"
    }

    override fun setArgumentsRaw(p0: String?, unitTypeRefBaseInternal: UnitTypeRefBaseInternal?, p2: String?) {
        setArgumentsRaw(p0, unitTypeRefBaseInternal as UnitTypeRefBase, p2)
    }

    override fun validate(p0: String?, p1: String?, p2: String?, p3: LogicBooleanContextInternal, p4: Boolean) {
        validate(p0, p1, p2, p3 as LogicBooleanContext, p4)
    }

    override fun validateAndOptimize(p0: String?, p1: String?, p2: String?, p3: LogicBooleanContextInternal, p4: Boolean): LogicBooleanInternal? {
        return validateAndOptimize(p0, p1, p2, p3 as LogicBooleanContext, p4) as LogicBooleanInternal
    }

}