package com.jmdelafuente.citiboxdemo.models

class NetworkClasses {
    data class Character(val id: Int, val name: String, val status: String, val species: String, val type: String,
                         val gender: String, val origin: OriginRM, val location: LocationRM, val image: String,
                         val episode: ArrayList<String>, val url: String, val created: String)
    data class OriginRM(val name: String, val url: String)
    data class LocationRM(val name: String, val url: String)
    data class Episodes(val info: InfoEpisodes, val results: ArrayList<Episode>)
    data class InfoEpisodes(val count: Int, val pages: Int, val next: String, val prev: String)
    data class Episode(val id: Int, val name: String, val air_date: String,
                       val episode: String, val characters: ArrayList<String>, val url: String, val created: String)
}