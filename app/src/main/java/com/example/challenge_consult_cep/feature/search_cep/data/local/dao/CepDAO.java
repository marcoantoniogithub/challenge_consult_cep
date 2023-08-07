package com.example.challenge_consult_cep.feature.search_cep.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.challenge_consult_cep.feature.search_cep.data.local.entity.CepEntity;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;


@Dao
public interface CepDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertItem(CepEntity... cep);

    @Query("SELECT * FROM cep WHERE code = :cep")
    Single<CepEntity> findByCep(String cep);
}