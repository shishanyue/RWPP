package io.github.rwpp.game.units.custom.logicBooleans.numberFunctions

import kotlin.math.truncate

interface LogicNumberFunctionTruncate: LogicNumberFunctionRawArgs {
    override fun doFunction(value: Float): Float {
        return truncate(value)
    }
}