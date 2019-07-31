package com.jmdelafuente.citiboxdemo.views

import com.jmdelafuente.citiboxdemo.activities.EpisodeDetailActivity.EpisodeDetailContract
import com.jmdelafuente.citiboxdemo.enums.ResponseErrors
import com.jmdelafuente.citiboxdemo.models.ActivityModels

class EpisodeDetailMock: EpisodeDetailContract.View {
    var charactersTest: List<ActivityModels.EpisodeDetailActivityModel> = ArrayList()
    var showError = false
    override fun showCharacters(characters: List<ActivityModels.EpisodeDetailActivityModel>) {
        charactersTest = characters
    }

    override fun showError(error: ResponseErrors) {
        showError = true
    }


}