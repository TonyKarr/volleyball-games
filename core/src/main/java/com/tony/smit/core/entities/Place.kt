package com.tony.smit.core.entities

/**
 *
 * This code is created by Kovaliov Anton on 2019-08-03.
 *
 */
data class Place(val id: Long,
                 val gameTypes: List<GameType>,
                 val placeType: PlaceType,
                 val photoUris: List<String>,
                 val city: String,
                 val country: String,
                 val address: String,
                 val latitude: Double,
                 val longitude: Double) {
}