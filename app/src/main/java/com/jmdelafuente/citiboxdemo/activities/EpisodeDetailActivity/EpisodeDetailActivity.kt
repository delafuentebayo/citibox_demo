package com.jmdelafuente.citiboxdemo.activities.EpisodeDetailActivity

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.jmdelafuente.citiboxdemo.R
import com.jmdelafuente.citiboxdemo.activities.MainActivity.MainContract
import com.jmdelafuente.citiboxdemo.depinj.components.DaggerActivityComponent
import com.jmdelafuente.citiboxdemo.depinj.components.DaggerAppComponent
import com.jmdelafuente.citiboxdemo.enums.ResponseErrors
import com.jmdelafuente.citiboxdemo.models.ActivityModels
import com.upring.contacts.di.module.ActivityModule
import com.upring.contacts.di.module.AppModule
import kotlinx.android.synthetic.main.activity_episode_detail.*
import javax.inject.Inject

class EpisodeDetailActivity : AppCompatActivity(), EpisodeDetailContract.View {
    @Inject
    lateinit var presenter: EpisodeDetailContract.Presenter
    private lateinit var episodeTitle: String
    private lateinit var episodeCode: String
    private lateinit var characters: ArrayList<String>

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
        presenter.getCharacters()
        initializeElements()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun showCharacters() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(error: ResponseErrors) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
    }
}
