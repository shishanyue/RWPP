package io.github.rwpp.game.units.custom.logicBooleans.numberFunctions

import kotlin.math.ln

interface LogicNumberFunctionLn: LogicNumberFunctionRawArgs {
    override fun doFunction(value: Float): Float {
        return ln(value)
    }
}