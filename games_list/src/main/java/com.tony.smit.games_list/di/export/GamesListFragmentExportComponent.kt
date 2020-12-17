package com.tony.smit.games_list.di.export

import com.tony.smit.core.di.GamesListFragmentProvider
import com.tony.smit.core.di.MainToolsProvider
import dagger.Component

@Component(
    dependencies = [MainToolsProvider::class],
    modules = [GamesListFragmentExportModule::class]
)
interface GamesListFragmentExportComponent : GamesListFragmentProvider {

    class Initializer private constructor() {
        companion object {
            fun init(mainToolsProvider: MainToolsProvider): GamesListFragmentProvider =
                DaggerGamesListFragmentExportComponent
                    .builder()
                    .mainToolsProvider(mainToolsProvider)
                    .build()
        }
    }
}
