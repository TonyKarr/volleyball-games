package com.tony.smit.core.di

import com.tony.smit.core.App
import com.tony.smit.core.actions.*
import com.tony.smit.core.repository.IRepository
import com.tony.smit.core.tools.ILogger

/**
 *
 * This code is created by Kovaliov Anton on 2019-08-03.
 *
 */

interface ApplicationProvider :
    MainToolsProvider,
    UiProvider,
    RepositoryProvider

interface MainToolsProvider {
    fun provideContext(): App
    fun provideLogger(): ILogger
}

interface RepositoryProvider {
    fun provideRepository(): IRepository
}

interface UiProvider {
    fun provideShowAuthAction(): ShowAuthAction
    fun provideShowUserInformationAction(): ShowUserInformationAction

    fun provideShowGameCreateAction(): ShowGameCreateAction
    fun provideShowGameListAction(): ShowGameListAction
    fun provideShowGameDetailsAction(): ShowGameDetailsAction

    fun provideShowPlaceCreateAction(): ShowPlaceCreateAction
    fun provideShowPlaceListAction(): ShowPlaceListAction
    fun provideShowPlaceDetailsAction(): ShowPlaceDetailsAction

    fun provideShowPlayerCreateAction(): ShowPlayerCreateAction
    fun provideShowPlayerListAction(): ShowPlayerListAction
    fun provideShowPlayerDetailsAction(): ShowPlayerDetailsAction

    fun provideShowTeamCreateAction(): ShowTeamCreateAction
    fun provideShowTeamListAction(): ShowTeamListAction
    fun provideShowTeamDetailsAction(): ShowTeamDetailsAction

    fun provideShowTournamentCreateAction(): ShowTournamentCreateAction
    fun provideShowTournamentListAction(): ShowTournamentListAction
    fun provideShowTournamentDetailsAction(): ShowTournamentDetailsAction

    fun provideShowSettingsAction(): ShowSettingsAction
    fun provideShowPrivateAction(): ShowPrivateAction
}