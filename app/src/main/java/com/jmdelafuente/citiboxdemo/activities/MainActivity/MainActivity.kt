package com.jmdelafuente.citiboxdemo.activities.MainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.loadingview.LoadingDialog
import com.jmdelafuente.citiboxdemo.R
import com.jmdelafuente.citiboxdemo.adapters.EpisodesRecyclerAdapter
import com.jmdelafuente.citiboxdemo.adapters.RecyclerViewEpisodesHeader
import com.jmdelafuente.citiboxdemo.depinj.components.DaggerActivityComponent
import com.jmdelafuente.citiboxdemo.depinj.components.DaggerAppComponent
import com.jmdelafuente.citiboxdemo.enums.ResponseErrors
import com.jmdelafuente.citiboxdemo.enums.SeasonCodes
import com.jmdelafuente.citiboxdemo.models.ActivityModels
import com.upring.contacts.di.module.ActivityModule
import com.upring.contacts.di.module.AppModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter
    private lateinit var dialog:LoadingDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = getString(R.string.episodes)
        DaggerActivityComponent.builder().appComponent(DaggerAppComponent.builder().appModule(AppModule()).build()).
            activityModule(ActivityModule(this)).build().inject(this)
        presenter.attach(this)
        presenter.getEpisodes()
        dialog = LoadingDialog[this].show()

    }

    override fun showEpisodes(episodes: List<ActivityModels.MainActivityModel>, seasons: List<SeasonCodes>) {
        dialog.hide()
        initializeRecyclerView(episodes, seasons)
    }

    override fun showError(error: ResponseErrors) {
        dialog.hide()
        when(error){
            ResponseErrors.NO_CONNECTION -> Toast.makeText(this, getString(R.string.no_connection), Toast.LENGTH_LONG).show()
            ResponseErrors.SERVER_ERROR -> Toast.makeText(this, getString(R.string.server_error), Toast.LENGTH_LONG).show()
        }
    }

    private fun initializeRecyclerView(episodes: List<ActivityModels.MainActivityModel>, seasons: List<SeasonCodes>) {
        main_rv.layoutManager = LinearLayoutManager(this)
        main_rv.adapter = EpisodesRecyclerAdapter(this, episodes)
        main_rv.addItemDecoration(RecyclerViewEpisodesHeader(resources.getDimensionPixelSize(R.dimen.height_header),
            true,
            getSectionCallback(seasons)))
    }

    private fun getSectionCallback(seasons: List<SeasonCodes>): RecyclerViewEpisodesHeader.SectionCallback {
        return object : RecyclerViewEpisodesHeader.SectionCallback {
            override fun isSection(position: Int): Boolean {
                return if (position < seasons.size && seasons.isNotEmpty()) {
                    position == 0 || seasons[position] != seasons[position - 1]

                } else {
                    false
                }
            }

            override fun getSectionHeader(position: Int): String {
                return if (position < seasons.size && seasons.isNotEmpty()) {
                    seasons[position].getVisualizationLabel(this@MainActivity)
                } else {
                    " "
                }

            }
        }
    }
}
