package com.zvonimirplivelic.crossfitheartratetracker.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zvonimirplivelic.crossfitheartratetracker.R
import com.zvonimirplivelic.crossfitheartratetracker.databinding.MemberItemListBinding
import com.zvonimirplivelic.crossfitheartratetracker.db.entites.GymMember
import com.zvonimirplivelic.crossfitheartratetracker.util.GymMemberClickListener

class GymMemberListAdapter(var memberList: List<GymMember>) : RecyclerView.Adapter<GymMemberListAdapter.GymMemberViewHolder>(),
    GymMemberClickListener {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GymMemberViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<MemberItemListBinding>(
            inflater,
            R.layout.member_item_list,
            parent,
            false
        )
        return GymMemberViewHolder(view)
    }

    override fun getItemCount() = memberList.size

    override fun onBindViewHolder(holder: GymMemberViewHolder, position: Int) {
        holder.view.gymMember = memberList[position]
        holder.view.listener = this
    }


    override fun onMemberClicked(v: View) {

    }

    class GymMemberViewHolder(var view: MemberItemListBinding) : RecyclerView.ViewHolder(view.root)
}