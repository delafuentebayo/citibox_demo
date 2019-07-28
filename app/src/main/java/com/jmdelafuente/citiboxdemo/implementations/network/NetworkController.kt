package com.jmdelafuente.citiboxdemo.implementations.network

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
                            callGetEpisodes(this)
                            NetworkBuilder().getRestService().getEpisodes()
                                .enqueue(this)
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
        callGetEpisodes(responseInterface)

    }

    private fun callGetEpisodes(callback: Callback<NetworkClasses.Episodes>) {
        NetworkBuilder().getRestService().getEpisodes()
            .enqueue(callback)
    }



    override fun getCharacters(charactersId: ArrayList<Int>, listener: ListenerCharacters) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}