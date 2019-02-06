package com.ivanloy.mentalblocks

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.R.attr.bottom
import android.R.attr.right
import android.R.attr.top
import android.R.attr.left
import android.R
import android.graphics.drawable.Drawable



class Board(context : Context, attrs : AttributeSet?) : View(context, attrs){

    private var listener : BoardListener = object : BoardListener{
        override fun onBlockClicked(newScore: Int) {}
    }

    private val BLOCK_SPACING = 12
    private val BLOCK_SHADOW_DY = 6

    var blockSize = 0
    var score = 0
    var pieceDrawables : Drawable = resources.getDrawable(R.drawable.alert_dark_frame, null) //TODO Por poner algo?

    private var levelConfiguration = LevelConfiguration()
    private var blockColors = IntArray(36) //TODO Hardcoded var

    private var mBlockPaint : Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = 0xFFE0E0E0.toInt()
    }

    private var mShadowPaint : Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = 0xFF37474F.toInt() //TODO colors
    }

    init {
        for(i in 0..35){
            blockColors[i] = BlockColors.EMPTY_BLOCK.intCode //TODO Hardcoded
        }
        pieceDrawables.setBounds(0,0,50,50)
    }

    fun setBoardListener(listener: BoardListener){
        this.listener = listener
    }

    fun setLevelConfiguration(levelConfiguration: LevelConfiguration){
        this.levelConfiguration = levelConfiguration
        setBlockColors(levelConfiguration.getBlockArray())
    }

    fun setBlockColors(blocks : Array<Block>){
        for(i in 0..35){
            blockColors[i] = blocks[i].getColor()
        }
        //TODO Check if size is 36
    }

    fun handleClick(blockX : Int, blockY : Int){
        setPieceType(blockX, blockY)
        updateScore(blockX, blockY)
        listener.onBlockClicked(score)
    }

    fun setPieceType(blockX : Int, blockY : Int){
        var block = levelConfiguration.blocks[blockX + blockY*6]
        if(block.piece == Elements.EMPTY) {
            block.piece = Elements.FOREST
        }else{
            block.piece = Elements.EMPTY
        }
    }

    fun updateScore(blockX: Int, blockY: Int){
        var block = levelConfiguration.blocks[blockX + blockY*6]
        for(square in levelConfiguration.squares){
            if(blockX >= square.xTop && blockX <= square.xBot && blockY >= square.yTop && blockY <= square.yBot) {
                if(block.piece == Elements.FOREST) score++ //TODO Sacar calculo de block fuera, optimizacion
                else score--
            }
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        blockSize = w/6
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.apply {

            for (i in 0..5){
                for(j in 0..5){
                    mBlockPaint.color = blockColors[i + j*6] //TODO Hardcoded
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
                    //pieceDrawables.draw(canvas)
                }
            }

        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val blockX = Math.floor((event!!.x / blockSize).toDouble()).toInt() //TODO Putos casts raros
        val blockY = Math.floor((event!!.y / blockSize).toDouble()).toInt() //TODO Check if out of canvasito
        handleClick(blockX, blockY)
        return super.onTouchEvent(event)
    }

}