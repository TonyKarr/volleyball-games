package com.tony.smit.core.actions

import android.app.Activity

interface ShowFragmentAction{
    fun show(activity: Activity, fragmentContainerId: Int)
}

interface ShowAuthAction: ShowFragmentAction
interface ShowSignupAction: ShowFragmentAction
interface ShowGamesListFragmentAction: ShowFragmentAction