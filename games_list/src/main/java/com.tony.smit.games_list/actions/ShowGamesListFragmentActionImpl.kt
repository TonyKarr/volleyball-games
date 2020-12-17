package com.tony.smit.games_list.actions

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.tony.smit.core.actions.ShowGamesListFragmentAction
import com.tony.smit.games_list.presentation.fragments.GamesListFragment
import javax.inject.Inject

class ShowGamesListFragmentActionImpl @Inject constructor() : ShowGamesListFragmentAction {
    override fun show(activity: Activity, fragmentContainerId: Int) {
        (activity as AppCompatActivity).supportFragmentManager.beginTransaction().apply {
            replace(fragmentContainerId, GamesListFragment.newInstance())
                .commit()
        }
    }
}