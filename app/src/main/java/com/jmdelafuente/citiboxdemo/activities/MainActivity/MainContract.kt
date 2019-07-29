package com.jmdelafuente.citiboxdemo.activities.MainActivity

import android.content.Context
import com.jmdelafuente.citiboxdemo.activities.BasePresenter
import com.jmdelafuente.citiboxdemo.enums.ResponseErrors
import com.jmdelafuente.citiboxdemo.enums.SeasonCodes


class MainContract {
    interface View  {
        fun showEpisodes(episodes: List<MainActivityModel>, seasons: List<SeasonCodes>)
        fun showError(error: ResponseErrors)

    }

    interface Presenter: BasePresenter<View> {
        fun getEpisodes()
    }
}