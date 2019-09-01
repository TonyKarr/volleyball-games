package com.tony.smit.core.entities

data class Place(val gameTypes: List<GameType>,
                 val placeType: PlaceType,
                 val photoUris: List<String>,
                 val city: String,
                 val country: String,
                 val address: String,
                 val latitude: Double,
                 val longitude: Double) {
}