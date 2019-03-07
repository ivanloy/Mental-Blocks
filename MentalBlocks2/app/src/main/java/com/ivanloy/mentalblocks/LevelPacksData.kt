package com.ivanloy.mentalblocks

enum class LevelPacksData(val initLevel : Int, val levels : Array<LevelsData>) {

    TUTORIAL(1, arrayOf(LevelsData.LEVEL_1, LevelsData.LEVEL_2, LevelsData.LEVEL_3, LevelsData.LEVEL_4,
        LevelsData.LEVEL_5, LevelsData.LEVEL_6, LevelsData.LEVEL_7, LevelsData.LEVEL_8, LevelsData.LEVEL_9,
        LevelsData.LEVEL_10, LevelsData.LEVEL_11, LevelsData.LEVEL_12, LevelsData.LEVEL_13, LevelsData.LEVEL_14, LevelsData.LEVEL_15))

}