package com.codesch.afdolash.meetpoint.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.codesch.afdolash.meetpoint.R;
import com.codesch.afdolash.meetpoint.services.ApiServices;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostEventActivity extends AppCompatActivity {

    private ImageView imgEvent, imgEventBg;
    private CardView cardImage, cardPost;
    private EditText etTitle, etDescription, etLocation, etStartDate, etStartTime, etEndDate, etEndTime, etContact, etUrl, etCategory;

    private Calendar mCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_event);

        imgEvent = (ImageView) findViewById(R.id.img_event);
        imgEventBg = (ImageView) findViewById(R.id.img_event_bg);
        cardImage = (CardView) findViewById(R.id.card_image);
        cardPost = (CardView) findViewById(R.id.card_post);
        etTitle = (EditText) findViewById(R.id.et_title);
        etDescription = (EditText) findViewById(R.id.et_description);
        etLocation = (EditText) findViewById(R.id.et_location);
        etStartDate = (EditText) findViewById(R.id.et_startDate);
        etStartTime = (EditText) findViewById(R.id.et_startTime);
        etEndDate = (EditText) findViewById(R.id.et_endDate);
        etEndTime = (EditText) findViewById(R.id.et_endTime);
        etContact = (EditText) findViewById(R.id.et_contact);
        etUrl = (EditText) findViewById(R.id.et_url);
        etCategory = (EditText) findViewById(R.id.et_category);

        mCalendar = Calendar.getInstance();

        etStartDate.setFocusable(false);
        etStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(PostEventActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        mCalendar.set(Calendar.YEAR, year);
                        mCalendar.set(Calendar.MONTH, monthOfYear);
                        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        String dateFormat = "yyyy-MM-dd";
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.US);

                        etStartDate.setText(simpleDateFormat.format(mCalendar.getTime()));
                    }
                }, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        etStartTime.setFocusable(false);
        etStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(PostEventActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        etStartTime.setText(hour +":"+ minute);
                    }
                }, mCalendar.get(Calendar.HOUR), mCalendar.get(Calendar.MINUTE), true).show();
            }
        });

        etEndDate.setFocusable(false);
        etEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(PostEventActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        mCalendar.set(Calendar.YEAR, year);
                        mCalendar.set(Calendar.MONTH, monthOfYear);
                        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        String dateFormat = "yyyy-MM-dd";
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.US);

                        etEndDate.setText(simpleDateFormat.format(mCalendar.getTime()));
                    }
                }, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        etEndTime.setFocusable(false);
        etEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(PostEventActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        etEndTime.setText(hour +":"+ minute);
                    }
                }, mCalendar.get(Calendar.HOUR), mCalendar.get(Calendar.MINUTE), true).show();
            }
        });

        cardPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiServices.service_post.event(
                        etTitle.getText().toString(),
                        etDescription.getText().toString(),
                        etLocation.getText().toString(),
                        -7.339721099999999,
                        112.7399521,
                        etStartTime.getText().toString(),
                        etStartDate.getText().toString(),
                        etEndTime.getText().toString(),
                        etEndDate.getText().toString(),
                        etCategory.getText().toString(),
                        "https://cdn-az.allevents.in/bannerspace/38265fe5534d4cb1113cce458ebc57fa",
                        "user",
                        1,
                        "1",
                        0,
                        0,
                        0
                ).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        String status = response.body();
                        if (status.equals("berhasil")) {
                            Toast.makeText(PostEventActivity.this, "Sukses", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(PostEventActivity.this, status, Toast.LENGTH_SHORT).show();
                        }
//                        if (status.equals("berhasil")) {
//                            final int randomOTP = (int)(Math.random()*9000)+1000;
//                            String pesan = "Kode otentikasi Anda : "+ randomOTP;
//
//                            ApiServices.service_post.sendOtp("6285733375343", pesan).enqueue(new Callback<String>() {
//                                @Override
//                                public void onResponse(Call<String> call, Response<String> response) {
//                                    String status = response.body();
//
//                                    Intent intent = new Intent(PostEventActivity.this, OTPActivity.class);
//                                    intent.putExtra("otp", randomOTP);
//                                    startActivity(intent);
//                                    finish();
//                                }
//
//                                @Override
//                                public void onFailure(Call<String> call, Throwable t) {
//
//                                }
//                            });
//
//                        } else {
//                            Toast.makeText(PostEventActivity.this, status, Toast.LENGTH_SHORT).show();
//                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
            }
        });
    }
}
