package io.github.rwpp.game.utility

import io.github.rwpp.game.units.custom.LogicMessage
import io.github.rwpp.game.units.custom.UnitTypeRefBase
import io.github.rwpp.game.units.custom.logicBooleans.LogicBoolean
import io.github.rwpp.game.units.custom.logicBooleans.LogicBooleanReturnType


interface UnitConfig {

    companion object {
        fun getValueAsLogicBoolean(str: String?, unitTypeRefBase: UnitTypeRefBase?, str2: String?, str3: String?, returnType: LogicBooleanReturnType): LogicBoolean?{
            return null
        }
    }


    fun getValue(sectionName: String?, key: String?, throwsException: Boolean): String?

    fun getAltValue(sectionName: String?, key1: String?, key2: String?): String?

    fun getAltValueAsBoolean(sectionName: String?, key1: String?, key2: String?, defaultValue: Boolean?): Boolean?

    fun getValueAsBoolean(sectionName: String?, key: String?, defaultValue: Boolean?): Boolean?

    fun getValueAsLogicMessage(unitTypeRefBase: UnitTypeRefBase?, sectionName: String?,
                               key: String?, defaultValue: String?): LogicMessage?

    fun getValueAsLogicBooleanOrDefault(unitTypeRefBase: UnitTypeRefBase?, sectionName: String?, key: String?, logicBoolean: LogicBoolean?
    ): LogicBoolean?

    fun getValueAsPrimeBoolean(sectionName: String?, key: String?): Boolean?

    fun getValueAsStaticString(sectionName: String?, key: String?, defaultValue: String?): String?

    fun getValueAndRecordOrNull(sectionName: String?, key: String?): String?

    fun getValueAndRecord(sectionName: String?, key: String?): String?

    fun getValueAsMultiline(str: String?): String?

    fun getValueAsUnit(unitTypeRefBase: UnitTypeRefBase?, sectionName: String?, key: String?): LogicBoolean

    fun getValueAsNumber(unitTypeRefBase: UnitTypeRefBase?, sectionName: String?, key: String?): LogicBoolean

    fun getValueAsLogicBoolean(unitTypeRefBase: UnitTypeRefBase?, sectionName: String?, key: String?, returnType: LogicBooleanReturnType): LogicBoolean?

    fun getValueAsSpawnUnitArgs(str: String?, unitTypeRefBase: UnitTypeRefBase?, str2: String?, str3: String?): LogicBoolean

    fun getValueAsLogicBoolean(str: String?, unitTypeRefBase: UnitTypeRefBase?, str2: String?, str3: String?, returnType: LogicBooleanReturnType): LogicBoolean?{
        return UnitConfig.getValueAsLogicBoolean(str, unitTypeRefBase, str2, str3, returnType)
    }

}
