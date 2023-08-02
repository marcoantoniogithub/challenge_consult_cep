package com.example.challenge_consult_cep.feature.search_cep.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApiCepDTO(
    @SerializedName("status") val status: String,
    @SerializedName("code") val code: String,
    @SerializedName("state") val state: String,
    @SerializedName("city") val city: String,
    @SerializedName("district") val district: String,
    @SerializedName("address") val address: String,
) : Parcelable
