package com.jmdelafuente.citiboxdemo.adapters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jmdelafuente.citiboxdemo.R
import com.jmdelafuente.citiboxdemo.activities.MainActivity.MainActivityModel
import kotlinx.android.synthetic.main.item_episodes.view.*


class EpisodesRecyclerAdapter constructor(private var mContext: Context, private val items: List<MainActivityModel>) :
    RecyclerView.Adapter<EpisodesRecyclerAdapter.EpisodesViewHolder>(){
    override fun onBindViewHolder(holder: EpisodesViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            //TODO: Missing feature to Second Activity
        }
        holder.episodeTitleTv.text = mContext.getString(R.string.episode_title, items[position].title)
        holder.episodeCodeTv.text = mContext.getString(R.string.episode_code, items[position].code)
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): EpisodesViewHolder {
        val rowView = LayoutInflater.from(mContext).inflate(R.layout.item_episodes, p0, false)
        return EpisodesViewHolder(rowView)
    }


    override fun getItemCount(): Int {
        return items.size
    }
    inner class EpisodesViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        var episodeTitleTv = view.item_episode_title
        var episodeCodeTv = view.item_episode_code

    }
}