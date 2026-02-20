package io.github.rwpp.desktop.impl.inject.unit.custom.logicBooleans

import io.github.rwpp.desktop.impl.unit.custom.logicBooleans.LogicBooleanImpl
import io.github.rwpp.desktop.unit.custom.logicBooleans.gameFunctions.IsBuildingBooleanImpl
import io.github.rwpp.desktop.unit.custom.logicBooleans.gameFunctions.IsSelectedBooleanImpl
import io.github.rwpp.desktop.unit.custom.logicBooleans.numberFunctions.LogicNumberFunctionAbsImpl
import io.github.rwpp.desktop.unit.custom.logicBooleans.numberFunctions.LogicNumberFunctionCbrtImpl
import io.github.rwpp.desktop.unit.custom.logicBooleans.numberFunctions.LogicNumberFunctionCeilImpl
import io.github.rwpp.desktop.unit.custom.logicBooleans.numberFunctions.LogicNumberFunctionExpm1Impl
import io.github.rwpp.desktop.unit.custom.logicBooleans.numberFunctions.LogicNumberFunctionFloorImpl
import io.github.rwpp.desktop.unit.custom.logicBooleans.numberFunctions.LogicNumberFunctionLgImpl
import io.github.rwpp.desktop.unit.custom.logicBooleans.numberFunctions.LogicNumberFunctionLn1pImpl
import io.github.rwpp.desktop.unit.custom.logicBooleans.numberFunctions.LogicNumberFunctionLnImpl
import io.github.rwpp.desktop.unit.custom.logicBooleans.numberFunctions.LogicNumberFunctionLog2Impl
import io.github.rwpp.desktop.unit.custom.logicBooleans.numberFunctions.LogicNumberFunctionRoundImpl
import io.github.rwpp.desktop.unit.custom.logicBooleans.numberFunctions.LogicNumberFunctionSignImpl
import io.github.rwpp.desktop.unit.custom.logicBooleans.numberFunctions.LogicNumberFunctionTruncateImpl
import io.github.rwpp.desktop.impl.LogicBooleanInternal
import io.github.rwpp.inject.InjectClass

@InjectClass(LogicBooleanInternal::class)
object LogicBooleanInject {

}

fun initCustomBooleans(){
    val logicBooleans = arrayOf(
        Pair(LogicNumberFunctionAbsImpl(),arrayOf("abs")),
        Pair(LogicNumberFunctionLnImpl(),arrayOf("ln")),
        Pair(IsBuildingBooleanImpl(),arrayOf("self.isBuilding")),
        Pair(IsSelectedBooleanImpl(),arrayOf("self.isSelected")),
        Pair(LogicNumberFunctionCbrtImpl(),arrayOf("cbrt")),
        Pair(LogicNumberFunctionExpm1Impl(),arrayOf("expm1")),
        Pair(LogicNumberFunctionFloorImpl(),arrayOf("floor")),
        Pair(LogicNumberFunctionCeilImpl(),arrayOf("ceil")),
        Pair(LogicNumberFunctionLgImpl(),arrayOf("lg")),
        Pair(LogicNumberFunctionLn1pImpl(),arrayOf("ln1p")),
        Pair(LogicNumberFunctionLog2Impl(),arrayOf("log2")),
        Pair(LogicNumberFunctionRoundImpl(),arrayOf("round")),
        Pair(LogicNumberFunctionSignImpl(),arrayOf("sign")),
        Pair(LogicNumberFunctionTruncateImpl(),arrayOf("truncate")),
    )

    for ((logicBoolean,logicBooleanDefinitions) in logicBooleans){
        LogicBooleanImpl.addBooleanType(logicBoolean,logicBooleanDefinitions)
    }
}
