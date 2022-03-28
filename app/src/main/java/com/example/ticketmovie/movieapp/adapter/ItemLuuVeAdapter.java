package com.example.ticketmovie.movieapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.ChiTietChieu;
import com.example.lib.Model.PhimModel;
import com.example.lib.Model.Phong;
import com.example.lib.Model.Ve;
import com.example.lib.RetrofitClient;
import com.example.ticketmovie.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemLuuVeAdapter extends ArrayAdapter<Ve> {
    Activity activity;
    int resource;
    Methods methods;
    ChiTietChieu c;
    public static final String BASE_URL = "https://bookingmovie.azurewebsites.net";
    public ItemLuuVeAdapter(@NonNull Context context, int resource){
        super(context, resource);
        this.activity= (Activity) context;
        this.resource= resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        methods = RetrofitClient.getRetrofit(BASE_URL).create(Methods.class);

        LayoutInflater layoutInflater = this.activity.getLayoutInflater();
        View spView = layoutInflater.inflate(this.resource, null);
        Ve ve = getItem(position);
        Call<ChiTietChieu> chiTietChieuCall= methods.getIdChitietchieu(ve.getIdChiTietChieu());
        chiTietChieuCall.enqueue(new Callback<ChiTietChieu>() {
            @Override
            public void onResponse(Call<ChiTietChieu> call, Response<ChiTietChieu> response) {
                c= response.body();
                TextView txtphong = spView.findViewById(R.id.txtphong);
                String s = ve.getIdVe().toString();
                txtphong.setText(c.getIdPhongNavigation().getTenPhong());
                TextView txttenphim = spView.findViewById(R.id.txttenphim);
                txttenphim.setText(c.getIdPhimNavigation().getTenPhim().toString());
            }

            @Override
            public void onFailure(Call<ChiTietChieu> call, Throwable t) {

            }
        });
        TextView txggia =spView.findViewById(R.id.txtgia);
        txggia.setText(ve.getIdChiTietChieuNavigation().getGiaVe().toString()+" VNĐ");
        TextView txtMave = spView.findViewById(R.id.txtMave);
        txtMave.setText(ve.getIdVe().toString());
        TextView txtThoigian = spView.findViewById(R.id.txtThoigian);
        String thoigian = ve.getIdChiTietChieuNavigation().getGioBatDau().toString();
        try {
            thoigian = thoigian.split("T")[1];
        } catch (Exception e) {
            e.printStackTrace();
        }
        String tg =null;
        try {
            tg = thoigian.substring(0,5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtThoigian.setText(tg);
        TextView txtngay = spView.findViewById(R.id.txtngay);
        String ngay = ve.getIdChiTietChieuNavigation().getNgayChieu().toString();
        try {
            ngay = ngay.split("T")[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtngay.setText(ngay);

        TextView txtghe = spView.findViewById(R.id.txtghe);
        txtghe.setText(ve.getIdChoNgoiNavigation().getIdGheNavigation().getTenGhe());
        return spView;
    }
}
