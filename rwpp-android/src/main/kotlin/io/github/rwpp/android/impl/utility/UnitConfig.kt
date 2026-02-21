package io.github.rwpp.android.impl.utility

import io.github.rwpp.android.impl.LogicBooleanInternal
import io.github.rwpp.android.impl.LogicBooleanReturnTypeInternal
import io.github.rwpp.android.impl.UnitConfigInternal
import io.github.rwpp.android.impl.UnitTypeRefBaseInternal
import io.github.rwpp.game.units.custom.LogicMessage
import io.github.rwpp.game.units.custom.UnitTypeRefBase
import io.github.rwpp.game.units.custom.logicBooleans.LogicBoolean
import io.github.rwpp.game.units.custom.logicBooleans.LogicBooleanReturnType
import io.github.rwpp.game.utility.UnitConfig
import io.github.rwpp.inject.SetInterfaceOn
import io.github.rwpp.utils.Reflect


@SetInterfaceOn([UnitConfigInternal::class])
interface UnitConfigImpl: UnitConfig {

    val self: UnitConfigInternal

    override fun getValue(sectionName: String?, key: String?, throwsException: Boolean): String?{
        return Reflect.call<UnitConfigInternal,
                String>(self,"b",
            listOf(String::class,String::class, Boolean::class),
            listOf(sectionName,key,throwsException))
    }

    override fun getAltValue(sectionName: String?, key1: String?, key2: String?): String?{
        return Reflect.call<UnitConfigInternal,
                String>(self,"g",
            listOf(String::class,String::class,String::class),
            listOf(sectionName,key1,key2))
    }

    override fun getAltValueAsBoolean(sectionName: String?, key1: String?, key2: String?, defaultValue: Boolean?): Boolean?{
        return self.a(sectionName, key1, key2,defaultValue)
    }

    override fun getValueAsBoolean(sectionName: String?, key: String?, defaultValue: Boolean?): Boolean?{
        return self.a(sectionName,key,defaultValue)
    }

    override fun getValueAsLogicMessage(unitTypeRefBase: UnitTypeRefBase?, sectionName: String?, key: String?, defaultValue: String?): LogicMessage? {
        return self.a(unitTypeRefBase as UnitTypeRefBaseInternal, sectionName, key,defaultValue) as LogicMessage
    }

    override fun getValueAsLogicBooleanOrDefault(unitTypeRefBase: UnitTypeRefBase?, sectionName: String?, key: String?, logicBoolean: LogicBoolean?
    ): LogicBoolean?{
        return self.a(unitTypeRefBase as UnitTypeRefBaseInternal,sectionName,key,logicBoolean as LogicBooleanInternal) as LogicBoolean
    }

    override fun getValueAsPrimeBoolean(sectionName: String?, key: String?): Boolean?{
        return self.b(sectionName,key)
    }

    override fun getValueAsStaticString(sectionName: String?, key: String?, defaultValue: String?): String? {
        return self.a(sectionName,key,defaultValue)
    }

   override fun getValueAndRecordOrNull(sectionName: String?, key: String?): String? {
       return Reflect.call<UnitConfigInternal,
               String>(self,"p",
           listOf(String::class,String::class),
           listOf(sectionName,key))
    }

    override fun getValueAndRecord(sectionName: String?, key: String?): String? {
       return Reflect.call<UnitConfigInternal,
               String>(self,"q",
           listOf(String::class,String::class),
           listOf(sectionName,key))
    }

    override fun getValueAsMultiline(str: String?): String? {
      return Reflect.call<UnitConfigInternal,
              String>(self,"e",
          listOf(String::class),
          listOf(str))
    }

    override fun getValueAsUnit(unitTypeRefBase: UnitTypeRefBase?, sectionName: String?, key: String?): LogicBoolean {
        return self.b(unitTypeRefBase as UnitTypeRefBaseInternal,sectionName,key) as LogicBoolean
    }

    override fun getValueAsNumber(unitTypeRefBase: UnitTypeRefBase?, sectionName: String?, key: String?): LogicBoolean{
        return self.c(unitTypeRefBase as UnitTypeRefBaseInternal,sectionName,key) as LogicBoolean
    }

    override fun getValueAsSpawnUnitArgs(str: String?, unitTypeRefBase: UnitTypeRefBase?, str2: String?, str3: String?): LogicBoolean{
        return UnitConfigInternal.a(str,unitTypeRefBase as UnitTypeRefBaseInternal,str2,str3) as LogicBoolean
    }

    override fun getValueAsLogicBoolean(str: String?, unitTypeRefBase: UnitTypeRefBase?, str2: String?, str3: String?, returnType: LogicBooleanReturnType): LogicBoolean?{
        return Reflect.call<UnitConfigInternal,
                LogicBooleanInternal>(self,"a",
            listOf(String::class, UnitTypeRefBaseInternal::class,String::class,String::class,LogicBooleanReturnType::class),
            listOf(str,unitTypeRefBase as UnitTypeRefBaseInternal,str2,str3, returnType)) as LogicBoolean?
    }


}
