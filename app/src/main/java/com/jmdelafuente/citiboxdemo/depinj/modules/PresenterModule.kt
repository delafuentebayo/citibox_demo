package com.jmdelafuente.citiboxdemo.depinj.modules

import com.jmdelafuente.citiboxdemo.activities.EpisodeDetailActivity.EpisodeDetailContract
import com.jmdelafuente.citiboxdemo.activities.EpisodeDetailActivity.EpisodeDetailPresenter
import com.jmdelafuente.citiboxdemo.activities.MainActivity.MainContract
import com.jmdelafuente.citiboxdemo.activities.MainActivity.MainPresenter
import com.jmdelafuente.citiboxdemo.depinj.scopes.PerActivity
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    @PerActivity
    internal fun provideMainPresenter(presenter: MainPresenter): MainContract.Presenter {
        return presenter
    }

    @Provides
    @PerActivity
    internal fun provideEpisodeDetailPresenter(presenter: EpisodeDetailPresenter): EpisodeDetailContract.Presenter {
        return presenter
    }



}