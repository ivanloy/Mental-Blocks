package com.ivanloy.mentalblocks

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Board(context : Context, attrs : AttributeSet?) : View(context, attrs){

    private val BLOCK_SPACING = 12
    private val BLOCK_SHADOW_DY = 6

    private var blockColors = IntArray(36) //TODO Hardcoded var

    private var mBlockPaint : Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = 0xFFE0E0E0.toInt()
    }

    private var mShadowPaint : Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = 0xFF212121.toInt()
    }

    init {
        for(i in 0..35){
            blockColors[i] = BlockColors.EMPTY_BLOCK.intCode //TODO Hardcoded
        }
    }

    fun setBlockData(blocks : Array<Block>){

        for(i in 0..35){
            blockColors[i] = blocks[i].getColor()
        }

        //TODO Map to color array for performance, make fun/extension
        //TODO Check if size is 36
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.apply {

            var blockSize = canvas.width / 6 //TODO Padding, hardcoded

            for (i in 0..5){
                for(j in 0..5){
                    mBlockPaint.color = blockColors[6*j + i] //TODO Hardcoded
                    drawRect(
                        i * (blockSize).toFloat(),
                        j * (blockSize).toFloat(),
                        (i + 1) * (blockSize).toFloat() - BLOCK_SPACING,
                        (j + 1) * (blockSize).toFloat() - BLOCK_SPACING,
                        mBlockPaint
                    )
                    drawRect(
                        i * (blockSize).toFloat(),
                        (j + 1) * (blockSize).toFloat() - BLOCK_SPACING,
                        (i + 1) * (blockSize).toFloat() - BLOCK_SPACING,
                        (j + 1) * (blockSize).toFloat() - BLOCK_SPACING + BLOCK_SHADOW_DY,
                        mShadowPaint
                    )
                }
            }

        }
    }

}