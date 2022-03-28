package com.example.lib.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Ghe implements Serializable {
    @SerializedName("idGhe")
    @Expose
    private Integer idGhe;
    @SerializedName("tenGhe")
    @Expose
    private String tenGhe;
    @SerializedName("chiTietChoNgois")
    @Expose
    private List<ChiTietChoNgoi> chiTietChoNgois = null;

    public Integer getIdGhe() {
        return idGhe;
    }

    public void setIdGhe(Integer idGhe) {
        this.idGhe = idGhe;
    }

    public String getTenGhe() {
        return tenGhe;
    }

    public void setTenGhe(String tenGhe) {
        this.tenGhe = tenGhe;
    }

    public List<ChiTietChoNgoi> getChiTietChoNgois() {
        return chiTietChoNgois;
    }

    public void setChiTietChoNgois(List<ChiTietChoNgoi> chiTietChoNgois) {
        this.chiTietChoNgois = chiTietChoNgois;
    }

}
