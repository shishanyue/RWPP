package io.github.rwpp.android.impl.inject.unit.custom.logicBooleans

import io.github.rwpp.android.impl.LogicBooleanGameFunctionsInternal
import io.github.rwpp.inject.Inject
import io.github.rwpp.inject.InjectClass
import io.github.rwpp.inject.InjectMode

@InjectClass(LogicBooleanGameFunctionsInternal::class)
object LogicBooleanGameFunctionsInject {
    @Inject(method ="loadTypes", InjectMode.InsertAfter)
    fun initCustomBooleansEnter(){
        initCustomBooleans()
    }
}