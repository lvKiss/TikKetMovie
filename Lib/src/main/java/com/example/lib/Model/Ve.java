package com.example.lib.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Ve implements Serializable {

    @SerializedName("idVe")
    @Expose
    private Integer idVe;

    @SerializedName("idUser")
    @Expose
    private Integer idUser;
    @SerializedName("idChiTietChieu")
    @Expose
    private Integer idChiTietChieu;
    @SerializedName("idChoNgoi")
    @Expose
    private Integer idChoNgoi;
    @SerializedName("idChoNgoiNavigation")
    @Expose
    private ChiTietChoNgoi idChoNgoiNavigation;
    @SerializedName("idChiTietChieuNavigation")
    @Expose
    private ChiTietChieu idChiTietChieuNavigation;
    @SerializedName("idUserNavigation")
    @Expose
    private User idUserNavigation;

    public Ve(Integer idUser, Integer idChoNgoi, Integer idChiTietChieu) {
        this.idUser = idUser;
        this.idChiTietChieu = idChiTietChieu;
        this.idChoNgoi = idChoNgoi;
    }
    public Integer getIdVe() {
        return idVe;
    }

    public void setMaVe(Integer idVe) {
        this.idVe = idVe;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdChiTietChieu() {
        return idChiTietChieu;
    }

    public void setIdChiTietChieu(Integer idChiTietChieu) {
        this.idChiTietChieu = idChiTietChieu;
    }

    public Integer getIdChoNgoi() {
        return idChoNgoi;
    }

    public void setIdChoNgoi(Integer idChoNgoi) {
        this.idChoNgoi = idChoNgoi;
    }

    public ChiTietChieu getIdChiTietChieuNavigation() {
        return idChiTietChieuNavigation;
    }

    public void setIdChiTietChieuNavigation(ChiTietChieu idChiTietChieuNavigation) {
        this.idChiTietChieuNavigation = idChiTietChieuNavigation;
    }
    public ChiTietChoNgoi getIdChoNgoiNavigation() {
        return idChoNgoiNavigation;
    }

    public void setIdChoNgoiNavigation(ChiTietChoNgoi idChoNgoiNavigation) {
        this.idChoNgoiNavigation = idChoNgoiNavigation;
    }
    public User getIdUserNavigation() {
        return idUserNavigation;
    }

    public void setIdUserNavigation(User idUserNavigation) {
        this.idUserNavigation = idUserNavigation;
    }

}