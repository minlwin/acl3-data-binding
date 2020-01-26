package com.jdc.share.component

import android.app.DatePickerDialog
import android.content.Context
import android.text.InputType
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.*

val dateFormat = SimpleDateFormat("yyyy/MM/dd")

fun datePicker(context: Context, editText: () -> EditText) = editText().let {

    it.inputType = InputType.TYPE_NULL

    val calendar = Calendar.getInstance()

    val dialog = DatePickerDialog(context,
        DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            it.setText(dateFormat.format(calendar.time))
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))

    it.setOnClickListener {

        if(editText().text.toString().isNotEmpty()) {
            calendar.time = dateFormat.parse(editText().text.toString())
            dialog.datePicker.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
        }

        dialog.show()
    }
}
