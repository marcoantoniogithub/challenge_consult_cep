package com.example.challenge_consult_cep.feature.search_cep.data.remote.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class AwesomeApiDTO implements Parcelable {

    @SerializedName("cep")
    private String cep;

    @SerializedName("address_type")
    private String addressType;

    @SerializedName("address_name")
    private String addressName;

    @SerializedName("address")
    private String address;

    @SerializedName("district")
    private String district;

    @SerializedName("state")
    private String state;

    @SerializedName("city")
    private String city;

    @SerializedName("lat")
    private String lat;

    @SerializedName("lng")
    private String lng;

    @SerializedName("ddd")
    private String ddd;

    @SerializedName("city_ibge")
    private String cityIbge;

    public AwesomeApiDTO(String cep, String addressType, String addressName, String address, String district, String state, String city, String lat, String lng, String ddd, String cityIbge) {
        this.cep = cep;
        this.addressType = addressType;
        this.addressName = addressName;
        this.address = address;
        this.district = district;
        this.state = state;
        this.city = city;
        this.lat = lat;
        this.lng = lng;
        this.ddd = ddd;
        this.cityIbge = cityIbge;
    }

    protected AwesomeApiDTO(Parcel in) {
        cep = in.readString();
        addressType = in.readString();
        addressName = in.readString();
        address = in.readString();
        district = in.readString();
        state = in.readString();
        city = in.readString();
        lat = in.readString();
        lng = in.readString();
        ddd = in.readString();
        cityIbge = in.readString();
    }

    public static final Creator<AwesomeApiDTO> CREATOR = new Creator<AwesomeApiDTO>() {
        @Override
        public AwesomeApiDTO createFromParcel(Parcel in) {
            return new AwesomeApiDTO(in);
        }

        @Override
        public AwesomeApiDTO[] newArray(int size) {
            return new AwesomeApiDTO[size];
        }
    };

    public String getCep() {
        return cep;
    }

    public String getAddressType() {
        return addressType;
    }

    public String getAddressName() {
        return addressName;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getDdd() {
        return ddd;
    }

    public String getCityIbge() {
        return cityIbge;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cep);
        dest.writeString(addressType);
        dest.writeString(addressName);
        dest.writeString(address);
        dest.writeString(district);
        dest.writeString(state);
        dest.writeString(city);
        dest.writeString(lat);
        dest.writeString(lng);
        dest.writeString(ddd);
        dest.writeString(cityIbge);
    }
}
