package com.tony.smit.fragment_view.presentation.fragments

import android.content.Context
import android.os.BaseBundle
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.tony.smit.core.App
import com.tony.smit.core.di.ApplicationProvider
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseFragment<
        V : ViewModel,
        F : ViewModelProvider.Factory> : Fragment() {

    @Inject
    lateinit var viewModelFactory: F

    abstract val viewModelClazz: Class<V>

    abstract val resourceInt: Int

    private val viewModel: V by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(viewModelClazz)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(resourceInt, container, false)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject(getApplicationProvider(context.applicationContext))
    }

    private fun getApplicationProvider(applicationContext: Context) =
        (applicationContext as App).getAppComponent()

    abstract fun inject(applicationProvider: ApplicationProvider)
}