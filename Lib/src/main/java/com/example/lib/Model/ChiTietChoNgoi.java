package com.example.lib.Model;
import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ChiTietChoNgoi implements Serializable {
    @SerializedName("idChoNgoi")
    @Expose
    private Integer idChoNgoi;
    @SerializedName("idPhong")
    @Expose
    private Integer idPhong;
    @SerializedName("idGhe")
    @Expose
    private Integer idGhe;
    @SerializedName("idGheNavigation")
    @Expose
    private Ghe idGheNavigation;
    @SerializedName("ves")
    @Expose
    private List<Ve> ves = null;

    public Integer getIdChoNgoi() {
        return idChoNgoi;
    }

    public void setIdChoNgoi(Integer idChoNgoi) {
        this.idChoNgoi = idChoNgoi;
    }

    public Integer getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(Integer idPhong) {
        this.idPhong = idPhong;
    }

    public Integer getIdGhe() {
        return idGhe;
    }

    public void setIdGhe(Integer idGhe) {
        this.idGhe = idGhe;
    }

    public Ghe getIdGheNavigation() {
        return idGheNavigation;
    }

    public void setIdGheNavigation(Ghe idGheNavigation) {
        this.idGheNavigation = idGheNavigation;
    }

    public List<Ve> getVes() {
        return ves;
    }

    public void setVes(List<Ve> ves) {
        this.ves = ves;
    }

}
