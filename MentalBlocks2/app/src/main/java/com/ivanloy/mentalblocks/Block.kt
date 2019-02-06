package com.ivanloy.mentalblocks

class Block(
    var elements : IntArray = intArrayOf(0,0,0) //MAX of a color in block
){

    var points : Int = 0
    var piece : Elements = Elements.EMPTY

    fun getColor() : Int {
        var ret : Int = BlockColors.EMPTY_BLOCK.intCode

        if(intArrayOf(1,0,0) contentEquals elements) {
            ret = BlockColors.RED.intCode
        }
        else if(intArrayOf(0,1,0) contentEquals elements) {
            ret = BlockColors.GREEN.intCode
        }
        else if(intArrayOf(0,0,1) contentEquals elements) {
            ret = BlockColors.BLUE.intCode
        }

        return ret
    }

}