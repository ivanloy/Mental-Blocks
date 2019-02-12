package com.ivanloy.mentalblocks

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Adapter
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_level_list.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_level.*
import java.lang.StringBuilder


class LevelListActivity : AppCompatActivity(), LevelListListener, View.OnClickListener {

    private var levels = ArrayList<Level>()
    private var adapter : LevelAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_level)
        setContentView(R.layout.activity_level_list)

        btn_goBackToMain.setOnClickListener(this)

        levels = ArrayList<Level>()

        levels.add(Level(1, LevelsData.LEVEL_1.data, getDrawable(R.drawable.level1), true))
        levels.add(Level(2, LevelsData.LEVEL_2.data, getDrawable(R.drawable.level2), false))
        levels.add(Level(3, LevelsData.LEVEL_3.data, getDrawable(R.drawable.level3), false))
        levels.add(Level(4, LevelsData.LEVEL_4.data, getDrawable(R.drawable.level4), false))
        levels.add(Level(5, LevelsData.LEVEL_5.data, getDrawable(R.drawable.level5), false))
        levels.add(Level(6, LevelsData.LEVEL_6.data, getDrawable(R.drawable.level6), false))
        levels.add(Level(7, LevelsData.LEVEL_7.data, getDrawable(R.drawable.level7), false))
        levels.add(Level(8, LevelsData.LEVEL_8.data, getDrawable(R.drawable.level8), false))
        levels.add(Level(9, LevelsData.LEVEL_9.data, getDrawable(R.drawable.level9), false))
        levels.add(Level(10, LevelsData.LEVEL_10.data, getDrawable(R.drawable.level10), false))
        levels.add(Level(11, LevelsData.LEVEL_11.data, getDrawable(R.drawable.level11), false))
        levels.add(Level(12, LevelsData.LEVEL_12.data, getDrawable(R.drawable.level12), false))

        loadData()

        tv_puzzlesSolved.text = TextUtil.fromHtml("<b><big>${getNLevelsSolved()}</big></b> / <small>12</small>")

        rv_levelList.layoutManager = GridLayoutManager(
            this,
            3,
            RecyclerView.VERTICAL,
            false
        )
        adapter = LevelAdapter(levels, this, this)
        rv_levelList.adapter = adapter

    }

    override fun onLevelClicked(position: Int) {
        this.startLevel(position)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            0 -> {
                if(resultCode == Activity.RESULT_OK){
                    var nLevel = data!!.getIntExtra("nLevelResponse", 0) - 1
                    levels[nLevel].completed = true
                    tv_puzzlesSolved.text = TextUtil.fromHtml("<b><big>${getNLevelsSolved()}</big></b> / <small>12</small>")
                    if(nLevel < 11) { //TODO Hardcoded
                        levels[nLevel + 1].unlocked = true
                    }
                    saveData()
                    var buttonPressed = data!!.getIntExtra("btnPressed", EndLevelButtons.LEVELS_MENU.code) //TODO Use std kotlin lib funcs
                    when(buttonPressed) {
                        EndLevelButtons.RESTART.code -> startLevel(nLevel)
                        EndLevelButtons.NEXT_LVL.code -> startLevel(nLevel + 1)
                    }
                    adapter!!.setData(levels)
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_goBackToMain -> {
                finish()
            }
        }
    }

    override fun onDestroy() {
        Log.d("Patata", "onDestroy")
        super.onDestroy()
    }

    fun startLevel(nLevel : Int){
        if(nLevel < levels.size && levels[nLevel].unlocked) {
            val intent = Intent(this, LevelActivity::class.java)
            intent.putExtra("LevelInfo", levels[nLevel].levelInfo) //TODO Constants
            intent.putExtra("nLevel", levels[nLevel].nLevel) //TODO Constants
            startActivityForResult(intent, 0) //TODO Constants
        }
    }


    private fun getNLevelsSolved() : Int{
        var ret = 0
        for(lev in levels){
            if(lev.completed) ret++
        }
        return ret
    }

    fun saveData() {
        var data = StringBuilder()
        Log.d("Patata", "saveData")
        for(level in levels){
            data.append("${level.unlocked},${level.completed} ")
        }
        Log.d("Patata", data.toString())
        SerializableManager.saveSerializable(this, data.toString(), "levelData.sav")
    }

    fun loadData(){
        var data = SerializableManager
            .readSerializable<String>(this, "levelData.sav")

        if(data != null) {
            var parsedData = data.split(" ")
            if (parsedData.size > 0) {
                for (i in 0..11) { //TODO Hardcoded
                    var line = parsedData[i].split(",")
                    levels[i].unlocked = line[0].toBoolean()
                    levels[i].completed = line[1].toBoolean()
                }
            }
        }
    }

}
