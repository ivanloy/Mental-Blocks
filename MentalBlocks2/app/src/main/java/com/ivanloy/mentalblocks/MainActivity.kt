package com.ivanloy.mentalblocks

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var blocks = arrayOf(
            Block(intArrayOf(1,0,0)),
            Block(intArrayOf(1,0,0)),
            Block(intArrayOf(0,1,0)),
            Block(intArrayOf(0,1,0)),
            Block(intArrayOf(0,1,0)),
            Block(intArrayOf(0,1,0)),
            Block(intArrayOf(0,0,0)),
            Block(intArrayOf(0,0,1)),
            Block(intArrayOf(0,0,1)),
            Block(intArrayOf(0,0,1)),
            Block(intArrayOf(0,0,1)),
            Block(intArrayOf(1,0,0)),
            Block(intArrayOf(0,0,0)),
            Block(intArrayOf(0,0,0)),
            Block(intArrayOf(0,0,0)),
            Block(intArrayOf(0,0,0)),
            Block(intArrayOf(0,0,0)),
            Block(intArrayOf(0,0,0)),
            Block(intArrayOf(0,0,1)),
            Block(intArrayOf(0,0,1)),
            Block(intArrayOf(0,0,1)),
            Block(intArrayOf(1,0,0)),
            Block(intArrayOf(0,1,0)),
            Block(intArrayOf(0,1,0)),
            Block(intArrayOf(0,1,0)),
            Block(intArrayOf(0,1,0)),
            Block(intArrayOf(0,0,1)),
            Block(intArrayOf(0,0,1)),
            Block(intArrayOf(0,0,1)),
            Block(intArrayOf(0,0,1)),
            Block(intArrayOf(0,0,1)),
            Block(intArrayOf(1,0,0)),
            Block(intArrayOf(0,1,0)),
            Block(intArrayOf(0,1,0)),
            Block(intArrayOf(0,1,0)),
            Block(intArrayOf(0,1,0))
        )


        var squares = arrayOf(
            Square(0, 0, 3, 3, Elements.FOREST),
            Square(4, 0, 5, 3, Elements.WATER),
            Square(0, 4, 2, 5 , Elements.FIRE)
        )

        var levelConf = LevelConfiguration(squares)

        brd_blockBoard.setBlockData(levelConf.getBlockArray())

    }
}
