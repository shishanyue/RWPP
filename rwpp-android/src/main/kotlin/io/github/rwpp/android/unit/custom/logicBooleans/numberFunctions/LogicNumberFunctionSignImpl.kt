package io.github.rwpp.android.unit.custom.logicBooleans.numberFunctions

import io.github.rwpp.game.units.custom.logicBooleans.numberFunctions.LogicNumberFunctionSign

class LogicNumberFunctionSignImpl: LogicNumberFunctionSign, LogicNumberFunctionRawArgsImpl() {
    override fun getName(): String {
        return "Sign"
    }
}