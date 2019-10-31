package com.tony.smit.auth.presentation.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tony.smit.auth.presentation.viewmodel.AuthViewModel
import java.lang.ClassCastException
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when(modelClass){
            AuthViewModel::class.java -> AuthViewModel() as T
            else -> throw ClassCastException("Can't find viewmodel for class $modelClass")

        }
    }
}