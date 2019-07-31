package com.jmdelafuente.citiboxdemo.adapters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jmdelafuente.citiboxdemo.R
import com.jmdelafuente.citiboxdemo.models.ActivityModels
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_episode_detail.view.*


class EpisodeDetailAdapter(private val context: Context, private var items : List<ActivityModels.EpisodeDetailActivityModel>) :
    RecyclerView.Adapter<EpisodeDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_episode_detail, p0, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, p1: Int) {
        viewHolder.characterNameTv?.text = items[p1].name
        viewHolder.characterTypeTv?.text = items[p1].type
        viewHolder.characterStatusTv?.text = items[p1].status
        Picasso.with(context)
            .load(items[p1].image)
            .placeholder(R.drawable.ic_default_placeholder)
            .error(R.drawable.ic_default_placeholder)
            .fit()
            .into(viewHolder.characterIv);
    }

    fun setData(characters: List<ActivityModels.EpisodeDetailActivityModel>) {
        this.items = characters
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        val characterNameTv = view.item_episode_detail_name_tv
        val characterTypeTv = view.item_episode_detail_type_tv
        val characterStatusTv = view.item_episode_detail_status_tv
        val characterIv = view.item_episode_detail_iv

    }



}



