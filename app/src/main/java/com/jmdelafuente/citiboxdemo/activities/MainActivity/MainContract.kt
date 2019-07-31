package com.jmdelafuente.citiboxdemo.activities.MainActivity

import com.jmdelafuente.citiboxdemo.activities.BasePresenter
import com.jmdelafuente.citiboxdemo.enums.ResponseErrors
import com.jmdelafuente.citiboxdemo.enums.SeasonCodes
import com.jmdelafuente.citiboxdemo.models.ActivityModels


class MainContract {
    interface View  {
        fun showEpisodes(episodes: List<ActivityModels.MainActivityModel>, seasons: List<SeasonCodes>)
        fun showError(error: ResponseErrors)

    }

    interface Presenter: BasePresenter<View> {
        fun getEpisodes()
    }
}