package io.github.rwpp.game.units.custom.logicBooleans.numberFunctions

import kotlin.math.round

interface LogicNumberFunctionRound: LogicNumberFunctionRawArgs {
    override fun doFunction(value: Float): Float {
        return round(value)
    }
}