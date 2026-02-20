package io.github.rwpp.android.unit.custom.logicBooleans.numberFunctions

import com.corrodinggames.rts.gameFramework.utility.ao
import io.github.rwpp.android.impl.*
import io.github.rwpp.game.units.AbstractUnitAgent
import io.github.rwpp.game.units.custom.UnitTypeRefBase
import io.github.rwpp.game.units.custom.logicBooleans.LogicBoolean
import io.github.rwpp.game.units.custom.logicBooleans.logicBooleanLoader.LogicBooleanContext
import io.github.rwpp.game.units.custom.logicBooleans.numberFunctions.LogicNumberFunction


abstract class LogicNumberFunctionImpl: LogicNumberFunctionInternal(), LogicNumberFunction {

    override fun setArgumentsRaw(arguments: String?, unitTypeRefBase: UnitTypeRefBase?, key: String?) {
        setArgumentsRaw(arguments, unitTypeRefBase as UnitTypeRefBaseInternal, key)
    }

    override fun validate(str: String?, str2: String?, str3: String?, logicBooleanContext: LogicBooleanContext?, z: Boolean) {
        validate(str, str2, str3, logicBooleanContext as LogicBooleanContextInternal, z)
    }

    override fun validateAndOptimize(str: String?, str2: String?, str3: String?, logicBooleanContext: LogicBooleanContext?, z: Boolean): LogicBoolean {
        validateAndOptimize(str, str2, str3, logicBooleanContext as LogicBooleanContextInternal, z)
        return this
    }

    override fun read(abstractUnitAgent: AbstractUnitAgent?): Boolean {
        return false
    }

    abstract override fun getName(): String

    abstract override fun readNumber(abstractUnitAgent: AbstractUnitAgent?): Float

    override fun readNumber(abstractUnitAgentInternal: AbstractUnitAgentInternal?): Float {
        return readNumber(abstractUnitAgentInternal as AbstractUnitAgent)
    }
}