package com.ivanloy.mentalblocks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_menu.*
import androidx.constraintlayout.widget.ConstraintSet



class MainMenuActivity : AppCompatActivity(), View.OnClickListener {

    private var levels = ArrayList<Level>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main_menu)

    }

    override fun onResume() {
        super.onResume()
        setPercentageBox()
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_levels -> {
                val intent = Intent(this, LevelListActivity::class.java)
                startActivity(intent)
            }
            else -> {
                Toast.makeText(this, "WIP :(", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun setPercentageBox(){
        var levelPack = LevelPack(LevelPacksData.TUTORIAL)
        levels = levelPack.levels
        loadData()

        val nLevels = levelPack.levels.size
        val levelsCompleted = levelPack.getNLevelsSolved()

        val set = ConstraintSet()
        set.clone(cl_mainMenuConstraintLayout)
        set.setDimensionRatio(vw_redPercentage.id, "$nLevels:$levelsCompleted")
        set.applyTo(cl_mainMenuConstraintLayout)
        txt_nLevelMainMenu.text = "Lv ${levelsCompleted + 1}"

        btn_levels.setOnClickListener(this)
    }

    fun loadData(){
        var data = SerializableManager
            .readSerializable<String>(this, "levelData.sav")

        if(data != null) {
            var parsedData = data.split(" ")
            if (parsedData.size > 0) {
                for (i in 0..levels.size - 1) { //TODO Hardcoded
                    var line = parsedData[i].split(",")
                    levels[i].unlocked = line[0].toBoolean()
                    levels[i].completed = line[1].toBoolean()
                }
            }
        }
    }

}
