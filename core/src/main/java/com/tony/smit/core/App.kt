package com.tony.smit.core

import android.content.Context
import com.tony.smit.core.di.ApplicationProvider

/**
 *
 * This code is created by Kovaliov Anton on 2019-08-03.
 *
 */
interface App {
    fun getApplicationContext(): Context
    fun getAppComponent(): ApplicationProvider
}