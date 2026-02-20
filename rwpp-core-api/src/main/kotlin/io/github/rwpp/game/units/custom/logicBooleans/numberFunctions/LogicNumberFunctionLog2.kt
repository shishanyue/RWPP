package io.github.rwpp.game.units.custom.logicBooleans.numberFunctions

import kotlin.math.log2

interface LogicNumberFunctionLog2: LogicNumberFunctionRawArgs {
    override fun getName(): String {
        return "Log2"
    }
    override fun doFunction(value: Float): Float {
        return log2(value)
    }
}