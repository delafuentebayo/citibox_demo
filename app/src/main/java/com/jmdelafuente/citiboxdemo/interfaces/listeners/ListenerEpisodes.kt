package com.jmdelafuente.citiboxdemo.interfaces.listeners

import com.jmdelafuente.citiboxdemo.enums.ResponseErrors
import com.jmdelafuente.citiboxdemo.models.NetworkClasses

interface ListenerEpisodes {
    fun getEpisodesOK(episodes: ArrayList<NetworkClasses.Episode>)
    fun getEpisodesKO(error: ResponseErrors)

}
