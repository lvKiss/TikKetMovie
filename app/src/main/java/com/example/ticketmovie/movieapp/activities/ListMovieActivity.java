package com.example.ticketmovie.movieapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.PhimModel;
import com.example.lib.Model.Item;
import com.example.lib.RetrofitClient;
import com.example.ticketmovie.R;
import com.example.ticketmovie.movieapp.adapter.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMovieActivity extends Fragment {
    Methods methods;
    private Methods cMethods;
    List<PhimModel> phimModelList = new ArrayList<PhimModel>();
    ListView listView;
    ItemAdapter itemsAdapter = null;
    public static final String BASE_URL = "https://bookingmovieticket.azurewebsites.net";
    View mview;
    HomeActivity mainActivity;
    @Override
    public View onCreateView  (LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainActivity = (HomeActivity) getActivity();
        super.onCreate(savedInstanceState);
        mview= inflater.inflate(R.layout.movie_home_fragment, container, false);
        methods = RetrofitClient.getRetrofit(BASE_URL).create(Methods.class);
        listView = mview.findViewById(R.id.listView);
        itemsAdapter = new ItemAdapter(mainActivity, R.layout.item_movie);
        Call<List<PhimModel>> call = methods.getPhim();
        call.enqueue(new Callback<List<PhimModel>>() {
            @Override
            public void onResponse(Call<List<PhimModel>> call, Response<List<PhimModel>> response) {
//                Toast.makeText(ListMovieActivity.this,"succes",Toast.LENGTH_SHORT);
                phimModelList= response.body();
                itemsAdapter.addAll(response.body());
                //Log.d("sss",phimModelList.get(0).getTenPhim());
            }

            @Override
            public void onFailure(Call<List<PhimModel>> call, Throwable t) {
//                Toast.makeText(ListMovieActivity.this,"fail",Toast.LENGTH_SHORT);

            }
        });
        itemsAdapter.addAll(phimModelList);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Toast.makeText(ListMovieActivity.this, "vi tri "+i, Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(ListMovieActivity.this,MovieDetailActivity.class);
                Intent intent = new Intent(mainActivity,MovieDetailActivity.class);
                intent.putExtra("phimModel", phimModelList.get(i));
                startActivity(intent);
            }
        });
        return mview;
    }
    @Override
    public void onStart() {
        super.onStart();

    }

}