package com.ivanloy.mentalblocks

class Block(
    var elements : IntArray = intArrayOf(0,0,0) //MAX of a color in block
){

    var points : Int = 0
    var piece : Int = Elements.EMPTY.intCode //TODO AHHHH; BUSCAR FORMA CON ENUM, CONIO
    var fixed : Boolean = false
    var score : Int = 0

    fun getColor() : Int {
        var ret : Int = BlockColors.EMPTY_BLOCK.intCode

        if(intArrayOf(1,0,0) contentEquals elements) { //TODO Try weird switch
            ret = BlockColors.RED.intCode
        }
        else if(intArrayOf(0,1,0) contentEquals elements) {
            ret = BlockColors.GREEN.intCode
        }
        else if(intArrayOf(0,0,1) contentEquals elements) {
            ret = BlockColors.BLUE.intCode
        }
        else if(intArrayOf(2,0,0) contentEquals elements) {
            ret = BlockColors.C_2R.intCode
        }
        else if(intArrayOf(0,0,2) contentEquals elements) {
            ret = BlockColors.C_2B.intCode
        }
        else if(intArrayOf(0,2,0) contentEquals elements) {
            ret = BlockColors.C_2G.intCode
        }
        else if(intArrayOf(1,0,1) contentEquals elements) {
            ret = BlockColors.C_RB.intCode
        }
        else if(intArrayOf(1,1,0) contentEquals elements) {
            ret = BlockColors.C_RG.intCode
        }
        else if(intArrayOf(0,1,1) contentEquals elements) {
            ret = BlockColors.C_GB.intCode
        }
        else if(intArrayOf(1,1,1) contentEquals elements) {
            ret = BlockColors.C_RGB.intCode
        }


        return ret
    }

}