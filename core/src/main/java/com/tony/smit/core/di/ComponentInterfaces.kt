package com.tony.smit.core.di

import com.tony.smit.core.App
import com.tony.smit.core.actions.*
import com.tony.smit.core.tools.ILogger

interface ApplicationProvider :
    MainToolsProvider,
    PresentationProvider

interface MainToolsProvider {
    fun provideContext(): App
    fun provideLogger(): ILogger
}

interface PresentationProvider {
    fun provideShowAuthAction(): ShowAuthAction
    fun provideShowSignupAction(): ShowSignupAction
}