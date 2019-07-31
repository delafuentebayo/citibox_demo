package com.upring.contacts.ui.adapters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.upring.contacts.R
import com.upring.contacts.db.ContactRoom
import com.upring.contacts.interfaces.ClickListeners.OnItemInvitationContactClick
import com.upring.contacts.utils.fastscroll.FastScroller
import kotlinx.android.synthetic.main.item_contact_invitation.view.*


class ListContactsAcceptedAdapter(var items : ArrayList<ContactRoom>, val context: Context,
                                  private val listener: OnItemInvitationContactClick) : FastScroller.SectionIndexer,
        RecyclerView.Adapter<ListContactsAcceptedAdapter.ViewHolder>() {
    override fun getSectionText(position: Int): CharSequence {
        return items[position].nameSorted?.first().toString().toUpperCase()
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_contact_invitation, p0, false))
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.itemView.setOnClickListener{
            listener.onItemClicked(p1)
        }
        p0.contactNameTv?.text = items[p1].nameSorted

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(contacts: ArrayList<ContactRoom>) {
        items = contacts

        notifyDataSetChanged()
    }

    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        val contactNameTv = view.contact_name
        val contactActionIv = view.contact_action
        val contactSelectIv = view.contact_select

    }



}



