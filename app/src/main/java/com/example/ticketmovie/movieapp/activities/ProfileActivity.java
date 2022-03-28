package com.example.ticketmovie.movieapp.activities;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.User;
import com.example.lib.RetrofitClient;
import com.example.ticketmovie.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends Fragment {
    View mview;
    Button btnCapNhat;
    EditText txtHoTen;
    EditText txtSoDienThoai;
    EditText txtDiaChi;
    HomeActivity mainActivity;
    Methods methods;
    Button btnchangepass;
    Button btnDangXuat;
    public static final String BASE_URL = "https://bookingmovieticket.azurewebsites.net";
    public ProfileActivity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainActivity = (HomeActivity) getActivity();
        mview = inflater.inflate(R.layout.profile_user, container, false);
        btnCapNhat = mview.findViewById(R.id.btn_save);
        txtHoTen = mview.findViewById(R.id.hoten);
        txtSoDienThoai = mview.findViewById(R.id.sodienthoai);
        txtDiaChi = mview.findViewById(R.id.diachi);
        btnchangepass = mview.findViewById(R.id.btnchangepass);
        btnDangXuat = mview.findViewById(R.id.dangxuat);
        return mview;
    }
    @Override
    public void onStart() {
        super.onStart();
        txtHoTen.setText(SignInActivity.user.getHoTen().toString());
        String sdt = SignInActivity.user.getSdt().substring(0,10);
        txtSoDienThoai.setText(sdt.toString());
        txtDiaChi.setText(SignInActivity.user.getDiaChi().toString());
        btnCapNhat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                alertDialog.setTitle("Xác nhận");
                alertDialog.setIcon(R.drawable.notification_icon);
                alertDialog.setMessage("Bạn có muốn lưu các thay đổi?");
                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = txtHoTen.getText().toString();
                        if(name.isEmpty() || name.length() < 1)
                        {
                            txtHoTen.setError("Vui lòng nhập họ tên");
                            return;
                        }
                        String sdt = txtSoDienThoai.getText().toString();
                        if(sdt.isEmpty() || sdt.length() < 10 )
                        {
                            txtSoDienThoai.setError("Số điện thoại không hợp lệ");
                            return;
                        }
                        String email = txtDiaChi.getText().toString();
                        if(email.isEmpty() || email.length() < 11 || !email.contains("@gmail.com"))
                        {
                            txtDiaChi.setError("Email không hợp lệ");
                            return;
                        }
                        Toast.makeText(mainActivity, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                        btnCapNhat();
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
        btnchangepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity, ChangeActivity.class);
                startActivity(intent);
            }
        });
        btnDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity, SignInActivity.class);
                startActivity(intent);
            }
        });
    }

    public void btnCapNhat() {
        SignInActivity.user.setHoTen(txtHoTen.getText().toString());
        SignInActivity.user.setSdt(txtSoDienThoai.getText().toString());
        SignInActivity.user.setDiaChi(txtDiaChi.getText().toString());
        methods = RetrofitClient.getRetrofit(BASE_URL).create(Methods.class);
        Call<User> call = methods.PutUser(SignInActivity.user.getIdUser(),SignInActivity.user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                //Toast.makeText(mainActivity, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
            }
        });
//        Intent intent = new Intent(mainActivity,HomeActivity.class);
//        startActivity(intent);
    }


}
