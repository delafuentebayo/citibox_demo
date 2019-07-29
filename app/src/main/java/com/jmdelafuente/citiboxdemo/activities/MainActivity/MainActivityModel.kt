package com.jmdelafuente.citiboxdemo.activities.MainActivity

import android.os.Parcel
import android.os.Parcelable

class MainActivityModel (private val season: String, private val code: Int, private val title: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(season)
        parcel.writeInt(code)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivityModel> {
        override fun createFromParcel(parcel: Parcel): MainActivityModel {
            return MainActivityModel(parcel)
        }

        override fun newArray(size: Int): Array<MainActivityModel?> {
            return arrayOfNulls(size)
        }
    }

}