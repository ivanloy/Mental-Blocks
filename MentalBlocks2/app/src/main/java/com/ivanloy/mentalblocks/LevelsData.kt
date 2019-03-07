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
        3,6)),

    LEVEL_8(LevelInfo(arrayOf(Square(0,1,0,3,Elements.WATER.id),
                              Square(5,1,5,3,Elements.WATER.id),
                              Square(0,2,5,2,Elements.FOREST.id),
                              Square(2,1,3,4,Elements.FIRE.id)),
        7,13)),

    LEVEL_9(LevelInfo(arrayOf(Square(1,2,2,4,Elements.WATER.id),
                              Square(4,1,4,4,Elements.WATER.id),
                              Square(2,1,3,4,Elements.FIRE.id),
                              Square(0,2,5,2,Elements.FOREST.id)),
        6,2)),

    LEVEL_10(LevelInfo(arrayOf(Square(2,0,3,5,Elements.FIRE.id),
                               Square(0,2,5,3,Elements.WATER.id)),
        10,0, intArrayOf(10, 0, 0))),

    LEVEL_11(LevelInfo(arrayOf(Square(1,0,4,1,Elements.FIRE.id),
                               Square(1,3,4,4,Elements.FOREST.id),
                               Square(1,2,4,2,Elements.WATER.id),
                               Square(2,1,3,3,Elements.WATER.id)),
        6,9, intArrayOf(2, 2, 2))),

    LEVEL_12(LevelInfo(arrayOf(Square(1,3,2,4,Elements.WATER.id),
                                Square(2,2,3,3,Elements.WATER.id),
                                Square(3,1,4,2,Elements.WATER.id),
                                Square(4,2,5,3,Elements.WATER.id),
                                Square(0,2,1,3,Elements.WATER.id)),
        7,8, intArrayOf(1, 4, 2))),

    LEVEL_13(LevelInfo(arrayOf(Square(2,0,3,5,Elements.FIRE.id),
                                Square(0,2,5,3,Elements.FOREST.id),
                                Square(0,3,5,4,Elements.WATER.id)),
        12,10, intArrayOf(4, 2, 3))),

    LEVEL_14(LevelInfo(arrayOf(Square(0,3,1,4,Elements.WATER.id),
                                Square(4,1,5,2,Elements.WATER.id),
                                Square(2,2,3,3,Elements.FIRE.id),
                                Square(1,1,2,2,Elements.FOREST.id),
                                Square(3,3,4,4,Elements.FOREST.id)),
        8,7, intArrayOf(4, 0, 4))),

    LEVEL_15(LevelInfo(arrayOf(Square(1,1,4,2,Elements.WATER.id),
                                Square(1,4,4,4,Elements.FIRE.id),
                                Square(2,2,3,3,Elements.FOREST.id)),
        6,0, intArrayOf(2, 2, 2))),

}