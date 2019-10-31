package com.tony.smit.auth.di

import com.tony.smit.auth.presentation.fragment.AuthFragment
import com.tony.smit.auth.presentation.fragment.SignupFragment
import com.tony.smit.core.di.ApplicationProvider
import com.tony.smit.core.di.MainToolsProvider
import dagger.Component

@Component(
    dependencies = [ApplicationProvider::class],
    modules = [AuthFragmentModule::class]
)
interface AuthFragmentComponent {
    fun inject(fragment: AuthFragment)
    fun inject(fragment: SignupFragment)

    class Initializer private constructor() {
        companion object {
            fun init(applicationProvider: ApplicationProvider): AuthFragmentComponent =
                DaggerAuthFragmentComponent
                    .builder()
                    .applicationProvider(applicationProvider)
                    .build()
        }
    }
}