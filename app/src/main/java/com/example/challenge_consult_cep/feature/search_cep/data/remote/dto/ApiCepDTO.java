package com.example.challenge_consult_cep.feature.search_cep.data.remote.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class ApiCepDTO implements Parcelable {

    @SerializedName("status")
    private String status;

    @SerializedName("code")
    private String code;

    @SerializedName("state")
    private String state;

    @SerializedName("city")
    private String city;

    @SerializedName("district")
    private String district;

    @SerializedName("address")
    private String address;

    public ApiCepDTO(String status, String code, String state, String city, String district, String address) {
        this.status = status;
        this.code = code;
        this.state = state;
        this.city = city;
        this.district = district;
        this.address = address;
    }

    protected ApiCepDTO(Parcel in) {
        status = in.readString();
        code = in.readString();
        state = in.readString();
        city = in.readString();
        district = in.readString();
        address = in.readString();
    }

    public static final Creator<ApiCepDTO> CREATOR = new Creator<ApiCepDTO>() {
        @Override
        public ApiCepDTO createFromParcel(Parcel in) {
            return new ApiCepDTO(in);
        }

        @Override
        public ApiCepDTO[] newArray(int size) {
            return new ApiCepDTO[size];
        }
    };

    public String getStatus() {
        return status;
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

    public String getDistrict() {
        return district;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(code);
        dest.writeString(state);
        dest.writeString(city);
        dest.writeString(district);
        dest.writeString(address);
    }
}
