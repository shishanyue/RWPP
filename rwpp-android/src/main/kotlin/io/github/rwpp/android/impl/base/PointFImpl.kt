package io.github.rwpp.android.impl.base

import android.graphics.PointF

class PointFImpl(var pointF: PointF): io.github.rwpp.game.base.PointF {

    override var x: Float
        get() = pointF.x
        set(value) {pointF.x = value}
    override var y: Float
        get() = pointF.y
        set(value) {pointF.y = value}
}