package com.codesch.afdolash.meetpoint.services;

import com.codesch.afdolash.meetpoint.model.Event;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Afdolash on 11/13/2017.
 */

public class ApiServices {
    public static String BASE_URL = "http://muhibush.xyz/api_meet_point/index.php/Master/";

    public static PostService service_post = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiServices.PostService.class);

    public static GetService service_get = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiServices.GetService.class);

    public static DeleteService service_delete = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiServices.DeleteService.class);

    public interface PostService {
        @FormUrlEncoded
        @POST("event_detail")
        Call<Event> eventDetail(@Field("id_event") int id_event);

        @FormUrlEncoded
        @POST("event")
        Call<String> event(
                @Field("title_event") String title_event,
                @Field("description_event") String description_event,
                @Field("location_event") String location_event,
                @Field("latitude_event") double latitude_event,
                @Field("longitude_event") double longitude_event,
                @Field("timeStart_event") String timeStart_event,
                @Field("dateStart_event") String dateStart_event,
                @Field("timeEnd_event") String timeEnd_event,
                @Field("dateEnd_event") String dateEnd_event,
                @Field("category_event") String category_event,
                @Field("image_event") String image_event,
                @Field("source_event") String source_event,
                @Field("enthusiasts_event") int enthusiasts_event,
                @Field("author_event") String author_event,
                @Field("viewer_event") int viewer_event,
                @Field("report_event") int report_event,
                @Field("block_event") int block_event
        );

        @FormUrlEncoded
        @POST("otp")
        Call<String> sendOtp(@Field("nomor") String nomor, @Field("pesan") String pesan);

        @FormUrlEncoded
        @POST("event_kesukaan")
        Call<ArrayList<Event>> eventKesukaan(@Field("id_user") int id_user);
    }

    public interface GetService {
        @GET("all_event")
        Call<ArrayList<Event>> getAllEvent();

        @GET("event_hari_ini")
        Call<ArrayList<Event>> getEventToday();

    }

    public interface DeleteService {

    }
}
