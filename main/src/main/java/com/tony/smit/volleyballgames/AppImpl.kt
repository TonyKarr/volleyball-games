package com.tony.smit.volleyballgames

import android.app.Application
import com.tony.smit.core.App
import com.tony.smit.core.di.ApplicationProvider
import com.tony.smit.volleyballgames.di.AppComponent

class AppImpl :Application(), App {

    private val appComponent: AppComponent by lazy {
        AppComponent
        .Initializer.init(this)}

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    override fun getAppComponent(): ApplicationProvider = appComponent
}
