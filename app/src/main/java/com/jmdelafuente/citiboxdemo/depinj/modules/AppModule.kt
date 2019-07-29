package com.upring.contacts.di.module

import com.jmdelafuente.citiboxdemo.implementations.network.NetworkController
import com.jmdelafuente.citiboxdemo.interfaces.network.INetworkController
import dagger.Module
import javax.inject.Singleton
import dagger.Provides


@Module
class AppModule {

    @Provides
    @Singleton
    fun provideNetworkController(): INetworkController {
        return NetworkController()
    }

}