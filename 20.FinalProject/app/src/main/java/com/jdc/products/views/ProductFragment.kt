package com.jdc.products.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.jdc.products.R
import com.jdc.products.adapters.list.ProductAdapter
import com.jdc.products.model.service.ProductService
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.coroutines.runBlocking

class ProductFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val category = arguments?.getString("category")
        val service = ProductService.getInstance(requireContext())

        val adapter = ProductAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())

        runBlocking {

            val list = if(null == category) {
                service.search()
            } else {
                service.search(category)
            }

            list.observe(this@ProductFragment, Observer {
                adapter.submitList(it)
            })
        }

    }

}
