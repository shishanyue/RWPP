package io.github.rwpp.game.units.custom.logicBooleans.numberFunctions

import kotlin.math.sign

interface LogicNumberFunctionSign:LogicNumberFunctionRawArgs {
    override fun doFunction(value: Float): Float {
        return sign(value)
    }
}