package io.github.rwpp.android.impl.utility

import io.github.rwpp.android.impl.UnitConfigInternal
import io.github.rwpp.android.impl.UnitTypeRefBaseInternal
import io.github.rwpp.game.units.custom.LogicMessage
import io.github.rwpp.game.units.custom.UnitTypeRefBase
import io.github.rwpp.game.utility.UnitConfig
import io.github.rwpp.inject.SetInterfaceOn
import kotlin.String

@SetInterfaceOn([UnitConfigInternal::class])
interface UnitConfigImpl: UnitConfig {
    val self: UnitConfigInternal

    override fun getAltValueAsBoolean(sectionName: String?, key1: String?, key2: String?, defaultValue: Boolean?): Boolean?{
        return self.a(sectionName, key1, key2,defaultValue)
    }

    override fun getValueAsLogicMessage(
        unitTypeRefBase: UnitTypeRefBase?,
        sectionName: String?,
        key: String?,
        defaultValue: String?
    ): LogicMessage? {
        return self.a(unitTypeRefBase as UnitTypeRefBaseInternal, sectionName, key,defaultValue) as LogicMessage
    }
}
