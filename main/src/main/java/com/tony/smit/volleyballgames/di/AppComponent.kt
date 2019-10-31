package com.tony.smit.volleyballgames.di

import com.tony.smit.auth.di.export.AuthFragmentExportComponent
import com.tony.smit.core.App
import com.tony.smit.core.di.ApplicationProvider
import com.tony.smit.core.di.MainToolsProvider
import com.tony.smit.core.di.AuthorizationProvider
import dagger.Component

@Component(
    dependencies = [
        MainToolsProvider::class,
        AuthorizationProvider::class]
)
interface AppComponent : ApplicationProvider {

    fun inject(app: App)

    class Initializer private constructor() {
        companion object {
            fun init(app: App): AppComponent {
                val mainToolsProvider = MainToolsComponent.Initializer
                    .init(app)
                val authorizationProvider = AuthFragmentExportComponent.Initializer
                    .init(mainToolsProvider)
                return DaggerAppComponent.builder()
                    .mainToolsProvider(mainToolsProvider)
                    .authorizationProvider(authorizationProvider)
                    .build()
            }
        }
    }

}