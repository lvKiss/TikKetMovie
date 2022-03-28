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

import com.example.lib.Model.PhimModel;
import com.example.ticketmovie.R;
import com.squareup.picasso.Picasso;

public class ItemAdapter extends ArrayAdapter<PhimModel> {
    Activity activity;
    int resource;
    public ItemAdapter(@NonNull Context context,int resource){
        super(context, resource);
        this.activity= (Activity) context;
        this.resource= resource;
    }
    @NonNull
    @Override
    public View  getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.activity.getLayoutInflater();
        View spView = layoutInflater.inflate(this.resource, null);
        ImageView imgposter = spView.findViewById(R.id.imgPoster );
        TextView txtTitle = spView.findViewById(R.id.txtTitle);
        PhimModel phimModel = getItem(position);
            Picasso.get().load(phimModel.getImage()).into(imgposter);
        txtTitle.setText(phimModel.getTenPhim());
        return spView;
    }
}
