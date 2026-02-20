package io.github.rwpp.android.unit.custom.logicBooleans.numberFunctions

import io.github.rwpp.game.units.custom.logicBooleans.numberFunctions.LogicNumberFunctionRound
import kotlin.math.round

class LogicNumberFunctionRoundImpl: LogicNumberFunctionRound, LogicNumberFunctionRawArgsImpl() {
    override fun getName(): String {
        return "round"
    }
}