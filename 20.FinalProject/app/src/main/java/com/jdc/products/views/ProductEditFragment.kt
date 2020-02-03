package com.jdc.products.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.jdc.products.R
import com.jdc.products.databinding.FragmentProductEditBinding
import com.jdc.products.model.service.CategoryService
import com.jdc.products.model.service.ProductService
import com.jdc.products.model.view.ProductEditViewModel
import kotlinx.android.synthetic.main.fragment_product_edit.*

class ProductEditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val binding = FragmentProductEditBinding.bind(view)
        binding.lifecycleOwner = this

        val model by viewModels<ProductEditViewModel>()
        binding.model = model

        val categories = CategoryService.getInstance(requireContext()).findAll()
        categories.observe(this, Observer {
            val names = it.map { c -> c.name }
            autoComplete.setAdapter(
                ArrayAdapter<String>(
                    requireContext(),
                    android.R.layout.simple_spinner_dropdown_item,
                    names
                )
            )
        })

        arguments?.getInt("id")?.also {

            val service = ProductService.getInstance(requireContext())

            service.findById(it).observe(this, Observer { data ->
                model.setData(data)
            })
        }
    }

}
