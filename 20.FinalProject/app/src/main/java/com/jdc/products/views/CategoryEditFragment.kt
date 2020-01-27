package com.jdc.products.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController

import com.jdc.products.R
import com.jdc.products.databinding.FragmentCategoryEditBinding
import com.jdc.products.model.view.CategoryEditViewModel
import kotlinx.android.synthetic.main.fragment_category_edit.*

/**
 * A simple [Fragment] subclass.
 */
class CategoryEditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val model by viewModels<CategoryEditViewModel>()

        val binding = FragmentCategoryEditBinding.bind(view)
        binding.lifecycleOwner = this
        binding.model = model

        button.setOnClickListener {
            model.save()
            it.findNavController().navigate(R.id.action_save_category)
        }
    }

}
