package io.github.rwpp.android.impl.unit.custom

import io.github.rwpp.android.impl.LogicMessageInternal
import io.github.rwpp.game.units.custom.LogicMessage
import io.github.rwpp.inject.SetInterfaceOn

@SetInterfaceOn([LogicMessageInternal::class])
interface LogicMessageImpl: LogicMessage {
}