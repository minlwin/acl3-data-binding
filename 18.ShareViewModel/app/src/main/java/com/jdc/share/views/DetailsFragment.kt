package com.jdc.share.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController

import com.jdc.share.R
import com.jdc.share.databinding.FragmentDetailsBinding
import com.jdc.share.model.StudentModel
import kotlinx.android.synthetic.main.fragment_details.*


class DetailsFragment : Fragment() {

    private lateinit var binding:FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =  inflater.inflate(R.layout.fragment_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentDetailsBinding.bind(view)

        val model by activityViewModels<StudentModel>()
        binding.lifecycleOwner = this
        binding.model = model

        button.setOnClickListener {
            it.findNavController().navigate(R.id.action_details_to_edit)
        }
    }

}
