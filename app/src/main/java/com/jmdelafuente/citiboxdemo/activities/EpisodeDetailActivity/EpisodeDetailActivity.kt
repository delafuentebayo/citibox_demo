package com.jmdelafuente.citiboxdemo.activities.EpisodeDetailActivity

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.loadingview.LoadingDialog
import com.jmdelafuente.citiboxdemo.R
import com.jmdelafuente.citiboxdemo.adapters.EpisodeDetailAdapter
import com.jmdelafuente.citiboxdemo.depinj.components.DaggerActivityComponent
import com.jmdelafuente.citiboxdemo.depinj.components.DaggerAppComponent
import com.jmdelafuente.citiboxdemo.enums.ResponseErrors
import com.jmdelafuente.citiboxdemo.models.ActivityModels
import kotlinx.android.synthetic.main.activity_episode_detail.*
import javax.inject.Inject
import android.widget.RadioGroup
import com.jmdelafuente.citiboxdemo.depinj.modules.ActivityModule
import com.jmdelafuente.citiboxdemo.depinj.modules.AppModule
import com.jmdelafuente.citiboxdemo.enums.StatusFilter


class EpisodeDetailActivity : AppCompatActivity(), EpisodeDetailContract.View {
    @Inject
    lateinit var presenter: EpisodeDetailContract.Presenter
    private lateinit var episodeTitle: String
    private lateinit var episodeCode: String
    private lateinit var characters: ArrayList<String>
    private lateinit var dialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episode_detail)
        episodeTitle = intent.getStringExtra("episode_title")
        episodeCode = intent.getStringExtra("episode_code")
        characters = intent.getStringArrayListExtra("episode_characters")
        supportActionBar?.title = getString(R.string.episode_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);
        DaggerActivityComponent.builder().appComponent(DaggerAppComponent.builder().appModule(AppModule()).build()).
            activityModule(ActivityModule(this)).build().inject(this)
        presenter.attach(this)
        initializeElements()
        initializeRecyclerView()
        dialog = LoadingDialog[this].show()
        presenter.getCharacters(characters)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun showCharacters(characters: List<ActivityModels.EpisodeDetailActivityModel>) {
        dialog.hide()
        (episode_detail_rv.adapter as EpisodeDetailAdapter ).setData(characters)
    }

    private fun initializeRecyclerView() {
        episode_detail_rv.layoutManager = LinearLayoutManager(this)
        episode_detail_rv.adapter = EpisodeDetailAdapter(this, ArrayList())

    }
    override fun showError(error: ResponseErrors) {
        dialog.hide()
        when(error){
            ResponseErrors.NO_CONNECTION -> Toast.makeText(this, getString(R.string.no_connection), Toast.LENGTH_LONG).show()
            ResponseErrors.SERVER_ERROR -> Toast.makeText(this, getString(R.string.server_error), Toast.LENGTH_LONG).show()
        }
    }

    private fun initializeElements() {
        episode_detail_title.text = getString(R.string.episode_title, episodeTitle)
        episode_detail_code.text =  getString(R.string.episode_code, episodeCode)
        episode_detail_show_filter_rl.setOnClickListener {
            if (episode_detail_filter_rg.visibility == View.VISIBLE) {
                episode_detail_filter_rg.visibility = View.GONE
                ObjectAnimator.ofFloat(episode_detail_show_filter_iv, View.ROTATION, 180f, 0f).setDuration(300).start();

            } else {
                episode_detail_filter_rg.visibility = View.VISIBLE
                ObjectAnimator.ofFloat(episode_detail_show_filter_iv, View.ROTATION, 0f, 180f).setDuration(300).start();

            }

        }
        episode_detail_filter_rg.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {

            override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
                when (checkedId) {
                    R.id.episode_detail_filter_all -> presenter.changedFilter(StatusFilter.ALL)
                    R.id.episode_detail_filter_alive -> presenter.changedFilter(StatusFilter.ALIVE)
                    R.id.episode_detail_filter_died -> presenter.changedFilter(StatusFilter.DIED)
                    R.id.episode_detail_filter_unknown -> presenter.changedFilter(StatusFilter.UNKNOWN)

                }

            }

        })
    }
}
