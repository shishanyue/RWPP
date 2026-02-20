package io.github.rwpp.game.units.custom.logicBooleans.numberFunctions

import kotlin.math.absoluteValue

interface LogicNumberFunctionAbs: LogicNumberFunctionRawArgs {
    override fun doFunction(value: Float): Float {
        return value.absoluteValue
    }
}