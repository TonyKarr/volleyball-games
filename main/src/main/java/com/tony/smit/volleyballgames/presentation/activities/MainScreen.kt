package com.tony.smit.volleyballgames.presentation.activities

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.tony.smit.fragment_view.presentation.fragments.BaseFragment
import com.tony.smit.games_list.presentation.fragments.GameCreateFragment
import com.tony.smit.games_list.presentation.fragments.GameFavouriteFragment
import com.tony.smit.games_list.presentation.fragments.GamesListFragment
import com.tony.smit.volleyballgames.R

enum class MainScreen(
    @IdRes val menuItemId: Int,
    @DrawableRes val menuItemIconId: Int,
    @StringRes val menuTitleId: Int,
    val fragment: Fragment
) {
    CREATE_GAME(
        R.id.bottom_navigation_item_game_create,
        R.drawable.ic_add_white_24dp,
        R.string.activity_main_bottom_navigation_screen_game_create,
        GameCreateFragment()
    ),
    LIST_GAME(
        R.id.bottom_navigation_item_game_list,
        R.drawable.ic_featured_play_list_white_24dp,
        R.string.activity_main_bottom_navigation_screen_game_list,
        GamesListFragment.newInstance()
    ),
    FAVOURITE_GAME(
        R.id.bottom_navigation_item_game_favourite,
        R.drawable.ic_favorite_white_24dp,
        R.string.activity_main_bottom_navigation_screen_game_favourite,
        GameFavouriteFragment()
    )
}

fun getMainScreenForMenuItem(menuItemId: Int): MainScreen? {
    for (mainScreen in MainScreen.values()) {
        if (mainScreen.menuItemId == menuItemId) {
            return mainScreen
        }
    }
    return null
}