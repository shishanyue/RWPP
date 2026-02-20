package io.github.rwpp.game.units.custom.logicBooleans.numberFunctions

import kotlin.math.ceil

interface LogicNumberFunctionCeil : LogicNumberFunctionRawArgs{
    override fun doFunction(value: Float): Float {
        return ceil(value)
    }
}