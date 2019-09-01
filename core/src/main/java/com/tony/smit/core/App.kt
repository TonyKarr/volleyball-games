package com.tony.smit.core

import android.content.Context
import com.tony.smit.core.di.ApplicationProvider

interface App {
    fun getApplicationContext(): Context
    fun getAppComponent(): ApplicationProvider
}