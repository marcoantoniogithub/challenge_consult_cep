package com.example.challenge_consult_cep.core.data_source.data_base;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.challenge_consult_cep.feature.search_cep.data.local.dao.CepDAO;
import com.example.challenge_consult_cep.feature.search_cep.data.local.entity.CepEntity;

@Database(entities = {CepEntity.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract CepDAO cepDao();
}