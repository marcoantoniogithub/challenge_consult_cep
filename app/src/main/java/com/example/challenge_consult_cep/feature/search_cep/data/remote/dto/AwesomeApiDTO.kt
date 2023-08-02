package com.example.challenge_consult_cep.feature.search_cep.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AwesomeApiDTO(
    @SerializedName("cep") val cep: String,
    @SerializedName("address_type") val addressType: String,
    @SerializedName("address_name") val addressName: String,
    @SerializedName("address") val address: String,
    @SerializedName("district") val district: String,
    @SerializedName("state") val state: String,
    @SerializedName("city") val city: String,
    @SerializedName("lat") val lat: String,
    @SerializedName("lng") val lng: String,
    @SerializedName("ddd") val ddd: String,
    @SerializedName("city_ibge") val cityIbge: String,
) : Parcelable
