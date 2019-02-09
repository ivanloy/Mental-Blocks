package com.ivanloy.mentalblocks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_level_list.*
import androidx.recyclerview.widget.RecyclerView



class LevelListActivity : AppCompatActivity(), LevelListListener {

    var levels = ArrayList<Level>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_level)
        setContentView(R.layout.activity_level_list)

        levels = ArrayList<Level>()

        levels.add(Level(1, LevelsData.LEVEL_1.data, getDrawable(R.drawable.level1), true))
        levels.add(Level(2, LevelsData.LEVEL_2.data, getDrawable(R.drawable.level2), true))
        levels.add(Level(3, LevelsData.LEVEL_3.data, getDrawable(R.drawable.level3), true))
        levels.add(Level(4, LevelsData.LEVEL_4.data, getDrawable(R.drawable.level4), true))
        levels.add(Level(5, LevelsData.LEVEL_5.data, getDrawable(R.drawable.level5), true))
        levels.add(Level(6, LevelsData.LEVEL_6.data, getDrawable(R.drawable.level6), true))
        levels.add(Level(7, LevelsData.LEVEL_7.data, getDrawable(R.drawable.level7), true))
        levels.add(Level(8, LevelsData.LEVEL_8.data, getDrawable(R.drawable.level8), true))
        levels.add(Level(9, LevelsData.LEVEL_9.data, getDrawable(R.drawable.level9), true))
        levels.add(Level(10))
        levels.add(Level(11))
        levels.add(Level(12))

        rv_levelList.layoutManager = GridLayoutManager(
            this,
            3,
            RecyclerView.VERTICAL,
            false
        )
        rv_levelList.adapter = LevelAdapter(levels, this, this)

    }

    override fun onLevelClicked(position: Int) {
        if(levels[position].unlocked) {
            val intent = Intent(this, LevelActivity::class.java)
            intent.putExtra("LevelInfo", levels[position].levelInfo) //TODO Constants
            startActivity(intent)
        }
    }

}
