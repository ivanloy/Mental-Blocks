package com.ivanloy.mentalblocks

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View


class Board(context : Context, attrs : AttributeSet?) : View(context, attrs){

    private var listener : BoardListener = object : BoardListener{
        override fun onBlockClicked(levelInfo: LevelInfo) {}
    }

    private val BLOCK_SPACING = 12
    private val BLOCK_SHADOW_DY = 6
    private val PIECE_SHADOW_DX = 7
    private val PIECE_SHADOW_DY = 7
    private val PIECE_SIZE_DIV = 3.5
    private val PIECE_STROKE_WIDTH = 8f

    var blockSize = 0
    var pieceSelected = Elements.EMPTY

    private var levelInfo = LevelInfo()
    private var blockColors = IntArray(36) //TODO Hardcoded var

    private var mBlockPaint : Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = 0xFFE0E0E0.toInt()
    }

    private var mShadowPaint : Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = 0xFF37474F.toInt() //TODO colors
    }

    private var mPiecePaint : Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = BlockColors.BLUE.intCode //TODO colors
    }

    private var mPieceBorderPaint : Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = 0xFF37474F.toInt() //TODO colors
        strokeWidth = PIECE_STROKE_WIDTH
        style = Paint.Style.STROKE
    }

    init {
        for(i in 0..35){
            blockColors[i] = BlockColors.EMPTY_BLOCK.intCode //TODO Hardcoded
        }
    }

    fun setBoardListener(listener: BoardListener){
        this.listener = listener
    }

    fun setLevelConfiguration(levelInfo: LevelInfo){
        this.levelInfo = levelInfo
        setBlockColors(levelInfo.getBlockArray())
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
        listener.onBlockClicked(levelInfo)
    }

    fun setPieceType(blockX : Int, blockY : Int){
        var block = levelInfo.blocks[blockX + blockY*6]
        if(pieceSelected != Elements.EMPTY && levelInfo.movesLeft > 0 && block.piece == Elements.EMPTY) {
            block.piece = pieceSelected
            levelInfo.movesLeft--
        }else if(pieceSelected != Elements.EMPTY && block.piece != Elements.EMPTY){
            block.piece = Elements.EMPTY
            levelInfo.movesLeft++
        }
        invalidate()
    }

    fun updateScore(blockX: Int, blockY: Int){
        var block = levelInfo.blocks[blockX + blockY*6]
        if(block.piece != Elements.EMPTY) {
            addScore(blockX, blockY, block)
        }else {
            levelInfo.score -= block.score
            block.score = 0 //TODO Att in block obj
        }
    }

    private fun addScore(blockX: Int, blockY: Int , block: Block) { //TODO Att, yep, important refactor
        for (square in levelInfo.squares) {
            if (blockX >= square.xTop && blockX <= square.xBot && blockY >= square.yTop && blockY <= square.yBot) {
                var blockScore = calcBlockScore(block, square)
                block.score += blockScore
                levelInfo.score += blockScore
            }
        }
    }

    private fun calcBlockScore(block: Block, square: Square) : Int{
        var ret = 0
        when(square.element){
            Elements.FOREST -> when(block.piece){
                Elements.FIRE -> ret += 2
                Elements.WATER -> ret -- //TODO If equal ++, remove those
                Elements.FOREST -> ret ++
            }
            Elements.WATER  -> when(block.piece){
                Elements.FIRE -> ret --
                Elements.WATER -> ret ++
                Elements.FOREST -> ret += 2
            }
            Elements.FIRE   -> when(block.piece){
                Elements.FIRE -> ret ++
                Elements.WATER -> ret += 2
                Elements.FOREST -> ret --
            }
        }
        return ret
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

                    if(levelInfo.blocks[i + j*6].piece != Elements.EMPTY) {

                        mPiecePaint.color = levelInfo.blocks[i + j * 6].piece.intCode

                        drawCircle(
                            i * blockSize.toFloat() + PIECE_SHADOW_DX + (blockSize - BLOCK_SPACING) / 2,
                            j * blockSize.toFloat() + PIECE_SHADOW_DY + (blockSize - BLOCK_SPACING) / 2,
                            blockSize / PIECE_SIZE_DIV.toFloat(),
                            mShadowPaint
                        )

                        drawCircle(
                            i * blockSize.toFloat() + (blockSize - BLOCK_SPACING) / 2,
                            j * blockSize.toFloat() + (blockSize - BLOCK_SPACING) / 2,
                            blockSize / PIECE_SIZE_DIV.toFloat(),
                            mPiecePaint
                        )

                        drawCircle(
                            i * blockSize.toFloat() + (blockSize - BLOCK_SPACING) / 2, //TODO APELO QUE FEO
                            j * blockSize.toFloat() + (blockSize - BLOCK_SPACING) / 2,
                            blockSize / PIECE_SIZE_DIV.toFloat(),
                            mPieceBorderPaint
                        )
                    }
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