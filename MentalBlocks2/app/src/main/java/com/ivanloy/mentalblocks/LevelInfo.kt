package com.ivanloy.mentalblocks

import android.os.Parcel
import android.os.Parcelable

class LevelInfo(
    val squares : Array<Square> = arrayOf(),
    val targetMoves : Int = 0,
    val targetScore : Int = 0,
    val hintFixedPiece: FixedPiece? = null,
    val targetElementMoves : IntArray = intArrayOf(-1,-1,-1)
) : Parcelable {

    var movesLeft = targetMoves
    var elementMovesLeft = targetElementMoves.clone()
    var proportions : FloatArray = floatArrayOf(1f, 1f, 1f)
    var blocks : Array<Block> = Array(36) { Block() }
    var score : Int = 0

    constructor(parcel: Parcel) : this(
        parcel.createTypedArray(Square),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readParcelable(FixedPiece::class.java.classLoader),
        parcel.createIntArray()
    ) {
        movesLeft = parcel.readInt()
        elementMovesLeft = parcel.createIntArray()
        proportions = parcel.createFloatArray()
        score = parcel.readInt()
    }

    //TODO Refactor, UP is pieces, DOWN is colors, join both
    fun getBlockArray() : Array<Block>{
        var ret : Array<Block> = Array(36){ Block() }
        for(square in squares){

            for(i in square.xTop..square.xBot){
                for(j in square.yTop..square.yBot){

                    var elementIndex = 0
                    when(square.element) {
                        Elements.FIRE.id -> elementIndex = 0
                        Elements.FOREST.id -> elementIndex = 1
                        Elements.WATER.id -> elementIndex = 2
                    }
                    ret[i + j * 6].elements[elementIndex]++ //TODO Hardcoded 6

                }
            }

        }
        return ret
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedArray(squares, flags)
        parcel.writeInt(targetMoves)
        parcel.writeInt(targetScore)
        parcel.writeParcelable(hintFixedPiece, flags)
        parcel.writeIntArray(targetElementMoves)
        parcel.writeInt(movesLeft)
        parcel.writeIntArray(elementMovesLeft)
        parcel.writeFloatArray(proportions)
        parcel.writeInt(score)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LevelInfo> {
        override fun createFromParcel(parcel: Parcel): LevelInfo {
            return LevelInfo(parcel)
        }

        override fun newArray(size: Int): Array<LevelInfo?> {
            return arrayOfNulls(size)
        }
    }

}