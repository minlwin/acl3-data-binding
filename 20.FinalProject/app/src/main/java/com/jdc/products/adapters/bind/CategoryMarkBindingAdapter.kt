package com.jdc.products.adapters.bind

import android.widget.TextView
import androidx.core.graphics.drawable.DrawableCompat
import androidx.databinding.BindingAdapter
import com.jdc.products.model.db.entity.Category
import com.jdc.products.utils.resourceColor

object CategoryMarkBindingAdapter {

    @JvmStatic
    @BindingAdapter("app:categoryValue")
    fun setCategory(textView: TextView, category: Category) {
        textView.text = category.title
        textView.setTextColor(resourceColor(category.color) { "text" })
        DrawableCompat.setTint(textView.background, resourceColor(category.color) { "color" })
    }
}