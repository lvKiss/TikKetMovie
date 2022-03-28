package com.example.ticketmovie.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.PhimModel;
import com.example.ticketmovie.R;
import static com.example.lib.RetrofitClient.getRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getPhim();
    }

//    private void getPhim() {
//        Methods methods = getRetrofit().create(Methods.class);
//        Call<PhimModel> call = methods.getPhim();
//        call.enqueue(new Callback<PhimModel>() {
//            @Override
//            public void onResponse(Call<PhimModel> call, Response<PhimModel> response) {
//                List<PhimModel.tenPhim>
//            }
//
//            @Override
//            public void onFailure(Call<PhimModel> call, Throwable t) {
//
//            }
//        });
//    }
}