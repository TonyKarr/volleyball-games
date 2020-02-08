package com.tony.smit.auth.actions

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.tony.smit.auth.presentation.fragment.SignupFragment
import com.tony.smit.core.actions.ShowSignupAction
import javax.inject.Inject

class ShowSignupActionImpl @Inject constructor() : ShowSignupAction {
    override fun show(activity: Activity, fragmentContainerId: Int) {
        (activity as AppCompatActivity).supportFragmentManager.beginTransaction().apply {
            add(fragmentContainerId, SignupFragment.newInstance())
            commit()
        }
    }
}