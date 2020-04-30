package com.ustapp.utils

import android.content.Context
import androidx.annotation.StringRes

class StringService(val context: Context) {

    fun getString(@StringRes name: Int): String {
        return context.getString(name)
    }
}