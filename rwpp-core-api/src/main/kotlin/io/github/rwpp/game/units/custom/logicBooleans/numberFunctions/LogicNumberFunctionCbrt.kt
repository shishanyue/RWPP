package io.github.rwpp.game.units.custom.logicBooleans.numberFunctions

import kotlin.math.cbrt

interface LogicNumberFunctionCbrt: LogicNumberFunctionRawArgs {
    override fun doFunction(value: Float): Float {
        return cbrt(value)
    }
}