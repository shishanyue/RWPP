package io.github.rwpp.android.impl.unit.custom

import io.github.rwpp.android.impl.UnitTypeRefBaseInternal
import io.github.rwpp.game.units.custom.UnitTypeRefBase
import io.github.rwpp.inject.SetInterfaceOn

@SetInterfaceOn([UnitTypeRefBaseInternal::class])
interface UnitTypeRefBaseImpl: UnitTypeRefBase {
    val self: UnitTypeRefBaseInternal

    override var metaCount: Int
        get() = self.S
        set(value) {self.S = value}
}