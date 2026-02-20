package io.github.rwpp.game.units.custom.logicBooleans.numberFunctions

import io.github.rwpp.game.units.custom.logicBooleans.LogicBoolean

interface LogicNumberFunctionRawArgs: LogicNumberFunction {
    var value: LogicBoolean?

    abstract fun doFunction(value:Float): Float

    abstract fun validateNumberOfArguments(i: Int)
}