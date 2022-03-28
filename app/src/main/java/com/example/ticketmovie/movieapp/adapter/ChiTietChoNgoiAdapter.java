package com.example.ticketmovie.movieapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lib.Model.ChiTietChieu;
import com.example.lib.Model.ChiTietChoNgoi;
import com.example.ticketmovie.R;

import java.util.ArrayList;

public class ChiTietChoNgoiAdapter extends ArrayAdapter<ChiTietChoNgoi> {
    Activity activity;
    int resource;
    public ChiTietChoNgoiAdapter(@NonNull Context context, int resource){
        super(context, resource);
        this.activity= (Activity) context;
        this.resource= resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.activity.getLayoutInflater();
        View spView = layoutInflater.inflate(this.resource, null);
        TextView textView = spView.findViewById(R.id.item);
        ChiTietChoNgoi chiTietChoNgoi = getItem(position);
        textView.setText(chiTietChoNgoi.getIdGheNavigation().getTenGhe().toString());
        return spView;
    }
}
