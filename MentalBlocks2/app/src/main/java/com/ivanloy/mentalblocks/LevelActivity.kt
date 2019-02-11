package com.ivanloy.mentalblocks

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_level.*

class LevelActivity : AppCompatActivity(), BoardListener, View.OnClickListener{

    private var levelConf = LevelInfo()
    private var nLevel = 0
    private var resultIntent = Intent()

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
        btn_hint.setOnClickListener(this)
        btn_nextBtn.setOnClickListener(this) //TODO Drawable with diff color when focused
        btn_lvlBtn.setOnClickListener(this)
        btn_restartBtn.setOnClickListener(this)

        levelConf = intent.getParcelableExtra<LevelInfo>("LevelInfo")
        nLevel = intent.getIntExtra("nLevel", 0)

        tv_nLevel.text = nLevel.toString()
        tv_score.text = TextUtil.fromHtml("<b><big>0</big></b> / <small>${levelConf.targetScore}</small>")
        tv_movesLeft.text = "${levelConf.targetMoves} moves"
        if(levelConf.targetElementMoves[0] != -1) {
            tv_select_red.text = levelConf.targetElementMoves[0].toString()
            tv_select_green.text = levelConf.targetElementMoves[1].toString()
            tv_select_blue.text = levelConf.targetElementMoves[2].toString()
        }

        brd_blockBoard.setBoardListener(this) //TODO Builder?
        brd_blockBoard.setLevelConfiguration(levelConf)
        //brd_blockBoard.pieceDrawables = resources.getDrawable(R.drawable.fore, null)
    }

    override fun onBlockClicked(levelInfo: LevelInfo) {
        tv_score.text = TextUtil.fromHtml("<b><big>${levelInfo.score}</big></b> / <small>${levelInfo.targetScore}</small>")
        tv_movesLeft.text = "${levelInfo.movesLeft} moves"
        if(levelInfo.targetElementMoves[0] != -1) {
            tv_select_red.text = levelInfo.elementMovesLeft[0].toString()
            tv_select_green.text = levelInfo.elementMovesLeft[1].toString()
            tv_select_blue.text = levelInfo.elementMovesLeft[2].toString()
        }
    }

    override fun onLevelCompleted() {
        resultIntent.putExtra("completed", true)
        resultIntent.putExtra("nLevelResponse", nLevel)
        popUpEndLvlWindow()
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
                finish()
            }
            R.id.btn_hint -> {
                Toast.makeText(this, "WIP :(", Toast.LENGTH_SHORT).show()
            }

            R.id.btn_lvlBtn -> {
                resultIntent.putExtra("btnPressed", EndLevelButtons.LEVELS_MENU.code)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
            R.id.btn_restartBtn -> {
                resultIntent.putExtra("btnPressed", EndLevelButtons.RESTART.code)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
            R.id.btn_nextBtn -> {
                resultIntent.putExtra("btnPressed", EndLevelButtons.NEXT_LVL.code)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }

        }
    }

    fun popUpEndLvlWindow(){
        endLvlGroup.visibility = View.VISIBLE
    }

}
