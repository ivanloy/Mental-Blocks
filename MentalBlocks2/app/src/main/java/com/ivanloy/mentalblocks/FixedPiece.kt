package com.ivanloy.mentalblocks

import android.os.Parcel
import android.os.Parcelable

data class FixedPiece(val xx : Int, val yy: Int, val element: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(xx)
        parcel.writeInt(yy)
        parcel.writeInt(element)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FixedPiece> {
        override fun createFromParcel(parcel: Parcel): FixedPiece {
            return FixedPiece(parcel)
        }

        override fun newArray(size: Int): Array<FixedPiece?> {
            return arrayOfNulls(size)
        }
    }

}