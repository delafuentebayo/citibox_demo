package com.jmdelafuente.citiboxdemo.activities.EpisodeDetailActivity

import com.jmdelafuente.citiboxdemo.enums.ResponseErrors
import com.jmdelafuente.citiboxdemo.enums.StatusFilter
import com.jmdelafuente.citiboxdemo.extensions.getCharacterId
import com.jmdelafuente.citiboxdemo.extensions.toEpisodeDetailActivityModel
import com.jmdelafuente.citiboxdemo.interfaces.listeners.ListenerCharacters
import com.jmdelafuente.citiboxdemo.interfaces.network.INetworkController
import com.jmdelafuente.citiboxdemo.models.ActivityModels
import com.jmdelafuente.citiboxdemo.models.NetworkClasses
import javax.inject.Inject
import kotlin.collections.ArrayList

class EpisodeDetailPresenter
@Inject
constructor(private val networkController: INetworkController): EpisodeDetailContract.Presenter{

    private lateinit var view: EpisodeDetailContract.View
    private var charactersModel: List<ActivityModels.EpisodeDetailActivityModel> = ArrayList()
    override fun attach(view: EpisodeDetailContract.View) {
        this.view = view
    }

    override fun getCharacters(charactersUrl: ArrayList<String>) {
        val listener =  object:ListenerCharacters{
            override fun getCharactersOK(characters: ArrayList<NetworkClasses.Character>) {
                charactersModel = characters.map { it.toEpisodeDetailActivityModel() }
                view.showCharacters(charactersModel)
            }

            override fun getCharactersKO(error: ResponseErrors) {
                view.showError(error)
            }
        }

        networkController.getCharacters(charactersUrl.map { it.getCharacterId() }, listener)

    }

    override fun changedFilter(statusFilter: StatusFilter){
        when(statusFilter){
            StatusFilter.ALL -> {
                view.showCharacters(charactersModel)
            }
            StatusFilter.ALIVE -> {
                view.showCharacters(charactersModel.filter { it.status == StatusFilter.ALIVE.value})
            }
            StatusFilter.DIED -> {
                view.showCharacters(charactersModel.filter { it.status == StatusFilter.DIED.value})
            }
            StatusFilter.UNKNOWN -> {
                view.showCharacters(charactersModel.filter { it.status == StatusFilter.UNKNOWN.value})
            }
        }
    }

}