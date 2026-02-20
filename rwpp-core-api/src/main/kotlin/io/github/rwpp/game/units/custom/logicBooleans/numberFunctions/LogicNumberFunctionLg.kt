package io.github.rwpp.game.units.custom.logicBooleans.numberFunctions

import kotlin.math.log10

interface LogicNumberFunctionLg: LogicNumberFunctionRawArgs {
    override fun doFunction(value: Float): Float {
        return log10(value)
    }
}