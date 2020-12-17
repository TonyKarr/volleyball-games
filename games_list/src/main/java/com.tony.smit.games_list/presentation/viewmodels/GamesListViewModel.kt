package com.tony.smit.games_list.presentation.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.tony.smit.games_list.domain.entities.GameViewData
import com.tony.smit.games_list.domain.interactors.GamesInteractor
import com.tony.smit.games_list.presentation.adapters.GameListAdapter

class GamesListViewModel(val interactor: GamesInteractor) : ViewModel() {

    val adapter = ObservableField(GameListAdapter())
    init{
        adapter.get()?.update(
            listOf(
                GameViewData("Test1"),
                GameViewData("Test2"),
                GameViewData("Test3"),
                GameViewData("Test4"),
                GameViewData("Test5")
            ))
    }
}

