package com.zvonimirplivelic.crossfitheartratetracker.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.zvonimirplivelic.crossfitheartratetracker.R
import com.zvonimirplivelic.crossfitheartratetracker.databinding.FragmentMemberListBinding
import com.zvonimirplivelic.crossfitheartratetracker.db.GymDatabase
import com.zvonimirplivelic.crossfitheartratetracker.ui.fragment.viewmodel.MemberListViewModel
import com.zvonimirplivelic.crossfitheartratetracker.ui.fragment.viewmodel.factory.MemberListViewModelFactory

class MemberListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentMemberListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_member_list, container, false
        )
        val application = requireNotNull(this.activity).application
        val dataSource = GymDatabase.getInstance(application).gymMemberDao
        val viewModelFactory = MemberListViewModelFactory(dataSource, application)
        val gymMemberViewModel = ViewModelProvider(this, viewModelFactory)
            .get(MemberListViewModel::class.java)

        binding.lifecycleOwner = this
        binding.memberListViewModel = gymMemberViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<FloatingActionButton>(R.id.fab_add_member).setOnClickListener {
            findNavController().navigate(R.id.actionMemberListToAddMember)
        }
    }
}