package com.example.ticketmovie.movieapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.User;
import com.example.lib.RetrofitClient;
import com.example.ticketmovie.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    EditText edtFullname;
    EditText edtUsername;
    EditText edtPassword;
    EditText phone;
    EditText Diachi;
    Button adduser;
    Methods methods;
    List<User> userList = new ArrayList<User>();
    public static final String BASE_URL = "https://bookingmovieticket.azurewebsites.net";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
    protected  void  onStart(){
        super.onStart();
        setContentView(R.layout.activity_signup);
        methods = RetrofitClient.getRetrofit(BASE_URL).create(Methods.class);
        edtFullname= findViewById(R.id.edtFullName);
        edtUsername= findViewById(R.id.edtUsername);
        edtPassword= findViewById(R.id.edtPassword);
        phone= findViewById(R.id.edtPhone);
        Diachi=findViewById(R.id.Diachi);
        adduser = findViewById(R.id.btnSignUp);
        Call <List<User>> call = methods.GetUser();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                userList = response.body();
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
            }
        });
        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtFullname.getText().toString();
                if(name.isEmpty() || name.length() < 1)
                {
                    edtFullname.setError("Vui lòng nhập họ tên");
                    return;
                }
                String username = edtUsername.getText().toString();
                if(username.isEmpty() || username.length() < 6 || username.length() >30)
                {
                    edtUsername.setError("Tên người dùng của bạn phải nằm trong khoảng độ dài ký tự từ giữa 6 và 30");
                    return;
                }
                for(int i = 0; i< userList.size();i++){
                    if(username.equals(userList.get(i).getTaiKhoan().toString()))
                    {
                        edtUsername.setError("Tài khoản bị trùng");
                        return;
                    }
                }
                String pass = edtPassword.getText().toString();
                if(pass.isEmpty() || pass.length() < 6 )
                {
                    edtPassword.setError("Mật khẩu chưa đủ 6 kí tự");
                    return;
                }
                String sdt = phone.getText().toString();
                if(sdt.isEmpty() || sdt.length() < 10 )
                {
                    phone.setError("Số điện thoại không hợp lệ");
                    return;
                }
                String email = Diachi.getText().toString();
                if(email.isEmpty() || email.length() < 11 || !email.contains("@gmail.com"))
                {
                    Diachi.setError("Email không hợp lệ");
                    return;
                }
                Toast.makeText(SignupActivity.this, "Tạo thành công tài khoản", Toast.LENGTH_SHORT).show();
                AddUser();
            }

        });
    }
    public void AddUser() {

        User user= new User(edtFullname.getText().toString(),Diachi.getText().toString(),
                phone.getText().toString(),edtUsername.getText().toString(),edtPassword.getText().toString());
        methods.postUser(user).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });
        Intent intent = new Intent(SignupActivity.this, SignInActivity.class);
        startActivity(intent);
    }

    public void Dangnhap(View view) {
        Intent intent = new Intent(SignupActivity.this, SignInActivity.class);
        startActivity(intent);
    }
}