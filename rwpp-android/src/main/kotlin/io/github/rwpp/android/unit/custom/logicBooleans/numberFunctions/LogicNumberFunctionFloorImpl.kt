package io.github.rwpp.android.unit.custom.logicBooleans.numberFunctions

import io.github.rwpp.game.units.custom.logicBooleans.numberFunctions.LogicNumberFunctionFloor

class LogicNumberFunctionFloorImpl: LogicNumberFunctionFloor,LogicNumberFunctionRawArgsImpl() {
    override fun getName(): String {
        return "Floor"
    }
}