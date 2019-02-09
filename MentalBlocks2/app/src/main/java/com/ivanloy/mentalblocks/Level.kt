package com.ivanloy.mentalblocks

import android.graphics.drawable.Drawable

data class Level(val nLevel : Int,
            val levelInfo : LevelInfo? = null,
            val drawable : Drawable? = null, //TODO Fiufiunull
            var unlocked : Boolean = false) {
}