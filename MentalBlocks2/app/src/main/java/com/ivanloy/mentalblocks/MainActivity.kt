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


        brd_blockBoard.setBlockData(blocks)

    }
}
