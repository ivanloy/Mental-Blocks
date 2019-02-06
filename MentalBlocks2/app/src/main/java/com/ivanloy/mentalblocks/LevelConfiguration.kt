package com.ivanloy.mentalblocks

class LevelConfiguration(
    var squares : Array<Square> = arrayOf()
) {
    var maxMoves : Int = 1
    var proportions : FloatArray = floatArrayOf(1f, 1f, 1f)

    fun getBlockArray() : Array<Block>{
        var ret : Array<Block> = Array(36){ Block() }
        for(square in squares){

            for(i in square.xTop..square.xBot){
                for(j in square.yTop..square.yBot){

                    var elementIndex = 0
                    when(square.element) {
                        Elements.FIRE -> elementIndex = 0
                        Elements.FOREST -> elementIndex = 1
                        Elements.WATER -> elementIndex = 2
                    }
                    ret[i + j * 6].elements[elementIndex]++ //TODO Hardcoded 6

                }
            }

        }
        return ret
    }

}