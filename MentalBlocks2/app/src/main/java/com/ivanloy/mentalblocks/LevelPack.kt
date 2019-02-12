package com.ivanloy.mentalblocks

data class LevelPack(var levels : Array<Level>) {

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