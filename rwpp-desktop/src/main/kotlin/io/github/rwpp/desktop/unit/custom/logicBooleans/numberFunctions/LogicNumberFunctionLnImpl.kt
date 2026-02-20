package io.github.rwpp.desktop.unit.custom.logicBooleans.numberFunctions

import io.github.rwpp.game.units.custom.logicBooleans.numberFunctions.LogicNumberFunctionLn

class LogicNumberFunctionLnImpl: LogicNumberFunctionLn, LogicNumberFunctionRawArgsImpl() {
    override fun getName(): String {
        return "Ln"
    }

}