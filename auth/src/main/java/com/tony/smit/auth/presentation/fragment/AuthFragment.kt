package com.tony.smit.auth.presentation.fragment

import com.tony.smit.auth.R
import com.tony.smit.auth.di.AuthFragmentComponent
import com.tony.smit.auth.presentation.utils.ViewModelFactory
import com.tony.smit.auth.presentation.viewmodel.AuthViewModel
import com.tony.smit.core.di.ApplicationProvider
import com.tony.smit.fragment_view.presentation.fragments.BaseFragment

class AuthFragment : BaseFragment<AuthViewModel, ViewModelFactory>() {

    companion object {
        fun newInstance() = AuthFragment()
    }

    override val viewModelClazz = AuthViewModel::class.java
    override val resourceInt = R.layout.authorization_fragment

    override fun inject(applicationProvider: ApplicationProvider) {
        AuthFragmentComponent
            .Initializer
            .init(applicationProvider)
            .inject(this)
    }
}
