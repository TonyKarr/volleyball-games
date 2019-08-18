package com.tony.smit.core.actions

import androidx.appcompat.app.AppCompatActivity

/**
 *
 * This code is created by Kovaliov Anton on 2019-08-03.
 *
 */

interface ShowFragmentAction{
    fun show(activity: AppCompatActivity, fragmentContainerId: Int)
}

interface ShowAuthAction: ShowFragmentAction
interface ShowUserInformationAction: ShowFragmentAction

interface ShowGameCreateAction: ShowFragmentAction
interface ShowGameListAction: ShowFragmentAction
interface ShowGameDetailsAction: ShowFragmentAction

interface ShowPlaceCreateAction: ShowFragmentAction
interface ShowPlaceListAction: ShowFragmentAction
interface ShowPlaceDetailsAction: ShowFragmentAction

interface ShowPlayerCreateAction: ShowFragmentAction
interface ShowPlayerListAction: ShowFragmentAction
interface ShowPlayerDetailsAction: ShowFragmentAction

interface ShowTeamCreateAction: ShowFragmentAction
interface ShowTeamListAction: ShowFragmentAction
interface ShowTeamDetailsAction: ShowFragmentAction

interface ShowTournamentCreateAction: ShowFragmentAction
interface ShowTournamentListAction: ShowFragmentAction
interface ShowTournamentDetailsAction: ShowFragmentAction

interface ShowSettingsAction: ShowFragmentAction
interface ShowPrivateAction: ShowFragmentAction