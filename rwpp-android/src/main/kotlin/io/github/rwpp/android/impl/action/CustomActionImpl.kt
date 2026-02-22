package io.github.rwpp.android.impl.action

import io.github.rwpp.android.impl.CustomActionInternal
import io.github.rwpp.game.action.CustomAction
import io.github.rwpp.inject.SetInterfaceOn


@SetInterfaceOn([CustomActionInternal::class])
interface CustomActionImpl: CustomAction {

}