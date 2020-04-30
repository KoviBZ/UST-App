package com.ustapp.utils.service

import android.content.Context
import androidx.annotation.StringRes

class DefaultStringService(private val context: Context): StringService {

    override fun getString(@StringRes name: Int): String {
        return context.getString(name)
    }
}