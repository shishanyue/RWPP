package io.github.rwpp.android.impl.unit

import io.github.rwpp.android.impl.AbstractUnitTypeBaseInternal
import io.github.rwpp.android.impl.UnitTypeRefBaseInternal
import io.github.rwpp.appKoin
import io.github.rwpp.game.mod.Mod
import io.github.rwpp.game.mod.ModManager
import io.github.rwpp.game.units.AbstractUnitTypeBase
import io.github.rwpp.game.units.MovementType
import io.github.rwpp.inject.SetInterfaceOn

@SetInterfaceOn([AbstractUnitTypeBaseInternal::class])
interface AbstractUnitTypeBaseImpl : AbstractUnitTypeBase {
    val self: AbstractUnitTypeBaseInternal
    override val name: String
        get() = self.i()
    override val displayName: String
        get() = self.e()
    override val description: String
        get() = self.f()
    override val movementType: MovementType
        get() = MovementType.valueOf(self.o().name)
    override val mod: Mod?
        get() = (self as? UnitTypeRefBaseInternal)?.J?.q?.let(appKoin.get<ModManager>()::getModByName)
}