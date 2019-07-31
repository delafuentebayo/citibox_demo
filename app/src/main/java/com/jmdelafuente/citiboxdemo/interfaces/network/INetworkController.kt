package com.jmdelafuente.citiboxdemo.interfaces.network

import com.jmdelafuente.citiboxdemo.interfaces.listeners.ListenerCharacters
import com.jmdelafuente.citiboxdemo.interfaces.listeners.ListenerEpisodes
import com.jmdelafuente.citiboxdemo.models.NetworkClasses

interface INetworkController {
    fun getEpisodes(listener: ListenerEpisodes)
    fun getCharacters(charactersId: List<Int>, listener: ListenerCharacters)
}