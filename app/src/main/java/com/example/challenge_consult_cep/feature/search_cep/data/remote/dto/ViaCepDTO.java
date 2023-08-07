package com.example.challenge_consult_cep.feature.search_cep.data.remote.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ViaCepDTO implements Parcelable {

    @SerializedName("cep")
    private String cep;

    @SerializedName("logradouro")
    private String logradouro;

    @SerializedName("complemento")
    private String complemento;

    @SerializedName("bairro")
    private String bairro;

    @SerializedName("localidade")
    private String localidade;

    @SerializedName("uf")
    private String uf;

    @SerializedName("ibge")
    private String ibge;

    @SerializedName("gia")
    private String gia;

    @SerializedName("ddd")
    private String ddd;

    @SerializedName("siafi")
    private String siafi;

    public ViaCepDTO(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, String ibge, String gia, String ddd, String siafi) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
    }

    protected ViaCepDTO(Parcel in) {
        cep = in.readString();
        logradouro = in.readString();
        complemento = in.readString();
        bairro = in.readString();
        localidade = in.readString();
        uf = in.readString();
        ibge = in.readString();
        gia = in.readString();
        ddd = in.readString();
        siafi = in.readString();
    }

    public static final Creator<ViaCepDTO> CREATOR = new Creator<ViaCepDTO>() {
        @Override
        public ViaCepDTO createFromParcel(Parcel in) {
            return new ViaCepDTO(in);
        }

        @Override
        public ViaCepDTO[] newArray(int size) {
            return new ViaCepDTO[size];
        }
    };

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getIbge() {
        return ibge;
    }

    public String getGia() {
        return gia;
    }

    public String getDdd() {
        return ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cep);
        dest.writeString(logradouro);
        dest.writeString(complemento);
        dest.writeString(bairro);
        dest.writeString(localidade);
        dest.writeString(uf);
        dest.writeString(ibge);
        dest.writeString(gia);
        dest.writeString(ddd);
        dest.writeString(siafi);
    }
}
