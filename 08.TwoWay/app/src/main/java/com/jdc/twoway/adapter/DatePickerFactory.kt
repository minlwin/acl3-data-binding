package com.jdc.twoway.adapter

import android.app.DatePickerDialog
import android.text.InputType
import android.widget.EditText
import java.util.*

object DatePickerFactory {

    @JvmStatic
    fun generate(editText:EditText) {

        editText.inputType = InputType.TYPE_NULL

        val defaultDate = Calendar.getInstance()

        val changeListener =
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, monthOfYear)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                editText.setText(DateAdapter.dateFormat.format(calendar.time))
            }

        val dialog = DatePickerDialog(editText.context, changeListener,
            defaultDate.get(Calendar.YEAR),
            defaultDate.get(Calendar.MONTH),
            defaultDate.get(Calendar.DAY_OF_MONTH))

        editText.setOnClickListener {
            dialog.show()
        }
    }

}