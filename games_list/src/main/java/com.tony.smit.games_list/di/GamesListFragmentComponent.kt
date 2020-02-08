package com.tony.smit.games_list.di

import com.tony.smit.core.di.ApplicationProvider
import com.tony.smit.games_list.presentation.fragments.GamesListFragment
import dagger.Component

@Component(
    dependencies = [ApplicationProvider::class],
    modules = [GamesListFragmentModule::class]
)
interface GamesListFragmentComponent {
    fun inject(fragment: GamesListFragment)

    class Initializer private constructor() {
        companion object {
            fun init(applicationProvider: ApplicationProvider): GamesListFragmentComponent =
                DaggerGamesListFragmentComponent
                    .builder()
                    .applicationProvider(applicationProvider)
                    .build()
        }
    }
}