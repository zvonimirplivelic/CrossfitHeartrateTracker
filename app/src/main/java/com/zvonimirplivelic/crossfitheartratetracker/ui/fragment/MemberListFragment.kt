package com.zvonimirplivelic.crossfitheartratetracker.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.zvonimirplivelic.crossfitheartratetracker.R
import com.zvonimirplivelic.crossfitheartratetracker.databinding.FragmentMemberListBinding
import com.zvonimirplivelic.crossfitheartratetracker.db.entites.GymMember
import com.zvonimirplivelic.crossfitheartratetracker.ui.adapter.GymMemberListAdapter
import com.zvonimirplivelic.crossfitheartratetracker.ui.viewmodel.GymTrackerViewModel

class MemberListFragment : Fragment() {

    lateinit var viewModel: GymTrackerViewModel
    lateinit var adapter: GymMemberListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentMemberListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_member_list, container, false
        )



        adapter = GymMemberListAdapter(viewModel.data.getAllMembers())
        binding.lifecycleOwner = this
        binding.rvMemberList.adapter = adapter
        binding.gymTrackerViewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<FloatingActionButton>(R.id.fab_add_member).setOnClickListener {
            findNavController().navigate(R.id.actionMemberListToAddMember)
        }
    }

}