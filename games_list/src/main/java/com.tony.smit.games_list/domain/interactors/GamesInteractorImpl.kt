package com.tony.smit.games_list.domain.interactors

import com.tony.smit.core.entities.GameType
import com.tony.smit.core.entities.PlaceType
import com.tony.smit.games_list.domain.entities.GameViewData
import io.reactivex.Maybe
import io.reactivex.Observable
import javax.inject.Inject

class GamesInteractorImpl @Inject constructor() : GamesInteractor {
    override fun loadGamesList(type: GameType): Maybe<List<GameViewData>> {
        return getGamesList()
    }

    override fun loadGamesList(type: GameType, placeType: PlaceType): Maybe<List<GameViewData>> {
        return getGamesList()
    }

    // TIME
    private fun getGamesList(): Maybe<List<GameViewData>> {
        val gameViewDataList = arrayListOf<GameViewData>(
            GameViewData("First"),
            GameViewData("Second"),
            GameViewData("Third"),
            GameViewData("First"),
            GameViewData("Second"),
            GameViewData("Third"),
            GameViewData("First"),
            GameViewData("Second"),
            GameViewData("Third"),
            GameViewData("First"),
            GameViewData("Second"),
            GameViewData("Third")
        )
        return Maybe.just(gameViewDataList)
    }
}