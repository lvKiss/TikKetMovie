package com.example.ticketmovie.movieapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.ChiTietChieu;
import com.example.lib.Model.Item;
import com.example.lib.Model.PhimModel;
import com.example.lib.Model.Theloai;
import com.example.lib.RetrofitClient;
import com.example.ticketmovie.R;
import com.example.ticketmovie.movieapp.adapter.ChiTietAdapter;
import com.example.ticketmovie.movieapp.adapter.ItemAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailActivity extends AppCompatActivity {

    private Methods cmethods;
    public static final String BASE_URL = "https://bookingmovie.azurewebsites.net";
    TextView txttenphim;
    TextView txttheloai;
    TextView txttime;
    ImageView imageposter;
    Theloai theloai ;
    ListView  listDetail;
    List<ChiTietChieu> chiTietChieus =new ArrayList<ChiTietChieu>();
    List<ChiTietChieu> chiTietChieusId= new ArrayList<ChiTietChieu>();
    ChiTietAdapter chiTietAdapter = null;
    public static String a;
    @Override
    protected void onStart(){
        super.onStart();
        setContentView(R.layout.book_ticket_movie);
        //ItemAdapter itemAdapter = null;
        PhimModel phimModel = (PhimModel) getIntent().getSerializableExtra("phimModel");
        a=  phimModel.getTrailer().toString();
        cmethods = RetrofitClient.getRetrofit(BASE_URL).create(Methods.class);
        txttenphim = (TextView) findViewById(R.id.txttenphim);
        txttenphim.setText(phimModel.getTenPhim());
        txttheloai = (TextView)findViewById(R.id.txttheloai);
        txttheloai.setText(phimModel.getIdTheLoaiNavigation().getTenTheLoai().toString());
        txttime = (TextView) findViewById(R.id.txttime);
        txttime.setText(phimModel.getThoiLuong());
        imageposter= (ImageView) findViewById(R.id.imageposter);
        Picasso.get().load(phimModel.getImage()).into(imageposter);
        listDetail = findViewById(R.id.listDetail);
        chiTietAdapter = new ChiTietAdapter(MovieDetailActivity.this, R.layout.item_xuatchieu);
        chiTietChieusId.removeAll(chiTietChieus);
        Call<List<ChiTietChieu>> call = cmethods.getChitietChieu();
        call.enqueue(new Callback<List<ChiTietChieu>>() {
            @Override
            public void onResponse(Call<List<ChiTietChieu>> call, Response<List<ChiTietChieu>> response) {
                Toast.makeText(MovieDetailActivity.this,"succes",Toast.LENGTH_SHORT);
                chiTietChieus= response.body();
                for(ChiTietChieu c : chiTietChieus) {
                    if (phimModel.getIdPhim().equals(c.getIdPhim())) {
                        chiTietChieusId.add(c);
                        chiTietAdapter.addAll(c);
                    }
                }
            }
            @Override
            public void onFailure(Call<List<ChiTietChieu>> call, Throwable t) {
                Toast.makeText(MovieDetailActivity.this,"fail",Toast.LENGTH_SHORT);
            }
        });
        chiTietAdapter.addAll(chiTietChieusId);
        listDetail.setAdapter(chiTietAdapter);
        listDetail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MovieDetailActivity.this,DatVeActivity.class);
                intent = new Intent(MovieDetailActivity.this,DatVeActivity.class);
                intent.putExtra("aa", chiTietChieusId.get(position));
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_ticket_movie);


    }
    public void btnxemtrailer(View view) {
        Intent intent = new Intent(MovieDetailActivity.this,TrailerMovieActivity.class);
        startActivity(intent);
    }

}