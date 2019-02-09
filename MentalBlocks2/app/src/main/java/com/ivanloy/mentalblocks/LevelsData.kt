package com.ivanloy.mentalblocks

enum class LevelsData(val data : LevelInfo) { //TODO File

    LEVEL_1(LevelInfo(arrayOf(Square(0,0,5,5,Elements.WATER.id)),
        1,1)),

    LEVEL_2(LevelInfo(arrayOf(Square(0,0,2,2,Elements.WATER.id),
                              Square(3,3,5,5,Elements.FOREST.id),
                              Square(3,0,5,2,Elements.FIRE.id)),
        3,6)),

    LEVEL_3(LevelInfo(arrayOf(Square(0,0,3,3,Elements.WATER.id),
                              Square(2,2,5,5,Elements.WATER.id)),
        2,5)),

    LEVEL_4(LevelInfo(arrayOf(Square(0,0,3,3,Elements.FIRE.id),
                              Square(2,2,5,5,Elements.WATER.id)),
        2,6)),

    LEVEL_5(LevelInfo(arrayOf(Square(0,0,5,1,Elements.WATER.id),
                              Square(0,4,5,5,Elements.FIRE.id),
                              Square(4,0,5,5,Elements.FOREST.id)),
        5,9)),

    LEVEL_6(LevelInfo(arrayOf(Square(0,0,3,2,Elements.WATER.id),
                              Square(2,0,5,2,Elements.FIRE.id),
                              Square(0,2,5,4,Elements.FOREST.id)),
        4,11)),

    LEVEL_7(LevelInfo(arrayOf(Square(2,2,4,2,Elements.WATER.id),
                              Square(1,2,1,4,Elements.FIRE.id),
                              Square(0,4,2,4,Elements.FIRE.id),
                              Square(0,3,2,3,Elements.FOREST.id),
                              Square(3,1,3,3,Elements.FOREST.id)),
        3,6))
}