package com.jmdelafuente.citiboxdemo.views

import com.jmdelafuente.citiboxdemo.activities.MainActivity.MainContract
import com.jmdelafuente.citiboxdemo.enums.ResponseErrors
import com.jmdelafuente.citiboxdemo.enums.SeasonCodes
import com.jmdelafuente.citiboxdemo.models.ActivityModels

class MainViewMock: MainContract.View {
    var showError = false
    var episodesTest: List<ActivityModels.MainActivityModel> = ArrayList()
    override fun showEpisodes(episodes: List<ActivityModels.MainActivityModel>, seasons: List<SeasonCodes>) {
        episodesTest = episodes
    }

    override fun showError(error: ResponseErrors) {
        showError = true
    }


}