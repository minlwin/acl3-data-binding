package com.jdc.twoway.adapter

import android.app.DatePickerDialog
import android.text.InputType
import android.widget.EditText
import java.util.*

object DatePickerFactory {

    @JvmStatic
    fun generate(view:EditText) {

        view.inputType = InputType.TYPE_NULL

        val dialog = DatePickerDialog(view.context)

        dialog.datePicker.setOnDateChangedListener{
                _, year, month, day ->
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)

            view.setText(DateAdapter.dateFormat.format(calendar.time))
        }

        view.setOnClickListener {
            dialog.show()
        }
    }

}