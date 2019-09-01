package com.tony.smit.core.tools

import android.util.Log

interface ILogger {
    fun log(message: String){
        Log.d("DEBUG", message)
    }
}