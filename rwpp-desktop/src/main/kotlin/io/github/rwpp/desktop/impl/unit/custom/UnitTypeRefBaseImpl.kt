package io.github.rwpp.desktop.impl.unit.custom

import io.github.rwpp.desktop.impl.UnitTypeRefBaseInternal
import io.github.rwpp.game.units.custom.UnitTypeRefBase
import io.github.rwpp.inject.SetInterfaceOn

@SetInterfaceOn([UnitTypeRefBaseInternal::class])
interface UnitTypeRefBaseImpl: UnitTypeRefBase {
    val self: UnitTypeRefBaseInternal

    override var metaCount: Int
        get() = self.S
        set(value) {self.S = value}
}