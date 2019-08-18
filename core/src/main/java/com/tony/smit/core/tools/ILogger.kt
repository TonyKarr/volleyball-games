package com.tony.smit.core.tools

import android.util.Log

/**
 *
 * This code is created by Kovaliov Anton on 2019-08-03.
 *
 */
interface ILogger {
    fun log(message: String){
        Log.d("DEBUG", message)
    }
}