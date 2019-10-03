package com.tony.smit.core.entities

import java.util.*

/**
 *
 * This code is created by Kovaliov Anton on 2019-08-03.
 *
 */
data class Game(
    val gameIdentification: Long,
    val organization: Player,
    val place: Place,
    val gameType: GameType,
    val dateStart: Date,
    val dateEnd: Date,
    val playerLimit: Int,
    val minSkillLevel: Double,
    val maxSkillLevel: Double,
    val minReliabilityLevel: Double
) {
}