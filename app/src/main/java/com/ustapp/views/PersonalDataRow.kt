package com.ustapp.views

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import com.ustapp.R

class PersonalDataRow(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private val label: TextView by lazy { findViewById<TextView>(R.id.label) }
    private val valueField: TextView by lazy { findViewById<TextView>(R.id.value_field) }

    init {
        init(context, attrs)
    }

    fun init(context: Context, attrs: AttributeSet) {
        inflate(context, R.layout.view_personal_data_row, this)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.PersonalDataRow, 0, 0)

        val labelText = typedArray.getString(R.styleable.PersonalDataRow_label)
        label.text = labelText

        typedArray.recycle()
    }

    fun setValue(fieldValue: String) {
        valueField.text = fieldValue
    }
}