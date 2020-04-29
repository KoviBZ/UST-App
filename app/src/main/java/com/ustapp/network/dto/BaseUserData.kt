package com.ustapp.network.dto

import com.google.gson.annotations.SerializedName

data class UserDataResponse(
    @SerializedName("photoUrl") val photoUrl: String?,
    @SerializedName("personalData") val personalData: LinkedHashMap<String, String>,
    @SerializedName("education") val educationData: LinkedHashMap<String, String>,
    @SerializedName("experience") val experienceData: LinkedHashMap<String, String>,
    @SerializedName("languages") val languageData: LinkedHashMap<String, String>,
    @SerializedName("skills") val skillData: ArrayList<String>
)