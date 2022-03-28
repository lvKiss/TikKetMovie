package com.example.lib.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Serializable {

    @SerializedName("idUser")
    @Expose
    private Integer idUser;
    @SerializedName("hoTen")
    @Expose
    private String hoTen;
    @SerializedName("diaChi")
    @Expose
    private String diaChi;
    @SerializedName("sdt")
    @Expose
    private String sdt;
    @SerializedName("taiKhoan")
    @Expose
    private String taiKhoan;

    public User(String hoTen, String diaChi, String sdt, String taiKhoan, String matKhau) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    @SerializedName("matKhau")
    @Expose
    private String matKhau;
    @SerializedName("ves")
    @Expose
    private List<Ve> ves = null;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public List<Ve> getVes() {
        return ves;
    }

    public void setVes(List<Ve> ves) {
        this.ves = ves;
    }

}
