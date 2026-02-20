package io.github.rwpp.android.unit.custom.logicBooleans.numberFunctions

import io.github.rwpp.game.units.custom.logicBooleans.numberFunctions.LogicNumberFunctionCbrt

class LogicNumberFunctionCbrtImpl: LogicNumberFunctionCbrt, LogicNumberFunctionRawArgsImpl() {
    override fun getName(): String {
        return "Cbrt"
    }
}