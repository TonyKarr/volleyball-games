package com.tony.smit.auth.di.export

import com.tony.smit.auth.actions.*
import com.tony.smit.core.actions.ShowAuthAction
import com.tony.smit.core.actions.ShowSignupAction
import dagger.Module
import dagger.Provides

@Module
class AuthFragmentExportModule {

    @Provides
    fun showAuthAction(): ShowAuthAction = ShowAuthActionImpl()

    @Provides
    fun showSignupAction(): ShowSignupAction = ShowSignupActionImpl()
}