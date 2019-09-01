package com.tony.smit.core.entities

import android.content.res.Resources
import com.tony.smit.core.R

enum class Amplua(val ampluaName: String) {
    SETTER(Resources.getSystem().getString(R.string.setter)),
    MIDDLEBLOCKER(Resources.getSystem().getString(R.string.middle_blocker)),
    HITTER(Resources.getSystem().getString(R.string.hitter)),
    LYBERO(Resources.getSystem().getString(R.string.lybero)),
    DIAGONAL(Resources.getSystem().getString(R.string.diagonal)),
    UNIVERSAL(Resources.getSystem().getString(R.string.universal))
}