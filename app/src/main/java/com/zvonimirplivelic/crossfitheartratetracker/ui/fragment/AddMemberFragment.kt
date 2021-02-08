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
import com.zvonimirplivelic.crossfitheartratetracker.ui.viewmodel.AddMemberViewModel
import com.zvonimirplivelic.crossfitheartratetracker.ui.viewmodel.factory.AddMemberViewModelFactory

class AddMemberFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAddMemberBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add_member, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = GymDatabase.getInstance(application).gymMemberDao
        val viewModelFactory = AddMemberViewModelFactory(dataSource, application)
        val addMemberViewModel = ViewModelProvider(this, viewModelFactory)
            .get(AddMemberViewModel::class.java)

        binding.lifecycleOwner = this
        binding.addMemberViewModel = addMemberViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_add_member).setOnClickListener {
            findNavController().navigate(R.id.actionAddMemberToMemberList)
        }
    }
}