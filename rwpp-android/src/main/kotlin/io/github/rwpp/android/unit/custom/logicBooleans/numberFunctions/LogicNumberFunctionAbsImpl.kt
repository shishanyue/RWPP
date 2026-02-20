package io.github.rwpp.android.unit.custom.logicBooleans.numberFunctions

import io.github.rwpp.android.impl.unit.custom.logicBooleans.LogicBooleanImpl
import io.github.rwpp.game.units.AbstractUnitAgent
import io.github.rwpp.game.units.custom.logicBooleans.numberFunctions.LogicNumberFunctionAbs
import kotlin.math.absoluteValue

class LogicNumberFunctionAbsImpl: LogicNumberFunctionAbs, LogicNumberFunctionRawArgsImpl() {
    override fun getName(): String {
        return "Abs"
    }
}