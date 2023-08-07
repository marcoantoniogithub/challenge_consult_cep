package com.example.challenge_consult_cep.feature.search_cep.domain.model;

public class Cep {

    private String code;
    private String state;
    private String city;
    private String neighborhood;
    private String address;

    public Cep(String code, String state, String city, String neighborhood, String address) {
        this.code = code;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
