package com.example.challenge_consult_cep.feature.search_cep.data.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "cep")
public class CepEntity {

    @PrimaryKey
    @NonNull
    private String code;
    @ColumnInfo
    private String state;
    @ColumnInfo
    private String city;
    @ColumnInfo
    private String neighborhood;
    @ColumnInfo
    private String address;

    public CepEntity(String code, String state, String city, String neighborhood, String address) {
        this.code = code;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getAddress() {
        return address;
    }
}
