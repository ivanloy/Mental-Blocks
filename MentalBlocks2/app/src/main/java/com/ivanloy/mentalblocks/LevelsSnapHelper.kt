package com.ivanloy.mentalblocks

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.level_preview.view.*

class LevelsSnapHelper : LinearSnapHelper(){

    override fun findTargetSnapPosition(
        layoutManager: RecyclerView.LayoutManager?,
        velocityX: Int,
        velocityY: Int
    ): Int {
        return Math.floor(super.findTargetSnapPosition(layoutManager, velocityX, velocityY).toDouble() / 12).toInt() * 12 + 4
    }

    override fun onFling(velocityX: Int, velocityY: Int): Boolean {
        Log.d("TouchTest", velocityX.toString())
        return super.onFling(velocityX, velocityY)
    }

    override fun calculateDistanceToFinalSnap(layoutManager: RecyclerView.LayoutManager, targetView: View): IntArray? {
        val out = super.calculateDistanceToFinalSnap(layoutManager, targetView)


        Log.d("TouchTest", out!![0].toString())

        return out
    }

}