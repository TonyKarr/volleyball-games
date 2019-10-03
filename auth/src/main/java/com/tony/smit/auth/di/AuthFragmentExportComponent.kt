package com.tony.smit.auth.di

import com.tony.smit.core.di.MainToolsProvider
import com.tony.smit.core.di.PresentationProvider
import dagger.Component


@Component(dependencies = [MainToolsProvider::class],
    modules = [AuthFragmentExportModule::class])
interface AuthFragmentExportComponent: PresentationProvider {

    class Initializer private constructor(){
        companion object{
            fun init(mainToolsProvider: MainToolsProvider): PresentationProvider =
                DaggerAuthFragmentExportComponent
                    .builder()
                    .mainToolsProvider(mainToolsProvider)
                    .build()
        }
    }
}