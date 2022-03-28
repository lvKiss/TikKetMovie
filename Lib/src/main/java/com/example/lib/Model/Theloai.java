package com.example.lib.Model;


import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Theloai implements Serializable {

    @SerializedName("idTheLoai")
    @Expose
    private Integer idTheLoai;
    @SerializedName("tenTheLoai")
    @Expose
    private String tenTheLoai;
    @SerializedName("phims")
    @Expose
    private List<Object> phims = null;

    public Integer getIdTheLoai() {
        return idTheLoai;
    }

    public void setIdTheLoai(Integer idTheLoai) {
        this.idTheLoai = idTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public List<Object> getPhims() {
        return phims;
    }

    public void setPhims(List<Object> phims) {
        this.phims = phims;
    }
}