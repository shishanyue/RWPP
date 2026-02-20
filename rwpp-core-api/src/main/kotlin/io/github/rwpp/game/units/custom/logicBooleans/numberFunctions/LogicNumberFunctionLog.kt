package io.github.rwpp.game.units.custom.logicBooleans.numberFunctions

import kotlin.math.log


interface LogicNumberFunctionLog: LogicNumberFunction {
    fun doFunction(x:Float, base:Float):Float{
        return log(x,base)
    }
}