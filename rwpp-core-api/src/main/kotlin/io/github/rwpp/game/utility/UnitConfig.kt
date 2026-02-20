package io.github.rwpp.game.utility

import io.github.rwpp.game.units.custom.LogicMessage
import io.github.rwpp.game.units.custom.UnitTypeRefBase
import kotlin.String

interface UnitConfig {
    fun getAltValueAsBoolean(sectionName: String?, key1: String?, key2: String?, defaultValue: Boolean?): Boolean?

    fun getValueAsLogicMessage(unitTypeRefBase: UnitTypeRefBase?, sectionName: String?,
                               key: String?, defaultValue: String?): LogicMessage?
}
