package com.tony.smit.auth.presentation.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.tony.smit.auth.R
import com.tony.smit.auth.databinding.AuthorizationFragmentBinding
import com.tony.smit.auth.presentation.viewmodel.AuthViewModel
import kotlinx.android.synthetic.main.authorization_fragment.*
import ru.tinkoff.decoro.watchers.MaskFormatWatcher
import ru.tinkoff.decoro.slots.PredefinedSlots
import ru.tinkoff.decoro.MaskImpl




class AuthFragment : Fragment() {

    companion object {
        fun newInstance() = AuthFragment()
    }

    private val viewModel: AuthViewModel by lazy { ViewModelProviders.of(this).get(AuthViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.authorization_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setEditTextFormat(etPhone)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBindings(view)
    }

    private fun setEditTextFormat(editText: EditText) {
        val mask = MaskImpl.createTerminated(PredefinedSlots.RUS_PHONE_NUMBER)
        mask.isHideHardcodedHead = true
        val formatWatcher = MaskFormatWatcher(mask)
        formatWatcher.installOn(editText)
    }

    private fun initBindings(view: View) {
        val binding = DataBindingUtil.bind<AuthorizationFragmentBinding>(view)
        binding?.authViewModel = viewModel
    }
}
