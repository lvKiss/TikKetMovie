package com.example.ticketmovie.movieapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.internal.view.SupportMenuItem;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.ChiTietChieu;
import com.example.lib.Model.PhimModel;
import com.example.lib.Model.Ve;
import com.example.lib.RetrofitClient;
import com.example.ticketmovie.R;
import com.example.ticketmovie.movieapp.adapter.ItemAdapter;
import com.example.ticketmovie.movieapp.adapter.ItemLuuVeAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.NullCipher;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListLuuVeActivity extends Fragment {
    Methods methods;
    List<Ve> ves = new ArrayList<Ve>();
    List<Ve> VeID= new ArrayList<Ve>();
    ListView listView = null;
    ItemLuuVeAdapter itemsAdapter = null;
    public static final String BASE_URL = "https://bookingmovieticket.azurewebsites.net";
    View mview;
    HomeActivity mainActivity;
    @Override
    public void onStart() {
        super.onStart();
        // PhimModel phimModel = (PhimModel) getIntent().getSerializableExtra("phimModel");
        methods = RetrofitClient.getRetrofit(BASE_URL).create(Methods.class);
        listView = mview.findViewById(R.id.listView);
        itemsAdapter = new ItemLuuVeAdapter(mainActivity, R.layout.activity_luu_ve);
        GetVe();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                alertDialog.setTitle("Thông báo");
                alertDialog.setIcon(R.drawable.notification_icon);
                alertDialog.setMessage("Bạn có muốn hủy vé này không?");
                Integer ve = VeID.get(position).getIdVe();
                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Call<Void> call = methods.delete(ve);
                        call.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                ves.clear();
                                itemsAdapter.clear();
                                //listView.setAdapter(null);
                                GetVe();
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {

                            }
                        });


                        Toast.makeText(getContext(),"Hủy vé thành công",Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }
        });

    }
    public void GetVe(){
        Call<List<Ve>> call = methods.GetVe();
        VeID.clear();
        call.enqueue(new Callback<List<Ve>>() {
            @Override
            public void onResponse(Call<List<Ve>> call, Response<List<Ve>> response) {
//                Toast.makeText(ListMovieActivity.this,"succes",Toast.LENGTH_SHORT);
                ves= response.body();
                //itemsAdapter.addAll(response.body());
                for(Ve c : ves) {
                    if (SignInActivity.user.getIdUser().equals(c.getIdUser())) {
                        VeID.add(c);
                        itemsAdapter.addAll(c);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Ve>> call, Throwable t) {
//                Toast.makeText(ListMovieActivity.this,"fail",Toast.LENGTH_SHORT);

            }
        });
        itemsAdapter.addAll(VeID);
        listView.setAdapter(itemsAdapter);
    }
//    private void XacNhanXoa(final int position){
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
//        alertDialog.setTitle("Thông báo");
//        alertDialog.setIcon(R.mipmap.ic_launcher);
//        alertDialog.setMessage("Bạn có muốn hủy vé này không?");
//
//        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                VeID.remove(position);
//                itemsAdapter.notifyDataSetChanged();
//            }
//        });
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (HomeActivity) getActivity();
        mview= inflater.inflate(R.layout.list_veluu, container, false);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                // Toast.makeText(ListMovieActivity.this, "vi tri "+i, Toast.LENGTH_SHORT).show();
////                Intent intent = new Intent(ListMovieActivity.this,MovieDetailActivity.class);
//                Intent intent = new Intent(mainActivity,ListLuuVeActivity.class);
//                intent.putExtra("phimModel", ves.get(i));
//                startActivity(intent);
//            }
//        });
//        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(R.layout.activity_luu_ve);
//        FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction();
//        fragTransaction.detach(currentFragment);
//        fragTransaction.attach(currentFragment);
//        fragTransaction.commit();

        return mview;

    }


}

