package com.ivanloy.mentalblocks

import android.os.Parcel
import android.os.Parcelable

class Square( //TODO Max 6,
    var xTop : Byte = 0,
    var yTop : Byte = 0,
    var xBot : Byte = 0,
    var yBot : Byte = 0,
    var element : Int = Elements.EMPTY.id
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readByte(),
        parcel.readByte(),
        parcel.readByte(),
        parcel.readByte(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(xTop)
        parcel.writeByte(yTop)
        parcel.writeByte(xBot)
        parcel.writeByte(yBot)
        parcel.writeInt(element)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Square> {
        override fun createFromParcel(parcel: Parcel): Square {
            return Square(parcel)
        }

        override fun newArray(size: Int): Array<Square?> {
            return arrayOfNulls(size)
        }
    }

}