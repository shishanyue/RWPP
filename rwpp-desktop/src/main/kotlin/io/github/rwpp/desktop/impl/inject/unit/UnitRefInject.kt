package io.github.rwpp.desktop.impl.inject.unit

import android.graphics.Paint
import android.graphics.RectF
import io.github.rwpp.desktop.impl.UnitRefInternal
import io.github.rwpp.game.base.GamePaint
import io.github.rwpp.game.base.Rect
import io.github.rwpp.game.units.UnitRef
import io.github.rwpp.inject.Inject
import io.github.rwpp.inject.InjectClass
import io.github.rwpp.inject.InjectMode
import io.github.rwpp.inject.RedirectMethod

@InjectClass(UnitRefInternal::class)
object UnitRefInject {
    @Inject("p", InjectMode.InsertBefore)
    fun UnitRefInternal.onDraw(delta: Float) {
        (this as UnitRef).comp.onDraw(this, delta)
    }

    @RedirectMethod(
        "a",
        "(FZ)V",
        "com.corrodinggames.rts.gameFramework.m.y",
        "a"
    )
    @Suppress("TYPE_MISMATCH")
    fun UnitRefInternal.onDrawStoke(
        rectF: RectF, param: Paint
    ) {
        (this as UnitRef).comp.onDrawBar(this, rectF as Rect, param as GamePaint)
    }

}