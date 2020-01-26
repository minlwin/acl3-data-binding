package com.jdc.share.views


import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController

import com.jdc.share.R
import com.jdc.share.component.datePicker
import com.jdc.share.databinding.FragmentEditBinding
import com.jdc.share.model.StudentModel
import kotlinx.android.synthetic.main.fragment_edit.*

class EditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View? = inflater.inflate(R.layout.fragment_edit, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val viewModel by activityViewModels<StudentModel> ()
        val binding = FragmentEditBinding.bind(view)
        binding.lifecycleOwner = this
        binding.model = viewModel

        val adapter = ArrayAdapter<String>(view.context, android.R.layout.simple_spinner_dropdown_item, viewModel.subjects)
        selectInput.setAdapter(adapter)

        datePicker(view.context) {
            dateInput
        }

        button2.setOnClickListener {
            it.findNavController().popBackStack()
        }
    }
}
