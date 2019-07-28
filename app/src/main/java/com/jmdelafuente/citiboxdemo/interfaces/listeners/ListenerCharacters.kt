package com.jmdelafuente.citiboxdemo.interfaces.listeners

import com.jmdelafuente.citiboxdemo.enums.ResponseErrors
import com.jmdelafuente.citiboxdemo.models.NetworkClasses

interface ListenerCharacters {
    fun getCharactersOK(characters: ArrayList<NetworkClasses.Character>)
    fun getCharactersKO(error: ResponseErrors)

}
