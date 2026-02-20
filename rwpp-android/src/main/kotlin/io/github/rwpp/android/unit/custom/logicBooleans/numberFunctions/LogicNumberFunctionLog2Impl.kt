package io.github.rwpp.android.unit.custom.logicBooleans.numberFunctions

import io.github.rwpp.game.units.custom.logicBooleans.numberFunctions.LogicNumberFunctionLog2
import kotlin.math.log2

class LogicNumberFunctionLog2Impl: LogicNumberFunctionLog2, LogicNumberFunctionRawArgsImpl() {
    override fun getName(): String {
        return "Log2"
    }
}