package com.ustapp.network.dto

data class UserPersonalData(
    val firstName: String,
    val lastName: String,
    val avatarUrl: String,
    val fullAddress: String,
    val email: String
): BaseUserData