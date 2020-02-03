package com.jdc.products.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jdc.products.R
import com.jdc.products.databinding.FragmentCategoryEditBinding
import com.jdc.products.model.view.CategoryEditViewModel
import kotlinx.android.synthetic.main.fragment_category_edit.*

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

        arguments?.getString("name")?.also {
            model.load(it)
            val activity = requireActivity() as AppCompatActivity
            activity.supportActionBar?.title = "Edit Category"
            button.text = resources.getText(R.string.save_category)
        }

    }

}
