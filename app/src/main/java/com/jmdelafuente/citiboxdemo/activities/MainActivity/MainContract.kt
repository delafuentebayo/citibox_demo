package com.jmdelafuente.citiboxdemo.activities.MainActivity

import android.content.Context
import com.jmdelafuente.citiboxdemo.activities.BasePresenter


class MainContract {
    interface View  {
        fun showEpisodes()

    }

    interface Presenter: BasePresenter<View> {
    }
}