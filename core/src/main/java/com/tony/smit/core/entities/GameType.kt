package com.tony.smit.core.entities

import android.content.res.Resources
import com.tony.smit.core.R

enum class GameType(val gameTypeName: String) {
    VOLLEYBALL(Resources.getSystem().getString(R.string.classic_volleyball)),
    BEACHVOLLEYBALL(Resources.getSystem().getString(R.string.beach_volleyball))
}