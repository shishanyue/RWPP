package io.github.rwpp.desktop.impl.inject.unit

import com.corrodinggames.rts.game.units.custom.ab
import com.corrodinggames.rts.game.units.custom.ac
import io.github.rwpp.desktop.impl.UnitTypeRefBaseInternal
import io.github.rwpp.event.broadcast
import io.github.rwpp.event.events.ModCheckEvent
import io.github.rwpp.inject.Inject
import io.github.rwpp.inject.InjectClass
import io.github.rwpp.inject.InjectMode
import io.github.rwpp.inject.InterruptResult
import io.github.rwpp.utils.Reflect
import kotlinx.coroutines.runBlocking
import java.util.HashMap

@InjectClass(UnitTypeRefBaseInternal::class)
object UnitTypeRefBaseInject {
    @Inject("a", InjectMode.InsertBefore)
    fun onCheckUnitData(ab: ab, map: HashMap<*, ac>): Any {
        val requiredMods = map.values.mapNotNull { Reflect.get<String>(it, "a")  }
        val event = runBlocking { ModCheckEvent(requiredMods).broadcast() }
        return if (event.isIntercepted) InterruptResult() else Unit
    }
}