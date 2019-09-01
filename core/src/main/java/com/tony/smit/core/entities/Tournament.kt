package com.tony.smit.core.entities

import java.util.*

data class Tournament(
    val tournamentIdentification: Long,
    val organisation: Player,
    val place: Place,
    val gameType: GameType,
    val teamLimit: Int,
    val dateStart: Date,
    val dateEnd: Date,
    val minSkillLevel: Double,
    val maxSkillLevel: Double
)