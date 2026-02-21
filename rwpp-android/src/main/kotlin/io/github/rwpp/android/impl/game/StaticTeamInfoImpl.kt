package io.github.rwpp.android.impl.game

import io.github.rwpp.android.impl.StaticTeamInfoInternal
import io.github.rwpp.game.StaticTeamInfo
import io.github.rwpp.inject.SetInterfaceOn

@SetInterfaceOn([StaticTeamInfoInternal::class])
interface StaticTeamInfoImpl: StaticTeamInfo {
}