package com.tony.smit.games_list.presentation.viewmodels

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.tony.smit.core.entities.GameType
import com.tony.smit.games_list.domain.entities.GameViewData
import com.tony.smit.games_list.domain.interactors.GamesInteractor
import com.tony.smit.games_list.presentation.adapters.GameListAdapter

class GamesListViewModel(val interactor: GamesInteractor) : ViewModel() {

    val adapter = ObservableField(GameListAdapter())

    init{
        interactor.loadGamesList(GameType.VOLLEYBALL)
            .subscribe { gameList -> adapter.get()?.update(gameList) }
    }

    override fun onCleared() {
        super.onCleared()
    }
}

