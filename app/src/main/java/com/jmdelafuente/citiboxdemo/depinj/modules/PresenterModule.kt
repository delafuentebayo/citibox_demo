package com.jmdelafuente.citiboxdemo.depinj.modules

import com.jmdelafuente.citiboxdemo.activities.MainActivity.MainContract
import com.jmdelafuente.citiboxdemo.activities.MainActivity.MainPresenter
import com.jmdelafuente.citiboxdemo.depinj.scopes.PerActivity
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    @PerActivity
    internal fun provideSplashPresenter(presenter: MainPresenter): MainContract.Presenter {
        return presenter
    }



}