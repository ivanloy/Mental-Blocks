package com.ivanloy.mentalblocks

data class LevelPack(val levelPack : LevelPacksData) {

    var levels : ArrayList<Level>

    init {
        levels = ArrayList()
        val levelData = levelPack.levels;
        val initLevel = levelPack.initLevel
        levels.add(Level(initLevel, levelData[0].data, true))
        for(i in 1..levelData.size - 1){
            levels.add(Level(initLevel + i, levelData[i].data, true))
        }
    }

    fun getNLevelsSolved() : Int{
        var ret = 0
        for(lev in levels){
            if(lev.completed) ret++
        }
        return ret
    }

    fun getPackCompleted() : Boolean {
        var ret = false
        if(getNLevelsSolved() == levels.size) ret = true
        return ret
    }

}