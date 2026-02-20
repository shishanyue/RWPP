package io.github.rwpp.desktop.unit.custom.logicBooleans.numberFunctions

import io.github.rwpp.game.units.custom.logicBooleans.numberFunctions.LogicNumberFunctionAbs

class LogicNumberFunctionAbsImpl: LogicNumberFunctionAbs, LogicNumberFunctionRawArgsImpl() {
    override fun getName(): String {
        return "Abs"
    }
}