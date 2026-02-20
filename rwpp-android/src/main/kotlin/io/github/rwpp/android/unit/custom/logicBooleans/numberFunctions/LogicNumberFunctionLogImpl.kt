package io.github.rwpp.android.unit.custom.logicBooleans.numberFunctions

import com.corrodinggames.rts.appFramework.GameViewOpenGL
import io.github.rwpp.android.impl.LogicBooleanInternal
import io.github.rwpp.android.impl.LogicBooleanParameterInternal
import io.github.rwpp.android.impl.LogicBooleanReturnTypeInternal
import io.github.rwpp.android.impl.unit.custom.logicBooleans.LogicBooleanImpl
import io.github.rwpp.game.units.AbstractUnitAgent
import io.github.rwpp.game.units.custom.logicBooleans.numberFunctions.LogicNumberFunctionLog

class LogicNumberFunctionLogImpl: LogicNumberFunctionLog, LogicNumberFunctionImpl() {
    @JvmField
    @field:LogicBooleanParameterInternal(positional = 0, required = GameViewOpenGL.retainGlContext, type = LogicBooleanReturnTypeInternal.number)
    var x: LogicBooleanInternal? = null

    @JvmField
    @field:LogicBooleanParameterInternal(positional = 1, required = GameViewOpenGL.retainGlContext, type = LogicBooleanReturnTypeInternal.number)
    var base: LogicBooleanInternal? = null


    override fun getName(): String {
        return "Log"
    }

    override fun readNumber(abstractUnitAgent: AbstractUnitAgent?): Float {
        val x = (x as LogicBooleanImpl).readNumber(abstractUnitAgent)
        val base = (base as LogicBooleanImpl).readNumber(abstractUnitAgent)
        return doFunction(x, base)
    }
}