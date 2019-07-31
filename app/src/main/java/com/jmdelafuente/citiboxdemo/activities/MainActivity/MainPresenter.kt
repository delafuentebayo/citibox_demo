package com.jmdelafuente.citiboxdemo.activities.MainActivity

import android.content.Context
import android.provider.ContactsContract
import com.jmdelafuente.citiboxdemo.enums.ResponseErrors
import com.jmdelafuente.citiboxdemo.enums.SeasonCodes
import com.jmdelafuente.citiboxdemo.extensions.getSeason
import com.jmdelafuente.citiboxdemo.extensions.toMainActivityModel
import com.jmdelafuente.citiboxdemo.interfaces.listeners.ListenerEpisodes
import com.jmdelafuente.citiboxdemo.interfaces.network.INetworkController
import com.jmdelafuente.citiboxdemo.models.NetworkClasses
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class MainPresenter
@Inject
constructor(private val networkController: INetworkController): MainContract.Presenter{

    private lateinit var view: MainContract.View

    override fun attach(view: MainContract.View) {
        this.view = view
    }

    override fun getEpisodes() {
        val listener =  object:ListenerEpisodes{
            override fun getEpisodesOK(episodes: ArrayList<NetworkClasses.Episode>) {
                val episodesModel = episodes.map {
                    it.toMainActivityModel()
                }
                val seasons = episodes.map {
                    it.getSeason()
                }

                view.showEpisodes(episodesModel, seasons)

            }

            override fun getEpisodesKO(error: ResponseErrors) {
                view.showError(error)

            }

        }

        networkController.getEpisodes(listener)

    }

}