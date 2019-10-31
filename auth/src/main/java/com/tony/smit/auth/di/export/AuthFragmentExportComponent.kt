package com.tony.smit.auth.di.export

import com.tony.smit.core.di.AuthorizationProvider
import com.tony.smit.core.di.MainToolsProvider
import dagger.Component


@Component(dependencies = [MainToolsProvider::class],
    modules = [AuthFragmentExportModule::class])
interface AuthFragmentExportComponent: AuthorizationProvider {

    class Initializer private constructor(){
        companion object{
            fun init(mainToolsProvider: MainToolsProvider): AuthorizationProvider =
                DaggerAuthFragmentExportComponent
                    .builder()
                    .mainToolsProvider(mainToolsProvider)
                    .build()
        }
    }
}