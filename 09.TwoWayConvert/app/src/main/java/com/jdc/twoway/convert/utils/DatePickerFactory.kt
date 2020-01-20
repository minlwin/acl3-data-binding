package com.jdc.twoway.convert.utils

import android.app.DatePickerDialog
import android.text.InputType
import android.widget.EditText
import java.util.*

object DatePickerFactory {

    fun generate(editText: EditText) {

        editText.inputType = InputType.TYPE_NULL

        val listener =
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                editText.setText(DateFormat.format.format(calendar.time))
            }

        val calendar = Calendar.getInstance()
        val dialog = DatePickerDialog(editText.context, listener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH))

        editText.setOnClickListener {
            dialog.show()
        }

    }
}