package com.tony.smit.core.entities.statistics

import com.tony.smit.core.entities.GameType
import com.tony.smit.core.entities.Player

data class PlayerSkillLevel(
    val player: Player,
    val gameType: GameType,
    val skillLevel: Int
) {
}