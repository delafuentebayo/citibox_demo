package com.jmdelafuente.citiboxdemo.mocks

import com.jmdelafuente.citiboxdemo.enums.ResponseErrors
import com.jmdelafuente.citiboxdemo.enums.StatusFilter
import com.jmdelafuente.citiboxdemo.interfaces.listeners.ListenerCharacters
import com.jmdelafuente.citiboxdemo.interfaces.listeners.ListenerEpisodes
import com.jmdelafuente.citiboxdemo.interfaces.network.INetworkController
import com.jmdelafuente.citiboxdemo.models.NetworkClasses

class NetworkControllerMock:INetworkController {
    var characters: List<Int> = ArrayList()
    var makeCallFails = false
    override fun getEpisodes(listener: ListenerEpisodes) {
        if (makeCallFails){
            listener.getEpisodesKO(ResponseErrors.SERVER_ERROR)

        } else {
            val episodes: ArrayList<NetworkClasses.Episode> = ArrayList()
            episodes.add(NetworkClasses.Episode(1, "Episodio 1",
                "2019-08-01", "S01", ArrayList(), "", "2019-08-01"))
            episodes.add(NetworkClasses.Episode(2, "Episodio 2",
                "2019-08-01", "S01", ArrayList(), "", "2019-08-01"))
            episodes.add(NetworkClasses.Episode(3, "Episodio 3",
                "2019-08-01", "S01", ArrayList(), "", "2019-08-01"))
            episodes.add(NetworkClasses.Episode(127, "Episodio 4",
                "2019-08-01", "S01", ArrayList(), "", "2019-08-01"))

            listener.getEpisodesOK(episodes)
        }
    }

    override fun getCharacters(charactersId: List<Int>, listener: ListenerCharacters) {
        characters = charactersId
        if (makeCallFails){
            listener.getCharactersKO(ResponseErrors.SERVER_ERROR)

        } else {
            val charactersModel: ArrayList<NetworkClasses.Character> = ArrayList()
            charactersModel.add(NetworkClasses.Character(1,"Test1", StatusFilter.ALIVE.value,"Human", "","Image"))
            charactersModel.add(NetworkClasses.Character(2,"Test2", StatusFilter.ALIVE.value,"Human", "","Image"))
            charactersModel.add(NetworkClasses.Character(3,"Test3", StatusFilter.DIED.value,"Human", "","Image"))
            charactersModel.add(NetworkClasses.Character(4,"Test4", StatusFilter.UNKNOWN.value,"Human", "","Image"))

            listener.getCharactersOK(charactersModel)

        }
    }
}