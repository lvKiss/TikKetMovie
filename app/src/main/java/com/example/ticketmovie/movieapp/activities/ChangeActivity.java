package com.example.ticketmovie.movieapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.User;
import com.example.lib.RetrofitClient;
import com.example.ticketmovie.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Locale;
import java.util.Properties;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ChangeActivity extends AppCompatActivity {
    TextView txtMatKhauCu;
    TextView txtMatKhauMoi;
    TextView txtNhapLai;
    Methods methods;
    Button btnchange;
    TextInputLayout inputpass;
    public static final String BASE_URL = "https://bookingmovieticket.azurewebsites.net";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    protected void onStart(){
        super.onStart();
        setContentView(R.layout.change_pass);
        txtMatKhauCu = findViewById(R.id.oldpass);
        txtMatKhauMoi = findViewById(R.id.newpass);
        txtNhapLai = findViewById(R.id.cvnewpass);
        btnchange = findViewById(R.id.btn_save);
        inputpass = findViewById(R.id.newpass_text_input_layout);
        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ChangeActivity.this);
                alertDialog.setTitle("X??c nh???n");
                alertDialog.setIcon(R.drawable.notification_icon);
                alertDialog.setMessage("B???n c?? mu???n l??u c??c thay ?????i?");
                alertDialog.setPositiveButton("C??", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String pass = txtMatKhauCu.getText().toString();
                        if(pass.isEmpty() || pass.length() < 6 )
                        {
                            txtMatKhauCu.setError("M???t kh???u ch??a ????? 6 k?? t???");
                            return;
                        }
                        String passnew = txtMatKhauMoi.getText().toString();
                        if(passnew.isEmpty() || passnew.length() < 6 )
                        {
                            inputpass.setError("M???t kh???u ch??a ????? 6 k?? t???");
                            return;
                        }
                        btnChange();
                    }
                });
                alertDialog.setNegativeButton("Kh??ng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();

            }
        });
    }
//    private void setupFloatingLabelError() {
//        final TextInputLayout floatingOldPassLabel = (TextInputLayout) findViewById(R.id.oldpass_text_input_layout);
//        floatingOldPassLabel.getEditText().addTextChangedListener(new TextWatcher() {
//            // ...
//            @Override
//            public void onTextChanged(CharSequence text, int start, int count, int after) {
//                if (text.length() <= 4) {
////                    floatingOldPassLabel.setError(getString(R.string.username_required));
//                    floatingOldPassLabel.setErrorEnabled(true);
//                } else {
//                    floatingOldPassLabel.setErrorEnabled(false);
//                }
//            }
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count,
//                                          int after) {
//                // TODO Auto-generated method stub
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//    }

    public void btnChange() {
//        String sms="B???n ???? ?????i m???t kh???u TicketMovie";
//        SmsManager smsManager = SmsManager.getDefault();
//        smsManager.sendTextMessage(SignInActivity.user.getSdt().toString().trim(),null
//                ,sms,null,null);
        methods = RetrofitClient.getRetrofit(BASE_URL).create(Methods.class);
        if(!txtMatKhauCu.getText().toString().equals(SignInActivity.user.getMatKhau().toString())){
            Toast.makeText(ChangeActivity.this, "M???t kh???u kh??ng ch??nh x??c", Toast.LENGTH_SHORT).show();
        }else {
            if(!txtMatKhauMoi.getText().toString().equals(txtNhapLai.getText().toString())){
                Toast.makeText(ChangeActivity.this, "M???t kh???u kh??ng kh???p v???i nhau", Toast.LENGTH_SHORT).show();
            }else {
               SignInActivity.user.setMatKhau(txtMatKhauMoi.getText().toString());
                Call<User> call = methods.ChangePasswWord(SignInActivity.user.getIdUser(),txtMatKhauMoi.getText().toString());
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(ChangeActivity.this, "?????i m???t kh??ng kh???u th??nh c??ng ", Toast.LENGTH_SHORT).show();
                    }
                });
                Intent intent = new Intent(ChangeActivity.this,SignInActivity.class);
                startActivity(intent);
                Toast.makeText(ChangeActivity.this, "?????i m???t kh???u th??nh c??ng", Toast.LENGTH_SHORT).show();
            }
        }
//        final String email="dangnguyen7500@gmail.com";
//        final String ps= "prehaploke1";
//        String sendss= "Ban ???? ?????i m???t kh???u MovieTicket";
//        Properties props = new Properties();
//        props.put("mail.smtp.auth","true");
//        props.put("mail.smtp.starttls.enable","true");
//        props.put("mail.smtp.host","smtp.gmail.com");
//        props.put("mail.smtp.host","587");
//        Session session= Session.getInstance(props, new javax.mail.Authenticator(){
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(email,ps);
//            }
//        });
//        try{
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(email));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(SignInActivity.user.getDiaChi().toString()));
//            message.setSubject("Thay ?????i m???t kh???u");
//            message.setText(sendss);
//            Transport.send(message[0]);
//        }catch (MessagingException e){
//            throw new RuntimeException(e);
//        }
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
    }
}
