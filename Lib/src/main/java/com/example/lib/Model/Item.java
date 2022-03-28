package com.example.lib.Model;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable {
    private List<PhimModel> phimModelList;
    private String message;
    public List<PhimModel> getPhimModel (){return phimModelList;}
    public void setPhimModelList(List<PhimModel> phimModelList){this.phimModelList = phimModelList;}
    public String getMessage(){return message;}
    public void setMessage(String message){this.message=message;}

    @Override
    public String toString() {
        return "Item{" +
                "phimModelList=" + phimModelList +
                ", message='" + message + '\'' +
                '}';
    }
}
