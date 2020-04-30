package com.ustapp.utils.service

import androidx.annotation.StringRes

interface StringService {
    fun getString(@StringRes name: Int): String
}