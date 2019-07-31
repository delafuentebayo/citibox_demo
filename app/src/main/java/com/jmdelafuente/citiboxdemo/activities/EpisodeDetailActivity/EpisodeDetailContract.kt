package com.jmdelafuente.citiboxdemo.activities.EpisodeDetailActivity

import com.jmdelafuente.citiboxdemo.activities.BasePresenter
import com.jmdelafuente.citiboxdemo.enums.ResponseErrors
import com.jmdelafuente.citiboxdemo.enums.SeasonCodes
import com.jmdelafuente.citiboxdemo.enums.StatusFilter
import com.jmdelafuente.citiboxdemo.models.ActivityModels


class EpisodeDetailContract {
    interface View  {
        fun showCharacters(characters: List<ActivityModels.EpisodeDetailActivityModel>)
        fun showError(error: ResponseErrors)

    }

    interface Presenter: BasePresenter<View> {
        fun getCharacters(charactersUrl: ArrayList<String>)
        fun changedFilter(statusFilter: StatusFilter)
    }
}