package com.tony.smit.games_list.domain.interactors

import com.tony.smit.core.entities.GameType
import com.tony.smit.core.entities.PlaceType
import com.tony.smit.games_list.domain.entities.GameViewData
import io.reactivex.Maybe

interface GamesInteractor {

    fun loadGamesList(type: GameType): Maybe<List<GameViewData>>

    fun loadGamesList(type: GameType, placeType: PlaceType): Maybe<List<GameViewData>>
}