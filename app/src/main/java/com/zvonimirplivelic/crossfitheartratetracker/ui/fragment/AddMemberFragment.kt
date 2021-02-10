package com.zvonimirplivelic.crossfitheartratetracker.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.zvonimirplivelic.crossfitheartratetracker.R
import com.zvonimirplivelic.crossfitheartratetracker.databinding.FragmentAddMemberBinding
import com.zvonimirplivelic.crossfitheartratetracker.db.GymDatabase
import com.zvonimirplivelic.crossfitheartratetracker.ui.MainActivity
import com.zvonimirplivelic.crossfitheartratetracker.ui.viewmodel.GymTrackerViewModel

class AddMemberFragment : Fragment() {

    lateinit var viewModel: GymTrackerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAddMemberBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add_member, container, false
        )
        viewModel = ((activity) as MainActivity).viewModel

        binding.lifecycleOwner = this
        binding.gymTrackerViewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_add_member).setOnClickListener {
            findNavController().navigate(R.id.actionAddMemberToMemberList)
        }
    }
}