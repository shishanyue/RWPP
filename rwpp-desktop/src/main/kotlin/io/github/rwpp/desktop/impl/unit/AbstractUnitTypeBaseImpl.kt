package io.github.rwpp.desktop.impl.unit

import io.github.rwpp.appKoin
import io.github.rwpp.desktop.impl.AbstractUnitTypeBaseInternal
import io.github.rwpp.desktop.impl.UnitTypeRefBaseInternal
import io.github.rwpp.game.mod.Mod
import io.github.rwpp.game.mod.ModManager
import io.github.rwpp.game.units.AbstractUnitTypeBase
import io.github.rwpp.game.units.MovementType
import io.github.rwpp.inject.SetInterfaceOn

@SetInterfaceOn([AbstractUnitTypeBaseInternal::class])
interface AbstractUnitTypeBaseImpl : AbstractUnitTypeBase {
    val self: AbstractUnitTypeBaseInternal

    override val name: String
        get() = self.v()
    override val displayName: String
        get() = self.e()
    override val description: String
        get() = self.f()
    // Nevertheless, we can change it soon
//                    override val painter: Painter? = (it as? com.corrodinggames.rts.game.units.custom.l)?.ad?.let {
//                            runCatching {
//                                ImageIO.read(File(it.a().replace("/", "\\"))).toPainter()
//                            }.getOrElse { e ->
//                                println("error on reading path:${it.a()}")
//                                e.printStackTrace()
//                                null
//                            }
//                        }
    override val movementType: MovementType
        get() = MovementType.valueOf(self.o().name)

    override val isBuilder: Boolean
        get() = self.l()

    override val mod: Mod?
        get() = (self as? UnitTypeRefBaseInternal)?.J?.s?.let(appKoin.get<ModManager>()::getModByName)
}