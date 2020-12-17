package com.tony.smit.games_list.presentation.fragments


import android.os.Bundle
import android.view.View
import com.tony.smit.games_list.R
import com.tony.smit.games_list.databinding.FragmentGamesListBinding
import com.tony.smit.games_list.presentation.viewmodels.GamesListViewModel
import com.tony.smit.games_list.utils.ViewModelFactory
import androidx.databinding.DataBindingUtil
import com.tony.smit.core.di.ApplicationProvider
import com.tony.smit.fragment_view.presentation.fragments.BaseFragment
import com.tony.smit.games_list.di.GamesListFragmentComponent
import android.widget.Toast
import github.nisrulz.recyclerviewhelper.RVHItemClickListener
import androidx.recyclerview.widget.LinearLayoutManager
import github.nisrulz.recyclerviewhelper.RVHItemDividerDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import github.nisrulz.recyclerviewhelper.RVHItemTouchHelperCallback
import android.util.Log
import androidx.fragment.app.Fragment
import com.tony.smit.games_list.presentation.adapters.GameListAdapter
import github.nisrulz.recyclerviewhelper.RVHAdapter
import kotlinx.android.synthetic.main.fragment_games_list.*


class GamesListFragment : BaseFragment<GamesListViewModel, ViewModelFactory>() {

    companion object {
        @JvmStatic
        fun newInstance() =
            GamesListFragment()
    }

    override val viewModelClazz = GamesListViewModel::class.java
    override val layoutResourceInt = R.layout.fragment_games_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DataBindingUtil.bind<FragmentGamesListBinding>(view)
        binding?.viewModel = viewModel
        // Setup onItemTouchHandler to enable drag and drop , swipe left or right
        val callback = RVHItemTouchHelperCallback(
            viewModel.adapter.get(), false, false,
            false
        )
        val helper = ItemTouchHelper(callback)
        helper.attachToRecyclerView(rvGameList)

        // Set On Click Listener
        rvGameList.addOnItemTouchListener(
            RVHItemClickListener(requireContext(),
                RVHItemClickListener.OnItemClickListener { _, position ->
                    val value = "Clicked Item at " + position

                    Log.d("TAG", value)
                    Toast.makeText(requireContext(), value, Toast.LENGTH_SHORT).show()
                })
        )
    }

    override fun inject(applicationProvider: ApplicationProvider) {
        GamesListFragmentComponent.Initializer
            .init(applicationProvider)
            .inject(this)
    }

}

