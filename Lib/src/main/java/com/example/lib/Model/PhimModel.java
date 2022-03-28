package com.example.lib.Model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhimModel implements Serializable {

    @SerializedName("idPhim")
    @Expose
    private Integer idPhim;
    @SerializedName("idTheLoai")
    @Expose
    private Integer idTheLoai;
    @SerializedName("tenPhim")
    @Expose
    private String tenPhim;
    @SerializedName("thoiLuong")
    @Expose
    private String thoiLuong;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("trailer")
    @Expose
    private String trailer;
    @SerializedName("idTheLoaiNavigation")
    @Expose
    private Theloai idTheLoaiNavigation;
    @SerializedName("chiTietChieus")
    @Expose
    private List<ChiTietChieu> chiTietChieus = null;

    public Integer getIdPhim() {
        return idPhim;
    }

    public void setIdPhim(Integer idPhim) {
        this.idPhim = idPhim;
    }

    public Integer getIdTheLoai() {
        return idTheLoai;
    }

    public void setIdTheLoai(Integer idTheLoai) {
        this.idTheLoai = idTheLoai;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(String thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Theloai getIdTheLoaiNavigation() {
        return idTheLoaiNavigation;
    }

    public void setIdTheLoaiNavigation(Theloai idTheLoaiNavigation) {
        this.idTheLoaiNavigation = idTheLoaiNavigation;
    }

    public List<ChiTietChieu> getChiTietChieus() {
        return chiTietChieus;
    }

    public void setChiTietChieus(List<ChiTietChieu> chiTietChieus) {
        this.chiTietChieus = chiTietChieus;
    }

}