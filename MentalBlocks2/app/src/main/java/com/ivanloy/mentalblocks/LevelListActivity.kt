package com.ivanloy.mentalblocks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import kotlinx.android.synthetic.main.activity_level_list.*
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener


class LevelListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_list)

        rv_levelList.layoutManager = GridLayoutManager(
            this,
            4,
            GridLayoutManager.HORIZONTAL,
            false
        )
        rv_levelList.adapter = LevelAdapter(intArrayOf(1), this)
        val snapHelper = LevelsSnapHelper()
        snapHelper.attachToRecyclerView(rv_levelList)

    }
}
