package com.tony.smit.core.entities

import java.util.*

/**
 *
 * This code is created by Kovaliov Anton on 2019-08-03.
 *
 */
data class Game(
    val id: Long,
    val gameIdentification: Long,
    val organizationId: Long,
    val placeId: Long,
    val gameType: GameType,
    val dateStart: Date,
    val dateEnd: Date,
    val playerLimit: Int,
    val minSkillLevel: Double,
    val maxSkillLevel: Double,
    val minReliabilityLevel: Double
) {
}