package com.ivanloy.mentalblocks

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BoardListener, View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        btn_select_blue.setOnClickListener(this)
        btn_select_green.setOnClickListener(this)
        btn_select_red.setOnClickListener(this)

        tv_score.text = TextUtil.fromHtml("<b><big>0</big></b> / <small>14</small>")

        var squares = arrayOf(
            Square(0, 0, 3, 3, Elements.FOREST),
            Square(3, 0, 5, 3, Elements.WATER),
            Square(0, 3, 3, 5 , Elements.FIRE),
            Square(2, 4, 5, 5 , Elements.FIRE),
            Square(4, 3, 5, 5, Elements.WATER),
            Square(1, 1, 2, 2, Elements.FOREST)
        )

        var levelConf = LevelInfo(squares)
        brd_blockBoard.setBoardListener(this) //TODO Builder?
        brd_blockBoard.setLevelConfiguration(levelConf)
        //brd_blockBoard.pieceDrawables = resources.getDrawable(R.drawable.fore, null)
    }

    override fun onBlockClicked(levelInfo: LevelInfo) {
        val targetScore = 14
        tv_score.text = TextUtil.fromHtml("<b><big>${levelInfo.score}</big></b> / <small>$targetScore</small>")
        tv_movesLeft.text = "${levelInfo.movesLeft} moves"
    }

    override fun onClick(v: View?) {

        btn_select_blue.background = getDrawable(R.color.coverWhiteAlpha)
        btn_select_green.background = getDrawable(R.color.coverWhiteAlpha)
        btn_select_red.background = getDrawable(R.color.coverWhiteAlpha)
        v!!.background = getDrawable(R.color.invisible)

        when(v!!.id){
            R.id.btn_select_blue -> brd_blockBoard.pieceSelected = Elements.WATER
            R.id.btn_select_red -> brd_blockBoard.pieceSelected = Elements.FIRE
            R.id.btn_select_green -> brd_blockBoard.pieceSelected = Elements.FOREST
        }
    }

}
