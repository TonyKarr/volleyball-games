package com.tony.smit.core.entities

/**
 *
 * This code is created by Kovaliov Anton on 2019-08-03.
 *
 */
data class Team(
    val id: Long,
    val name: String,
    val gameType: GameType,
    val city: String,
    val country: String
) {
}