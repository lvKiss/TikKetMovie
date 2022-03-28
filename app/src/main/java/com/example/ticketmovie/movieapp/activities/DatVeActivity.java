package com.example.ticketmovie.movieapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.DrawableWrapper;
import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.ChiTietChieu;
import com.example.lib.Model.ChiTietChoNgoi;
import com.example.lib.Model.PhimModel;
import com.example.lib.Model.Ve;
import com.example.lib.RetrofitClient;
import com.example.ticketmovie.R;
import com.example.ticketmovie.movieapp.adapter.ChiTietAdapter;
import com.example.ticketmovie.movieapp.adapter.ChiTietChoNgoiAdapter;
import com.example.ticketmovie.movieapp.adapter.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DatVeActivity extends AppCompatActivity {
    Methods methods;
    List<ChiTietChoNgoi> chiTietChoNgois = new ArrayList<ChiTietChoNgoi>();
    public static final String BASE_URL = "https://bookingmovie.azurewebsites.net";
    TextView soghe;
    GridView gridView;
    ChiTietChoNgoiAdapter chiTietChoNgoiAdapter = null;
    public String c;
    public Integer a= null;
    List<Ve> vedat= new ArrayList<Ve>();
    Button datve;
    Ve veghe= null;
    @Override
      protected void onStart() {
     super.onStart();
     setContentView(R.layout.activity_room);
        methods = RetrofitClient.getRetrofit(BASE_URL).create(Methods.class);
        //   listView = findViewById(R.id.listView);
        soghe = findViewById(R.id.cc);
        gridView =findViewById(R.id.Gridview);
        chiTietChoNgoiAdapter = new ChiTietChoNgoiAdapter(DatVeActivity.this,R.layout.item_choose_seat_square);
        ChiTietChieu chiTietChieu = (ChiTietChieu) getIntent().getSerializableExtra("aa");
        Call<List<ChiTietChoNgoi>> call = methods.getChiTietChoNgoi(chiTietChieu.getIdPhong());
        call.enqueue(new Callback<List<ChiTietChoNgoi>>() {
            @Override
            public void onResponse(Call<List<ChiTietChoNgoi>> call, Response<List<ChiTietChoNgoi>> response) {
                Toast.makeText(DatVeActivity.this,"succes",Toast.LENGTH_SHORT);
                chiTietChoNgois = response.body();
                chiTietChoNgoiAdapter.addAll(response.body());
            }
            @Override
            public void onFailure(Call<List<ChiTietChoNgoi>> call, Throwable t) {
            }
        });
        chiTietChoNgoiAdapter.addAll(chiTietChoNgois);
        gridView.setAdapter(chiTietChoNgoiAdapter);
        soghe.length();
//        Call<List<Ve>> cllll= methods.getVeChiTietChieu(chiTietChieu.getIdChiTietChieu());
//        cllll.enqueue(new Callback<List<Ve>>() {
//            @Override
//            public void onResponse(Call<List<Ve>> call, Response<List<Ve>> response) {
//                vedat= response.body();
//            }
//
//            @Override
//            public void onFailure(Call<List<Ve>> call, Throwable t) {
//
//            }
//        });
 //       try{
 //           for(Ve s : vedat){
//                for(int j=0;j<= chiTietChoNgois.size();j++){
//                    if(s.getIdChoNgoi().equals(chiTietChoNgois.get(j).getIdChoNgoi())){
//                        gridView.getChildAt(j).setBackgroundColor(Color.RED);
//                    }
//                }
//            }
 //       }
//        catch (Exception e){
//            e.printStackTrace();
//        }
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Toast.makeText(ListMovieActivity.this, "vi tri "+i, Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(ListMovieActivity.this,MovieDetailActivity.class);
                Intent intent = new Intent(DatVeActivity.this,MovieDetailActivity.class);
                intent.putExtra("chitietchongoi", chiTietChoNgois.get(i));
                datve = findViewById(R.id.buttondatve);
                c =chiTietChoNgois.get(i).getIdGheNavigation().getTenGhe().toString();
                a= chiTietChoNgois.get(i).getIdChoNgoi();
                try {
                    Call<Ve> ccccc = methods.getvechoNgoi(a, chiTietChieu.getIdChiTietChieu());
                    ccccc.enqueue(new Callback<Ve>() {
                        @Override
                        public void onResponse(Call<Ve> call, Response<Ve> response) {
                            veghe=response.body();
                            if (veghe != null) {
                                try{
                                        if(veghe.getIdChoNgoi()== a){
                                            c=null;
                                            a=null;
                                            gridView.getChildAt(i).setBackgroundColor(Color.RED);
                                        }
                                }catch(Exception e){
                                    e.printStackTrace();
                                }
                                Toast.makeText(DatVeActivity.this, "Ghế đã được đặt", Toast.LENGTH_SHORT).show();

                            }else {
                                gridView.getChildAt(i).setBackgroundColor(Color.CYAN);
                            }
                        }
                        @Override
                        public void onFailure(Call<Ve> call, Throwable t) {
                        }
                    });
                } catch (Exception e){
                    e.printStackTrace();
                }
                try{
                    for (int k=0;k<=chiTietChoNgois.size();k++){
                        if(i==k && veghe==null){
                        }else{
                           gridView.getChildAt(k).setBackgroundResource(R.drawable.background_item_choose_seat);
                        }
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                soghe.setText(c);
            }
        });
     }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
    }
    public void check(){
        ChiTietChieu chiTietChieu = (ChiTietChieu) getIntent().getSerializableExtra("aa");
        if(a==null){
        } else {
            Ve s = new Ve(SignInActivity.user.getIdUser(),a,chiTietChieu.getIdChiTietChieu());
            methods.postVe(s).enqueue(new Callback<Integer>() {
                @Override
                public void onResponse(Call<Integer> call, Response<Integer> response) {
                    finish();
                    startActivity(getIntent());
                }

                @Override
                public void onFailure(Call<Integer> call, Throwable t) {
                    Toast.makeText(DatVeActivity.this, "Đặt vé thành công", Toast.LENGTH_SHORT).show();
                }
            });
            Intent intent = new Intent(DatVeActivity.this,HomeActivity.class);
            startActivity(intent);
        }
    }
    public void addVe(View view) {
        ChiTietChieu chiTietChieu = (ChiTietChieu) getIntent().getSerializableExtra("aa");
        try {
            Call<Ve> ccccc = methods.getvechoNgoi(a, chiTietChieu.getIdChiTietChieu());
            ccccc.enqueue(new Callback<Ve>() {
                @Override
                public void onResponse(Call<Ve> call, Response<Ve> response) {
                    veghe=response.body();
                    if (veghe != null) {
                        try{
                            if(veghe.getIdChoNgoi()== a){
                                c=null;
                                a=null;
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        Toast.makeText(DatVeActivity.this, "Ghế vừa được đặt, hãy chọn ghế khác", Toast.LENGTH_SHORT).show();
                    }
                    check();
                }
                @Override
                public void onFailure(Call<Ve> call, Throwable t) {
                    Toast.makeText(DatVeActivity.this, "vui lòng chọn ghế", Toast.LENGTH_SHORT).show();
                   // check();
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
