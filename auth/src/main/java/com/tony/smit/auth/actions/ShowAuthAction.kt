package com.tony.smit.auth.actions

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.tony.smit.auth.presentation.fragment.AuthFragment
import com.tony.smit.core.actions.ShowAuthAction
import javax.inject.Inject

class ShowAuthActionImpl @Inject constructor() : ShowAuthAction {
    override fun show(activity: Activity, fragmentContainerId: Int) {
        (activity as AppCompatActivity).supportFragmentManager.beginTransaction().apply {
            add(fragmentContainerId, AuthFragment.newInstance())
            commit()
        }
    }
}