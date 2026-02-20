package io.github.rwpp.game.units.custom.logicBooleans.numberFunctions

import kotlin.math.ln1p

interface LogicNumberFunctionLn1p: LogicNumberFunctionRawArgs {
    override fun doFunction(value: Float): Float {
        return ln1p(value)
    }
}