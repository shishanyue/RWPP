package io.github.rwpp.android.impl.unit.custom

import io.github.rwpp.android.impl.CustomUnitInternal
import io.github.rwpp.game.Player
import io.github.rwpp.game.units.custom.CustomUnit
import io.github.rwpp.inject.SetInterfaceOn

@SetInterfaceOn([CustomUnitInternal::class])
interface CustomUnitImpl: CustomUnit {
    val self: CustomUnitInternal
    override val player: Player?
        get() = self.bZ as Player?
}