package com.ivanloy.mentalblocks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_level.*

class LevelActivity : AppCompatActivity(), BoardListener, View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_level)

        btn_select_blue.setOnClickListener(this)
        btn_select_green.setOnClickListener(this)
        btn_select_red.setOnClickListener(this)
        btn_goBack.setOnClickListener(this)


        val intent = getIntent()
        var levelConf = intent.getParcelableExtra<LevelInfo>("LevelInfo")

        tv_score.text = TextUtil.fromHtml("<b><big>0</big></b> / <small>${levelConf.targetScore}</small>")
        tv_movesLeft.text = "${levelConf.targetMoves} moves"

        brd_blockBoard.setBoardListener(this) //TODO Builder?
        brd_blockBoard.setLevelConfiguration(levelConf)
        //brd_blockBoard.pieceDrawables = resources.getDrawable(R.drawable.fore, null)
    }

    override fun onBlockClicked(levelInfo: LevelInfo) {
        tv_score.text = TextUtil.fromHtml("<b><big>${levelInfo.score}</big></b> / <small>${levelInfo.targetScore}</small>")
        tv_movesLeft.text = "${levelInfo.movesLeft} moves"
    }

    override fun onClick(v: View?) {

        when(v!!.id){

            R.id.btn_select_blue -> {
                btn_select_blue.background = getDrawable(R.color.invisible)
                btn_select_green.background = getDrawable(R.color.coverWhiteAlpha)
                btn_select_red.background = getDrawable(R.color.coverWhiteAlpha)
                brd_blockBoard.pieceSelected = Elements.WATER
            }
            R.id.btn_select_red -> {
                btn_select_blue.background = getDrawable(R.color.coverWhiteAlpha)
                btn_select_green.background = getDrawable(R.color.coverWhiteAlpha)
                btn_select_red.background = getDrawable(R.color.invisible)
                brd_blockBoard.pieceSelected = Elements.FIRE
            }
            R.id.btn_select_green -> {
                btn_select_blue.background = getDrawable(R.color.coverWhiteAlpha)
                btn_select_green.background = getDrawable(R.color.invisible)
                btn_select_red.background = getDrawable(R.color.coverWhiteAlpha)
                brd_blockBoard.pieceSelected = Elements.FOREST
            }

            R.id.btn_goBack -> {
                Log.d("Patata", "papa")
                val intent = Intent(this, LevelListActivity::class.java)
                startActivity(intent)
            }

        }
    }

}
