package com.tony.smit.auth.presentation.viewmodel

import android.util.Log
import java.util.Timer
import kotlin.concurrent.schedule
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import java.util.*

class AuthViewModel : ViewModel() {
    var phone: String = ""
        set(value) {
            isErrorPhoneNumber.set(null)
            field = value
            isCorrectPhoneNumber.set(isPhoneCorrect(value))
        }
    val isCorrectPhoneNumber = ObservableBoolean(isPhoneCorrect(phone))
    val isErrorPhoneNumber = ObservableField<String>()
    val isProgress = ObservableBoolean(false)
    val isCodeSend = ObservableBoolean(false)

    private fun isPhoneCorrect(phone: String): Boolean {
        val matchResult =
            Regex("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{10}\$").find(phone)
        return matchResult?.let {
            true
        } ?: let {
            false
        }
    }

    fun requestCode() {
        if (isCorrectPhoneNumber.get()) {
            Log.d("DEBUG", "isProgress")
            isProgress.set(true)
            Timer("SettingUp", false).schedule(5000) {
                isProgress.set(false)
            }
        }
        else
            isErrorPhoneNumber.set("Телефонный номер указан не верно!")
    }
}
