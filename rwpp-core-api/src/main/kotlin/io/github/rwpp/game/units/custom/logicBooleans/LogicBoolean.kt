package io.github.rwpp.game.units.custom.logicBooleans

import io.github.rwpp.game.units.AbstractUnitAgent
import io.github.rwpp.game.units.UnitRef
import io.github.rwpp.game.units.custom.UnitTypeRefBase
import io.github.rwpp.game.units.custom.logicBooleans.logicBooleanLoader.LogicBooleanContext


interface LogicBoolean {

    companion object {
        val booleans: HashMap<String, LogicBoolean> = HashMap()

        val parameterMappings: HashMap<String, LogicBoolean> = HashMap()
        fun addBooleanType(logicBoolean: LogicBoolean, logicBooleanDefinitions: Array<String>) {}

        fun getAllParametersDebug(logicBoolean: LogicBoolean, abstractUnitAgent: AbstractUnitAgent){}
    }

    fun getAllParametersDebug(logicBoolean: LogicBoolean, abstractUnitAgent: AbstractUnitAgent){
        LogicBoolean.getAllParametersDebug(logicBoolean, abstractUnitAgent)
    }

    fun addBooleanType(logicBoolean: LogicBoolean, logicBooleanDefinitions: Array<String>) {
        LogicBoolean.addBooleanType(logicBoolean, logicBooleanDefinitions)
    }
    val booleans: HashMap<String, LogicBoolean>
        get() = LogicBoolean.booleans

    fun readNumber(abstractUnitAgent: AbstractUnitAgent?): Float{
        return -9999f
    }
    fun readString(abstractUnitAgent: AbstractUnitAgent?): String?{
        return null
    }
    fun readUnit(abstractUnitAgent: AbstractUnitAgent?): UnitRef?{
        return null
    }
    fun read(abstractUnitAgent: AbstractUnitAgent?): Boolean

    fun getMatchFailReasonForPlayer(abstractUnitAgent: AbstractUnitAgent?): String?

    fun setArgumentsRaw(arguments: String?, unitTypeRefBase: UnitTypeRefBase?, key: String?)

    fun validate(str: String?, str2: String?, str3: String?, logicBooleanContext: LogicBooleanContext?, z: Boolean) {}

    fun validateAndOptimize(str: String?, str2: String?, str3: String?, logicBooleanContext: LogicBooleanContext?, z: Boolean): LogicBoolean {
        validate(str, str2, str3, logicBooleanContext, z)
        return this
    }


}