package com.tony.smit.games_list.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tony.smit.games_list.domain.interactors.GamesInteractor
import com.tony.smit.games_list.domain.interactors.GamesInteractorImpl
import com.tony.smit.games_list.presentation.viewmodels.GamesListViewModel
import java.lang.ClassCastException
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(private val interactor: GamesInteractor) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            GamesListViewModel::class.java -> GamesListViewModel(interactor) as T
            else -> throw ClassCastException("Can't find viewmodel for class $modelClass")

        }
    }
}