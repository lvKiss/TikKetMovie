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

import com.example.lib.Model.ChiTietChieu;
import com.example.lib.Model.PhimModel;
import com.example.ticketmovie.R;
import com.squareup.picasso.Picasso;

public class ChiTietAdapter extends ArrayAdapter<ChiTietChieu> {
    Activity activity;
    int resource;
    public ChiTietAdapter(@NonNull Context context, int resource){
        super(context, resource);
        this.activity= (Activity) context;
        this.resource= resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.activity.getLayoutInflater();
        View spView = layoutInflater.inflate(this.resource, null);
//        ImageView imgposter = spView.findViewById(R.id.imgPoster );
//        TextView txtTitle = spView.findViewById(R.id.txtTitle);
//        PhimModel phimModel = getItem(position);
//        Picasso.get().load(phimModel.getImage()).into(imgposter);
//        txtTitle.setText(phimModel.getTenPhim());

        TextView txtMaphong = spView.findViewById(R.id.txtMaphong);
        TextView txtThoigian = spView.findViewById(R.id.txtThoigian);
        TextView txtngay = spView.findViewById(R.id.txtngay);
        TextView txtgia = spView.findViewById(R.id.txtgia);
        ChiTietChieu chiTietChieu = getItem(position);
        txtMaphong.setText(chiTietChieu.getIdPhongNavigation().getTenPhong().toString());
        String thoigian = chiTietChieu.getGioBatDau().toString();
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
        String ngay = chiTietChieu.getNgayChieu().toString();
        try {
            ngay = ngay.split("T")[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtngay.setText(ngay);
        txtgia.setText(chiTietChieu.getGiaVe().toString()+" VNĐ");

        return spView;
    }
}
