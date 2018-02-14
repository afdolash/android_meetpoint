package com.codesch.afdolash.meetpoint.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.codesch.afdolash.meetpoint.R;
import com.codesch.afdolash.meetpoint.services.ApiServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OTPActivity extends AppCompatActivity {

    private EditText etOtp;
    private TextView tvTimer, tvSendOtp;
    private CardView cardSendOtp;

//    private int OTP;
    private int randomOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        changeStatusBarColor();

        etOtp = (EditText) findViewById(R.id.et_otp);
        tvTimer = (TextView) findViewById(R.id.tv_timer);
        tvSendOtp = (TextView) findViewById(R.id.tv_sendOTP);
        cardSendOtp = (CardView) findViewById(R.id.card_sendOTP);

//        OTP = getIntent().getExtras().getInt("otp");

        cardSendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvSendOtp.getText().equals("Kirim")) {
                    if (etOtp.getText().toString().equals(String.valueOf(randomOTP))) {
                        Toast.makeText(OTPActivity.this, "Sukses", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(OTPActivity.this, PostEventActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(OTPActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                        etOtp.setText("");
                    }
                } else {
                    sendCodeOTP();
                }
            }
        });

        sendCodeOTP();
    }

    private void sendCodeOTP() {
        tvSendOtp.setText("Kirim");
        randomOTP = (int)(Math.random()*9000)+1000;
        String pesan = "Kode otentikasi Anda : "+ randomOTP;

        ApiServices.service_post.sendOtp("628124078773", pesan).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                new CountDownTimer(59000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        tvTimer.setText(millisUntilFinished / 1000 +" detik");
                    }

                    public void onFinish() {
                        tvTimer.setText("0 detik");
                        tvSendOtp.setText("Kirim Ulang Otentikasi");
                    }

                }.start();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
