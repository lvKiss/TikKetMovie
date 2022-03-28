package com.example.lib.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ChiTietChieu implements Serializable {
    @SerializedName("idChiTietChieu")
    @Expose
    private Integer idChiTietChieu;
    @SerializedName("idPhim")
    @Expose
    private Integer idPhim;
    @SerializedName("idPhong")
    @Expose
    private Integer idPhong;
    @SerializedName("ngayChieu")
    @Expose
    private String ngayChieu;

    public ChiTietChieu(Integer idChiTietChieu, Integer idPhim, Integer idPhong, String ngayChieu, String gioBatDau, Integer giaVe) {
        this.idChiTietChieu = idChiTietChieu;
        this.idPhim = idPhim;
        this.idPhong = idPhong;
        this.ngayChieu = ngayChieu;
        this.gioBatDau = gioBatDau;
        this.giaVe = giaVe;
    }

    @SerializedName("gioBatDau")
    @Expose
    private String gioBatDau;
    @SerializedName("giaVe")
    @Expose
    private Integer giaVe;
    @SerializedName("idPhimNavigation")
    @Expose
    private PhimModel idPhimNavigation;
    @SerializedName("idPhongNavigation")
    @Expose
    private Phong idPhongNavigation;
    @SerializedName("ves")
    @Expose
    private List<Ve> ves = null;

    public Integer getIdChiTietChieu() {
        return idChiTietChieu;
    }

    public void setIdChiTietChieu(Integer idChiTietChieu) {
        this.idChiTietChieu = idChiTietChieu;
    }

    public Integer getIdPhim() {
        return idPhim;
    }

    public void setIdPhim(Integer idPhim) {
        this.idPhim = idPhim;
    }

    public Integer getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(Integer idPhong) {
        this.idPhong = idPhong;
    }

    public String getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(String ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public String getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(String gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public Integer getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(Integer giaVe) {
        this.giaVe = giaVe;
    }

    public PhimModel getIdPhimNavigation() {
        return idPhimNavigation;
    }

    public void setIdPhimNavigation(PhimModel idPhimNavigation) {
        this.idPhimNavigation = idPhimNavigation;
    }

    public Phong getIdPhongNavigation() {
        return idPhongNavigation;
    }

    public void setIdPhongNavigation(Phong idPhongNavigation) {
        this.idPhongNavigation = idPhongNavigation;
    }

    public List<Ve> getVes() {
        return ves;
    }

    public void setVes(List<Ve> ves) {
        this.ves = ves;
    }
}
