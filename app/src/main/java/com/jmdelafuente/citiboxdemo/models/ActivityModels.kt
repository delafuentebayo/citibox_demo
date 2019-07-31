package com.jmdelafuente.citiboxdemo.models

class ActivityModels {
    data class MainActivityModel (val code: String, val title: String, val characters: ArrayList<String>)
    data class EpisodeDetailActivityModel (val name: String, val type: String, val status: String, val image: String)

}
