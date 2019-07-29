package com.jmdelafuente.citiboxdemo.depinj.components

import android.content.Context
import com.jmdelafuente.citiboxdemo.interfaces.network.INetworkController
import com.upring.contacts.di.module.AppModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun networkController(): INetworkController
}