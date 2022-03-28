package com.example.lib;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static String Base_url ="https://bookingmovieticket.azurewebsites.net";
//  private static String Base_url ="https://movieticketbooking.azurewebsites.net";
    public static Retrofit getRetrofit(String base_url) {
        if(retrofit ==null){
            retrofit = new Retrofit.Builder().baseUrl(Base_url).addConverterFactory(GsonConverterFactory.create()).build();


        }
        return retrofit;
    }
}
