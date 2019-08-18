package com.tony.smit.core.entities

import java.util.*

/**
 *
 * This code is created by Kovaliov Anton on 2019-08-03.
 *
 */
data class Tournament(
    val id: Long,
    val tournamentIdentification: Long,
    val organisationId: Long,
    val placeId: Long,
    val gameType: GameType,
    val teamLimit: Int,
    val dateStart: Date,
    val dateEnd: Date,
    val minSkillLevel: Double,
    val maxSkillLevel: Double
) {
}