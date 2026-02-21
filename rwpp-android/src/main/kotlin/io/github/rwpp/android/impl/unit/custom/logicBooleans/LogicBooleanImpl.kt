package io.github.rwpp.android.impl.unit.custom.logicBooleans

import io.github.rwpp.android.impl.AbstractUnitAgentInternal
import io.github.rwpp.android.impl.LogicBooleanContextInternal
import io.github.rwpp.android.impl.LogicBooleanInternal
import io.github.rwpp.android.impl.UnitConfigInternal
import io.github.rwpp.android.impl.UnitTypeRefBaseInternal
import io.github.rwpp.game.units.AbstractUnitAgent
import io.github.rwpp.game.units.UnitRef
import io.github.rwpp.game.units.custom.UnitTypeRefBase
import io.github.rwpp.game.units.custom.logicBooleans.LogicBoolean
import io.github.rwpp.game.units.custom.logicBooleans.logicBooleanLoader.LogicBooleanContext
import io.github.rwpp.inject.SetInterfaceOn
import io.github.rwpp.utils.Reflect

@SetInterfaceOn([LogicBooleanInternal::class])
interface LogicBooleanImpl: LogicBoolean {
    val self: LogicBooleanInternal

    override val booleans: HashMap<String, LogicBoolean>
        get() = LogicBooleanImpl.booleans

    companion object{
        fun  addBooleanType(logicBoolean: LogicBoolean, logicBooleanDefinitions: Array<String>) {
            Reflect.callVoid<LogicBooleanInternal>(null,"addBooleanType",
                listOf(LogicBooleanInternal::class, Array<String>::class),
                listOf(logicBoolean as LogicBooleanInternal, logicBooleanDefinitions))

        }

        fun getAllParametersDebug(logicBoolean: LogicBoolean, abstractUnitAgent: AbstractUnitAgent){
            LogicBooleanInternal.getAllParametersDebug(logicBoolean as LogicBooleanInternal,abstractUnitAgent as AbstractUnitAgentInternal)
        }
        @Suppress("UNCHECKED_CAST")
        val booleans: HashMap<String, LogicBoolean>
            get() = Reflect.get<HashMap<String, LogicBooleanInternal>>(LogicBooleanInternal::class,"booleans") as HashMap<String, LogicBoolean>
    }

    override fun getAllParametersDebug(logicBoolean: LogicBoolean, abstractUnitAgent: AbstractUnitAgent) {
        LogicBooleanImpl.getAllParametersDebug(logicBoolean, abstractUnitAgent)
    }

    override fun setArgumentsRaw(arguments: String?, unitTypeRefBase: UnitTypeRefBase?, key: String?) {
        self.setArgumentsRaw(arguments, unitTypeRefBase as UnitTypeRefBaseInternal, key)
    }


    override fun addBooleanType(logicBoolean: LogicBoolean, logicBooleanDefinitions: Array<String>) {
        LogicBooleanImpl.addBooleanType(logicBoolean, logicBooleanDefinitions)
    }

    override fun readNumber(abstractUnitAgent: AbstractUnitAgent?): Float {
        return self.readNumber(abstractUnitAgent as AbstractUnitAgentInternal)
    }

    override fun read(abstractUnitAgent: AbstractUnitAgent?): Boolean {
        return self.read(abstractUnitAgent as AbstractUnitAgentInternal)
    }

    override fun readUnit(abstractUnitAgent: AbstractUnitAgent?): UnitRef? {
        return self.readUnit(abstractUnitAgent as AbstractUnitAgentInternal) as UnitRef
    }

    override fun readString(abstractUnitAgent: AbstractUnitAgent?): String? {
        return self.readString(abstractUnitAgent as AbstractUnitAgentInternal)
    }

    override fun validate(str: String?, str2: String?, str3: String?, logicBooleanContext: LogicBooleanContext?, z: Boolean) {
        self.validate(str, str2, str3, logicBooleanContext as LogicBooleanContextInternal, z)
    }

    override fun validateAndOptimize(str: String?, str2: String?, str3: String?,
                                     logicBooleanContext: LogicBooleanContext?, z: Boolean): LogicBoolean {
        return self.validateAndOptimize(str, str2, str3,
            logicBooleanContext as LogicBooleanContextInternal, z) as LogicBoolean
    }

    override fun getMatchFailReasonForPlayer(abstractUnitAgent: AbstractUnitAgent?): String? {
        return self.getMatchFailReasonForPlayer(abstractUnitAgent as AbstractUnitAgentInternal)
    }

}