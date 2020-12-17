package com.tony.smit.auth.di.export

import com.tony.smit.auth.actions.*
import com.tony.smit.core.actions.ShowAuthAction
import com.tony.smit.core.actions.ShowSignupAction
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface AuthFragmentExportModule {

    @Binds
    fun showAuthAction(showAuthActionImpl: ShowAuthActionImpl): ShowAuthAction

    @Binds
    fun showSignupAction(showSignupActionImpl: ShowSignupActionImpl): ShowSignupAction
}