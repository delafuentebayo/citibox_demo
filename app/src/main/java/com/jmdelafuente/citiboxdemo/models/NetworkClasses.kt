package com.jmdelafuente.citiboxdemo.models

class NetworkClasses {
    data class Character(val id: Int, val name: String, val status: String, val species: String,
                         val type: String, val image: String)

    data class Episodes(val info: InfoEpisodes, val results: ArrayList<Episode>)
    data class InfoEpisodes(val count: Int, val pages: Int, val next: String, val prev: String)
    data class Episode(val id: Int, val name: String, val air_date: String,
                       val episode: String, val characters: ArrayList<String>, val url: String, val created: String)
}