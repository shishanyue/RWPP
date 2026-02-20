package io.github.rwpp.desktop.unit.custom.logicBooleans.numberFunctions

import io.github.rwpp.game.units.custom.logicBooleans.numberFunctions.LogicNumberFunctionTruncate

class LogicNumberFunctionTruncateImpl: LogicNumberFunctionTruncate, LogicNumberFunctionRawArgsImpl() {
    override fun getName(): String {
        return "Truncate"
    }
}