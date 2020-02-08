package com.tony.smit.auth.presentation.fragment

import com.tony.smit.auth.R
import com.tony.smit.auth.di.AuthFragmentComponent
import com.tony.smit.auth.presentation.utils.ViewModelFactory
import com.tony.smit.auth.presentation.viewmodel.SignupViewModel
import com.tony.smit.core.di.ApplicationProvider
import com.tony.smit.fragment_view.presentation.fragments.BaseFragment

class SignupFragment : BaseFragment<SignupViewModel, ViewModelFactory>() {

    companion object {
        fun newInstance() = AuthFragment()
    }

    override val viewModelClazz = SignupViewModel::class.java
    override val layoutResourceInt = R.layout.fragment_signin

    override fun inject(applicationProvider: ApplicationProvider) {
        AuthFragmentComponent
            .Initializer
            .init(applicationProvider)
            .inject(this)
    }
}
