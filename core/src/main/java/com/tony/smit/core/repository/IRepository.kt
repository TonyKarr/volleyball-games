package com.tony.smit.core.repository

import com.tony.smit.core.entities.*
import com.tony.smit.core.entities.dynamic.PlayerGame
import com.tony.smit.core.entities.dynamic.PlayerTeam
import com.tony.smit.core.entities.dynamic.TeamTournament
import com.tony.smit.core.entities.statistics.GameSkillLevel
import com.tony.smit.core.entities.statistics.TournamentSkillLevel

/**
 *
 * This code is created by Kovaliov Anton on 2019-08-03.
 *
 */
interface IRepository :
    IUserRepo,
    IGameRepo,
    IPlaceRepo,
    IPlayerRepo,
    ITeamRepo,
    ITournamentRepo

interface IUserRepo {
}

interface IGameRepo {
}

interface IPlaceRepo {
}

interface IPlayerRepo {
}

interface ITeamRepo {
}

interface ITournamentRepo {
}