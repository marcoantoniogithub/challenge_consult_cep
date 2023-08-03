package com.example.challenge_consult_cep.feature.search_cep.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cep")
data class CepEntity(
    @PrimaryKey val code: String,
    val state: String,
    val city: String,
    val neighborhood: String,
    val address: String,
)
