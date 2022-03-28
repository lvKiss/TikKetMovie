package com.example.lib.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Phong implements Serializable {
    @SerializedName("idPhong")
    @Expose
    private Integer idPhong;
    @SerializedName("tenPhong")
    @Expose
    private String tenPhong;
    @SerializedName("soGheToiDa")
    @Expose
    private Integer soGheToiDa;
    @SerializedName("chiTietChieus")
    @Expose
    private List<ChiTietChieu> chiTietChieus = null;

    public Integer getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(Integer idPhong) {
        this.idPhong = idPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public Integer getSoGheToiDa() {
        return soGheToiDa;
    }

    public void setSoGheToiDa(Integer soGheToiDa) {
        this.soGheToiDa = soGheToiDa;
    }

    public List<ChiTietChieu> getChiTietChieus() {
        return chiTietChieus;
    }

    public void setChiTietChieus(List<ChiTietChieu> chiTietChieus) {
        this.chiTietChieus = chiTietChieus;
    }
}
