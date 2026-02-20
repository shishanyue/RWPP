package io.github.rwpp.android.impl.inject.unit

import io.github.rwpp.android.impl.UnitRefInternal
import io.github.rwpp.game.units.UnitRef
import io.github.rwpp.inject.Inject
import io.github.rwpp.inject.InjectClass
import io.github.rwpp.inject.InjectMode

@InjectClass(UnitRefInternal::class)
object UnitRefInject {
    @Inject("n", InjectMode.InsertBefore)
    fun UnitRefInternal.onDraw(delta: Float) {
        (this as UnitRef).comp.onDraw(this, delta)
    }

//    @RedirectMethod(
//        "a",
//        "(FZ)V",
//        "com.corrodinggames.rts.gameFramework.m.fi",
//        "a"
//    )
//    fun onDrawBar(rectF: RectF, param: Paint) {
//        (this as GameUnit).comp.onDrawBar(this, rectF as Rect, param as GamePaint)
//    }
}