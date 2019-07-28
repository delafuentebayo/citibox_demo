package com.jmdelafuente.citiboxdemo.implementations.network

import com.google.gson.GsonBuilder
import com.jmdelafuente.citiboxdemo.BuildConfig
import com.jmdelafuente.citiboxdemo.interfaces.network.NetworkInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkBuilder {
    private val baseUrl:String = BuildConfig.BASE_URL
    private var retrofit: Retrofit
    private var restService: NetworkInterface

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor).build()
        val gson = GsonBuilder()
            .setLenient()
            .create()
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        restService = retrofit.create(NetworkInterface::class.java)
    }

    fun getRestService(): NetworkInterface {
        return restService
    }


}