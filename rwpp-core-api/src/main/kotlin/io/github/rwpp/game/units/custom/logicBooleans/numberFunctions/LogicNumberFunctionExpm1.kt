package io.github.rwpp.game.units.custom.logicBooleans.numberFunctions

import kotlin.math.expm1

interface LogicNumberFunctionExpm1: LogicNumberFunctionRawArgs {
    override fun doFunction(value: Float): Float {
        return expm1(value)
    }
}