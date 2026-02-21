package io.github.rwpp.android.impl.action.actionPart

import io.github.rwpp.android.impl.SetOperationActionPartInternal
import io.github.rwpp.game.action.AbstractAction
import io.github.rwpp.inject.SetInterfaceOn

@SetInterfaceOn([SetOperationActionPartInternal::class])
interface SetOperationActionPartImpl: AbstractAction {

}