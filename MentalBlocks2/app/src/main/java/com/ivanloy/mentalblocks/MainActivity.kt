package com.ivanloy.mentalblocks

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BoardListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        var squares = arrayOf(
            Square(0, 0, 3, 3, Elements.FOREST),
            Square(3, 0, 5, 3, Elements.WATER),
            Square(0, 3, 3, 5 , Elements.FIRE),
            Square(2, 4, 5, 5 , Elements.FIRE),
            Square(4, 3, 5, 5, Elements.WATER),
            Square(1, 1, 2, 2, Elements.FOREST)
        )

        var levelConf = LevelConfiguration(squares)
        brd_blockBoard.setBoardListener(this) //TODO Builder?
        brd_blockBoard.setLevelConfiguration(levelConf)
        //brd_blockBoard.pieceDrawables = resources.getDrawable(R.drawable.fore, null)

    }

    override fun onBlockClicked(newScore: Int) {
        Log.d("BlockClicked", newScore.toString())
    }

}
