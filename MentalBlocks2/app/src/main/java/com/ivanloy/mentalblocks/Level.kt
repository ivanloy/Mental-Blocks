package com.ivanloy.mentalblocks

import android.graphics.drawable.Drawable

data class Level(val nLevel : Int,
            val levelInfo : LevelInfo? = null, //TODO Fiufiunull
            var unlocked : Boolean = false,
            var completed : Boolean = false) {
}