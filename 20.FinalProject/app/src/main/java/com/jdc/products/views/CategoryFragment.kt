package com.jdc.products.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jdc.products.R
import com.jdc.products.components.adapter.CategoryAdapter
import com.jdc.products.model.db.ProductDatabase
import com.jdc.products.model.service.CategoryService
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        recycler.layoutManager = LinearLayoutManager(this.context)
        val adapter = CategoryAdapter()
        recycler.adapter = adapter

        val service = CategoryService.getInstance(requireContext())

        val list = service.findAll()
        list.observe(this, Observer {
            adapter.submitList(it)
        })
    }
}
