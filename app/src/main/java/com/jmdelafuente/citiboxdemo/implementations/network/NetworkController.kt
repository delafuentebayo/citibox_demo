package com.jmdelafuente.citiboxdemo.implementations.network

import android.net.Uri
import android.util.Log
import com.jmdelafuente.citiboxdemo.enums.ResponseErrors
import com.jmdelafuente.citiboxdemo.interfaces.listeners.ListenerCharacters
import com.jmdelafuente.citiboxdemo.interfaces.listeners.ListenerEpisodes
import com.jmdelafuente.citiboxdemo.interfaces.network.INetworkController
import com.jmdelafuente.citiboxdemo.models.NetworkClasses
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkController: INetworkController {

    override fun getEpisodes(listener: ListenerEpisodes) {
        val episodes: ArrayList<NetworkClasses.Episode> = ArrayList()
        val responseInterface = object : Callback<NetworkClasses.Episodes> {
            override fun onResponse(call: Call<NetworkClasses.Episodes>, response: Response<NetworkClasses.Episodes>) {
                if (response.isSuccessful) {
                    response.body()?.let {body->
                        episodes.addAll(body.results)
                        if (body.info.next.isNotEmpty()) {
                            val uri = Uri.parse(body.info.next)

                            callGetNextEpisodes(this, uri.getQueryParameter("page")!!)
                        } else {
                            listener.getEpisodesOK(episodes)
                        }
                    }

                } else {
                    listener.getEpisodesKO(ResponseErrors.SERVER_ERROR)
                }
            }
            override fun onFailure(call: Call<NetworkClasses.Episodes>, t: Throwable) {
                listener.getEpisodesKO(ResponseErrors.NO_CONNECTION)

            }
        }
        NetworkBuilder().getRestService().getEpisodes()
            .enqueue(responseInterface)

    }

    private fun callGetNextEpisodes(callback: Callback<NetworkClasses.Episodes>, page: String) {
        NetworkBuilder().getRestService().getNextEpisodes(page)
            .enqueue(callback)
    }



    override fun getCharacters(charactersId: List<Int>, listener: ListenerCharacters) {
        NetworkBuilder().getRestService().getCharacters(charactersId)
            .enqueue(object : Callback<ArrayList<NetworkClasses.Character>> {
                override fun onResponse(call: Call<ArrayList<NetworkClasses.Character>>, response: Response<ArrayList<NetworkClasses.Character>>) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            listener.getCharactersOK(it)
                        }?:run {
                            listener.getCharactersKO(ResponseErrors.SERVER_ERROR)
                        }
                    } else {
                        listener.getCharactersKO(ResponseErrors.SERVER_ERROR)
                    }
                }
                override fun onFailure(call: Call<ArrayList<NetworkClasses.Character>>, t: Throwable) {
                    listener.getCharactersKO(ResponseErrors.NO_CONNECTION)

                }
            })
    }
}