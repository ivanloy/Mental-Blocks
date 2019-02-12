package com.ivanloy.mentalblocks

interface BoardListener {
    fun onBlockClicked(levelInfo: LevelInfo)
    fun onFixedPiecePut(levelInfo: LevelInfo)
    fun onLevelCompleted()
}
