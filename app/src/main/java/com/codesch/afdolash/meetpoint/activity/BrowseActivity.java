package com.codesch.afdolash.meetpoint.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.codesch.afdolash.meetpoint.R;
import com.codesch.afdolash.meetpoint.adapter.CategoryAdapter;
import com.codesch.afdolash.meetpoint.adapter.EventAdapter;
import com.codesch.afdolash.meetpoint.model.Event;
import com.codesch.afdolash.meetpoint.services.ApiServices;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrowseActivity extends AppCompatActivity {

    private RecyclerView recyclerCategory, recyclerUpdate, recyclerRecommended, recyclerAds, recyclerToday, recyclerAround, recyclerPopular;
    private ImageButton btnSearch, btnProfile;
    private ImageView imgLogo;

    private List<Event> mEventList = new ArrayList<>();
    private EventAdapter mEventAdapter;
    private CategoryAdapter mCategoryAdapter;

//    private boolean isLoading = false;
//    private boolean isLastPage = false;
//    private int currentPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerCategory = (RecyclerView) findViewById(R.id.recycler_category);
        recyclerUpdate = (RecyclerView) findViewById(R.id.recycler_update);
        recyclerRecommended = (RecyclerView) findViewById(R.id.recycler_recommended);
        recyclerAds = (RecyclerView) findViewById(R.id.recycler_ads);
        recyclerToday = (RecyclerView) findViewById(R.id.recycler_today);
        recyclerAround = (RecyclerView) findViewById(R.id.recycler_around);
        recyclerPopular = (RecyclerView) findViewById(R.id.recycler_popular);
        btnSearch = (ImageButton) findViewById(R.id.btn_search);
        btnProfile = (ImageButton) findViewById(R.id.btn_profile);
        imgLogo = (ImageView) findViewById(R.id.img_logo);

        imgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logoIntent = new Intent(BrowseActivity.this, MapsActivity.class);
                startActivity(logoIntent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchIntent = new Intent(BrowseActivity.this, SearchActivity.class);
                startActivity(searchIntent);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent =  new Intent(BrowseActivity.this, OTPActivity.class);
                startActivity(profileIntent);
            }
        });

        // Snap Helper
        SnapHelper snapHelper = new GravitySnapHelper(Gravity.START);
        snapHelper.attachToRecyclerView(recyclerUpdate);

        // Category Recycler View
        mCategoryAdapter = new CategoryAdapter(BrowseActivity.this);
        RecyclerView.LayoutManager mCategoryManager = new LinearLayoutManager(BrowseActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerCategory.setLayoutManager(mCategoryManager);
        recyclerCategory.setItemAnimator(new DefaultItemAnimator());
        recyclerCategory.setAdapter(mCategoryAdapter);

        // Event Update Recycler View
        final RecyclerView.LayoutManager mEventManager = new LinearLayoutManager(BrowseActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerUpdate.setLayoutManager(mEventManager);
        recyclerUpdate.setItemAnimator(new DefaultItemAnimator());

        ApiServices.service_get.getAllEvent().enqueue(new Callback<ArrayList<Event>>() {
            @Override
            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
                mEventList = response.body()  ;

                mEventAdapter = new EventAdapter(BrowseActivity.this, mEventList);
                mEventAdapter.notifyDataSetChanged();

                recyclerUpdate.setAdapter(mEventAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
                Toast.makeText(BrowseActivity.this,"Mohon maaf terjadi gangguan dengan jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });

        // Event Recommended Recycler View
        final RecyclerView.LayoutManager mEventManagerRecom = new LinearLayoutManager(BrowseActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerRecommended.setLayoutManager(mEventManagerRecom);
        recyclerRecommended.setItemAnimator(new DefaultItemAnimator());

        ApiServices.service_post.eventKesukaan(1).enqueue(new Callback<ArrayList<Event>>() {
            @Override
            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
                mEventList = response.body()  ;

                mEventAdapter = new EventAdapter(BrowseActivity.this, mEventList);
                mEventAdapter.notifyDataSetChanged();

                recyclerRecommended.setAdapter(mEventAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
                Toast.makeText(BrowseActivity.this,"Mohon maaf terjadi gangguan dengan jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });

        // Event Ads Recycler View
        final RecyclerView.LayoutManager mEventManagerAds = new LinearLayoutManager(BrowseActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerAds.setLayoutManager(mEventManagerAds);
        recyclerAds.setItemAnimator(new DefaultItemAnimator());

        ApiServices.service_get.getAllEvent().enqueue(new Callback<ArrayList<Event>>() {
            @Override
            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
                mEventList = response.body()  ;

                mEventAdapter = new EventAdapter(BrowseActivity.this, mEventList);
                mEventAdapter.notifyDataSetChanged();

                recyclerAds.setAdapter(mEventAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
                Toast.makeText(BrowseActivity.this,"Mohon maaf terjadi gangguan dengan jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });

        // Event Today Recycler View
        final RecyclerView.LayoutManager mEventManagerToday = new LinearLayoutManager(BrowseActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerToday.setLayoutManager(mEventManagerToday);
        recyclerToday.setItemAnimator(new DefaultItemAnimator());

        ApiServices.service_get.getEventToday().enqueue(new Callback<ArrayList<Event>>() {
            @Override
            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
                mEventList = response.body()  ;

                mEventAdapter = new EventAdapter(BrowseActivity.this, mEventList);
                mEventAdapter.notifyDataSetChanged();

                recyclerToday.setAdapter(mEventAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
                Toast.makeText(BrowseActivity.this,"Mohon maaf terjadi gangguan dengan jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });

        // Event Around Recycler View
        final RecyclerView.LayoutManager mEventManagerAround = new LinearLayoutManager(BrowseActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerAround.setLayoutManager(mEventManagerAround);
        recyclerAround.setItemAnimator(new DefaultItemAnimator());

        ApiServices.service_get.getAllEvent().enqueue(new Callback<ArrayList<Event>>() {
            @Override
            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
                mEventList = response.body()  ;

                mEventAdapter = new EventAdapter(BrowseActivity.this, mEventList);
                mEventAdapter.notifyDataSetChanged();

                recyclerAround.setAdapter(mEventAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
                Toast.makeText(BrowseActivity.this,"Mohon maaf terjadi gangguan dengan jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });

        // Event Popular Recycler View
        final RecyclerView.LayoutManager mEventManagerPopular = new LinearLayoutManager(BrowseActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerPopular.setLayoutManager(mEventManagerPopular);
        recyclerPopular.setItemAnimator(new DefaultItemAnimator());

        ApiServices.service_get.getAllEvent().enqueue(new Callback<ArrayList<Event>>() {
            @Override
            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
                mEventList = response.body()  ;

                mEventAdapter = new EventAdapter(BrowseActivity.this, mEventList);
                mEventAdapter.notifyDataSetChanged();

                recyclerPopular.setAdapter(mEventAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
                Toast.makeText(BrowseActivity.this,"Mohon maaf terjadi gangguan dengan jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });

//        // New Post Event with Pagination
//        mEventAdapter = new EventAdapter(BrowseActivity.this, mEventList);
//        mEventAdapter.notifyDataSetChanged();
//
//        recyclerUpdate.setAdapter(mEventAdapter);
//        recyclerUpdate.addOnScrollListener(new PaginationScrollListener((LinearLayoutManager) mEventManager) {
//            @Override
//            protected void loadMoreItems() {
//                isLoading = true;
//                currentPage += 1;
//
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        ApiServices.service_post.postAllEvent(currentPage).enqueue(new Callback<ArrayList<Event>>() {
//                            @Override
//                            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
//                                mEventAdapter.removeLoadingFooter();
//
//                                isLoading = false;
//
//                                mEventList.addAll(response.body());
//                                mEventAdapter.notifyDataSetChanged();
//                                mEventAdapter.addLoadingFooter();
//                            }
//
//                            @Override
//                            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
//                                isLastPage = true;
//                                mEventAdapter.removeLoadingFooter();
//                            }
//                        });
//                    }
//                }, 2000);
//            }
//
//            @Override
//            public int getTotalPageCount() {
//                return 10;
//            }
//
//            @Override
//            public boolean isLastPage() {
//                return isLastPage;
//            }
//
//            @Override
//            public boolean isLoading() {
//                return isLoading;
//            }
//        });
//
//        ApiServices.service_post.postAllEvent(currentPage).enqueue(new Callback<ArrayList<Event>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
//                mEventList.addAll(response.body());
//                mEventAdapter.notifyDataSetChanged();
//                mEventAdapter.addLoadingFooter();
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
//                isLastPage = true;
//            }
//        });
    }
}
