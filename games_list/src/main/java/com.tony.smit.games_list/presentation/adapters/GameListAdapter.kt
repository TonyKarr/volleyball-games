package com.tony.smit.games_list.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tony.smit.games_list.R
import com.tony.smit.games_list.databinding.ItemGameViewBinding
import com.tony.smit.games_list.domain.entities.GameViewData
import github.nisrulz.recyclerviewhelper.RVHAdapter
import github.nisrulz.recyclerviewhelper.RVHViewHolder
import java.util.*


class GameListAdapter(val list: LinkedList<GameViewData> = LinkedList()) :
    RecyclerView.Adapter<GameListAdapter.ItemViewHolder>(), RVHAdapter {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemGameViewBinding>(
            inflater,
            R.layout.item_game_view,
            parent,
            false
        )
        return ItemViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val gameViewData = list[position]
        holder.bind(gameViewData)
    }

    override fun onItemDismiss(position: Int, direction: Int) {
        remove(position)
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        swap(fromPosition, toPosition)
        return false
    }


    fun update(data: List<GameViewData>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    class ItemViewHolder(private val binding: ItemGameViewBinding) :
        RecyclerView.ViewHolder(binding.root), RVHViewHolder {

        fun bind(itemGameView: GameViewData) {
            binding.gameView = itemGameView
            binding.executePendingBindings()
        }

        override fun onItemSelected(actionstate: Int) {
            Log.d("DEBUG", "onItemSelected")
        }

        override fun onItemClear() {
            Log.d("DEBUG", "onItemClear")
        }
    }

    private fun remove(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    private fun swap(firstPosition: Int, secondPosition: Int) {
        Collections.swap(list, firstPosition, secondPosition)
        notifyItemMoved(firstPosition, secondPosition)
    }
}