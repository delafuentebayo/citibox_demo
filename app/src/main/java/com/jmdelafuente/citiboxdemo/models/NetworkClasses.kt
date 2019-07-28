package com.jmdelafuente.citiboxdemo.models

import android.os.Parcel
import android.os.Parcelable

class NetworkClasses {
    data class Character(val id: Int, val name: String, val status: String, val species: String, val type: String,
                         val gender: String, val origin: OriginRM, val location: LocationRM, val image: String,
                         val episode: ArrayList<String>, val url: String, val created: String)
    data class OriginRM(val name: String, val url: String)
    data class LocationRM(val name: String, val url: String)
    data class Episodes(val info: InfoEpisodes, val results: ArrayList<Episode>)
    data class InfoEpisodes(val count: Int, val pages: Int, val next: String, val prev: String)
    data class Episode(val id: Int, val name: String, val air_date: String,
                       val episode: String, val characters: ArrayList<String>, val url: String, val created: String) :
        Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            arrayListOf<String>().apply {
                parcel.readList(this, String::class.java.classLoader)
            },
            parcel.readString(),
            parcel.readString()
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeInt(id)
            parcel.writeString(name)
            parcel.writeString(air_date)
            parcel.writeString(episode)
            parcel.writeList(characters)
            parcel.writeString(url)
            parcel.writeString(created)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Episode> {
            override fun createFromParcel(parcel: Parcel): Episode {
                return Episode(parcel)
            }

            override fun newArray(size: Int): Array<Episode?> {
                return arrayOfNulls(size)
            }
        }
    }
}