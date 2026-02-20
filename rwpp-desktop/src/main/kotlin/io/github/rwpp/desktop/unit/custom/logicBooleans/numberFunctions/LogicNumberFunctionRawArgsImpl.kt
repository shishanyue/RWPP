package io.github.rwpp.desktop.unit.custom.logicBooleans.numberFunctions

import com.corrodinggames.rts.gameFramework.utility.al
import io.github.rwpp.desktop.impl.AbstractUnitAgentInternal
import io.github.rwpp.desktop.impl.BooleanParseExceptionInternal
import io.github.rwpp.desktop.impl.LogicBooleanContextInternal
import io.github.rwpp.desktop.impl.LogicBooleanLoaderInternal
import io.github.rwpp.desktop.impl.LogicBooleanParameterInternal
import io.github.rwpp.desktop.impl.LogicBooleanReturnTypeInternal
import io.github.rwpp.desktop.impl.UnitTypeRefBaseInternal
import io.github.rwpp.desktop.impl.VariableScopeInternal
import io.github.rwpp.desktop.impl.unit.custom.logicBooleans.LogicBooleanImpl
import io.github.rwpp.game.units.AbstractUnitAgent
import io.github.rwpp.game.units.custom.UnitTypeRefBase
import io.github.rwpp.game.units.custom.logicBooleans.LogicBoolean
import io.github.rwpp.game.units.custom.logicBooleans.logicBooleanLoader.LogicBooleanContext

abstract class LogicNumberFunctionRawArgsImpl: LogicNumberFunctionRawArgsBaseImpl() {
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

    @Suppress("UNCHECKED_CAST")
    override fun setArgumentsRaw(arguments: String?, unitTypeRefBase: UnitTypeRefBase?, key: String?) {
        if (str == null || VariableScopeInternal.nullOrMissingString.equals(str, ignoreCase = true)) {
            validateNumberOfArguments(0)
            return
        }
        val arrayListA: ArrayList<String> = al.a(str, ",", false) as ArrayList<String>
        validateNumberOfArguments(arrayListA.size)
        this.value = LogicBooleanLoaderInternal.parseNumberBlock(unitTypeRefBase as UnitTypeRefBaseInternal, arrayListA[0]) as LogicBoolean
        if (this.value == null) {
            throw BooleanParseExceptionInternal("Expected non-null argument")
        }
    }

    override fun validate(str: String?, str2: String?, str3: String?, logicBooleanContext: LogicBooleanContext?, z: Boolean) {
        super.validate(str, str2, str3, logicBooleanContext, z);
        if (this.value == null) {
            throw BooleanParseExceptionInternal("Expected parameters missing");
        }
        if (z) {
            throw BooleanParseExceptionInternal("Expected function:$str to return a boolean, but it returns a number");
        }

    }

    override fun validateAndOptimize(str: String?, str2: String?, str3: String?, logicBooleanContext: LogicBooleanContext?, z: Boolean): LogicBoolean {
        validate(str, str2, str3, logicBooleanContext as LogicBooleanContextInternal, z)


        return this
    }

    override fun readNumber(abstractUnitAgentInternal: AbstractUnitAgentInternal?): Float {
        return readNumber(abstractUnitAgentInternal as AbstractUnitAgent)
    }

    override fun readNumber(abstractUnitAgent: AbstractUnitAgent?): Float {
        return doFunction((value as LogicBooleanImpl).readNumber(abstractUnitAgent))
    }
}