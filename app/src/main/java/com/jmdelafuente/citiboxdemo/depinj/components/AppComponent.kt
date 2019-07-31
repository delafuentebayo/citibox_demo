package com.jmdelafuente.citiboxdemo.depinj.components

import com.jmdelafuente.citiboxdemo.depinj.modules.AppModule
import com.jmdelafuente.citiboxdemo.interfaces.network.INetworkController
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun networkController(): INetworkController
}