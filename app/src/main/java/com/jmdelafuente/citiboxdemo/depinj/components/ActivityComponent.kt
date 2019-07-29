package com.jmdelafuente.citiboxdemo.depinj.components

import com.jmdelafuente.citiboxdemo.activities.MainActivity.MainActivity
import com.jmdelafuente.citiboxdemo.depinj.modules.PresenterModule
import com.jmdelafuente.citiboxdemo.depinj.scopes.PerActivity
import com.upring.contacts.di.module.ActivityModule
import dagger.Component


@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class, PresenterModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)

}