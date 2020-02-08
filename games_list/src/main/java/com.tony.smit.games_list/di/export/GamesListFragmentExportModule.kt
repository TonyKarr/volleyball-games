package com.tony.smit.games_list.di.export

import com.tony.smit.core.actions.ShowGamesListFragmentAction
import dagger.Module
import com.tony.smit.games_list.actions.ShowGamesListFragmentActionImpl
import dagger.Binds

@Module
interface GamesListFragmentExportModule {

    @Binds
    fun showGamesListFragmentAction(showGamesListFragmentActionImpl: ShowGamesListFragmentActionImpl): ShowGamesListFragmentAction
}