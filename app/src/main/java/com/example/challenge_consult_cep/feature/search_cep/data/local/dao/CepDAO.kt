package com.example.challenge_consult_cep.feature.search_cep.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.challenge_consult_cep.feature.search_cep.data.local.entity.CepEntity

@Dao
interface CepDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(cep: CepEntity)

    @Query("SELECT * FROM cep WHERE code = :cep")
    suspend fun findByCep(cep: String): CepEntity
}