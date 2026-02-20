package io.github.rwpp.game.units.custom.logicBooleans.numberFunctions

import kotlin.math.floor

interface LogicNumberFunctionFloor: LogicNumberFunctionRawArgs {
    override fun doFunction(value: Float): Float {
        return floor(value)
    }
}