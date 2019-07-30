package com.jmdelafuente.citiboxdemo.activities.EpisodeDetailActivity

import com.jmdelafuente.citiboxdemo.enums.ResponseErrors
import com.jmdelafuente.citiboxdemo.extensions.getSeason
import com.jmdelafuente.citiboxdemo.extensions.toMainActivityModel
import com.jmdelafuente.citiboxdemo.interfaces.listeners.ListenerEpisodes
import com.jmdelafuente.citiboxdemo.interfaces.network.INetworkController
import com.jmdelafuente.citiboxdemo.models.NetworkClasses
import javax.inject.Inject
import kotlin.collections.ArrayList

class EpisodeDetailPresenter
@Inject
constructor(private val networkController: INetworkController): EpisodeDetailContract.Presenter{

    private lateinit var view: EpisodeDetailContract.View

    override fun attach(view: EpisodeDetailContract.View) {
        this.view = view
    }

    override fun getCharacters() {
        val listener =  object:ListenerEpisodes{
            override fun getEpisodesOK(episodes: ArrayList<NetworkClasses.Episode>) {
                val episodesModel = episodes.map {
                    it.toMainActivityModel()
                }
                val seasons = episodes.map {
                    it.getSeason()
                }

                //view.showEpisodes(episodesModel, seasons)

            }

            override fun getEpisodesKO(error: ResponseErrors) {
                view.showError(error)

            }

        }

        networkController.getEpisodes(listener)

    }

}