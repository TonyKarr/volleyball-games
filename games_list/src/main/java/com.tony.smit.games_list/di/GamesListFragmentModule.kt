package com.tony.smit.games_list.di

import com.tony.smit.games_list.domain.interactors.GamesInteractor
import com.tony.smit.games_list.domain.interactors.GamesInteractorImpl
import com.tony.smit.games_list.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface GamesListFragmentModule {

    @Binds
    fun bindInteractor(interactorImpl: GamesInteractorImpl): GamesInteractor

}