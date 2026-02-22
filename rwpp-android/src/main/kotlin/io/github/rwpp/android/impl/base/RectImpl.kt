package io.github.rwpp.android.impl.base

import android.graphics.Rect

class RectImpl(
    val rect: Rect
) : io.github.rwpp.game.base.Rect {
    override val bottom: Float
        get() = rect.bottom.toFloat()

    override val left: Float
        get() = rect.left.toFloat()

    override val right: Float
        get() = rect.right.toFloat()

    override val top: Float
        get() = rect.top.toFloat()
}