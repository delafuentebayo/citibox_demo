package com.jmdelafuente.citiboxdemo.activities.MainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jmdelafuente.citiboxdemo.R
import com.jmdelafuente.citiboxdemo.depinj.components.DaggerActivityComponent
import com.jmdelafuente.citiboxdemo.depinj.components.DaggerAppComponent
import com.upring.contacts.di.module.ActivityModule
import com.upring.contacts.di.module.AppModule
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = getString(R.string.episodes)
        DaggerActivityComponent.builder().appComponent(DaggerAppComponent.builder().appModule(AppModule()).build()).
            activityModule(ActivityModule(this)).build().inject(this)

    }

    override fun showEpisodes() {
    }
}
