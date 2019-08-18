package com.tony.smit.core.entities.statistics

import com.tony.smit.core.entities.GameType

/**
 *
 * This code is created by Kovaliov Anton on 2019-08-03.
 *
 */
data class PlayerSkillLevel(
    val id: Long,
    val playerId: Long,
    val gameType: GameType,
    val skillLevel: Int
) {
}