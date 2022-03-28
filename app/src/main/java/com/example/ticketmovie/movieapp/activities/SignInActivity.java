package com.example.ticketmovie.movieapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.User;
import com.example.lib.RetrofitClient;
import com.example.ticketmovie.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {

    EditText edtUserName;
    EditText edtPassword;
    Methods methods;
    public static User user;
    String u;
    String p;
    public static final String BASE_URL = "https://bookingmovieticket.azurewebsites.net";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        edtUserName= findViewById(R.id.edtUsername);
        edtPassword= findViewById(R.id.edtPassword);
        methods = RetrofitClient.getRetrofit(BASE_URL).create(Methods.class);
    }

    public void dangnhap(View view) {
        u= edtUserName.getText().toString();
        p= edtPassword.getText().toString();
        Call<User> userCall= methods.getUser(u,p);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user = response.body();
                if(user==null)
                {
                    Toast.makeText(SignInActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                    startActivity(intent);

                    Toast.makeText(SignInActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(SignInActivity.this,"fail",Toast.LENGTH_SHORT);
            }
        });

    }

    public void dangky(View view) {
        Intent intent = new Intent(SignInActivity.this, SignupActivity.class);
        startActivity(intent);
    }
}