package com.codesch.afdolash.meetpoint.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.codesch.afdolash.meetpoint.R;
import com.codesch.afdolash.meetpoint.adapter.CategoryAdapter;
import com.codesch.afdolash.meetpoint.adapter.EventAdapter;
import com.codesch.afdolash.meetpoint.model.Event;

import java.util.ArrayList;
import java.util.List;

public class BrowseActivity extends AppCompatActivity {

    private RecyclerView recyclerCategory, recyclerUpdate, recyclerRecommended, recyclerAds, recyclerToday, recyclerAround, recyclerPopular;
    private ImageButton btnSearch;

    private List<Event> mEventList = new ArrayList<>();
    private EventAdapter mEventAdapter;
    private CategoryAdapter mCategoryAdapter;


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

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchIntent = new Intent(BrowseActivity.this, SearchActivity.class);
                startActivity(searchIntent);
            }
        });

        // Category Recycler View
        mCategoryAdapter = new CategoryAdapter(BrowseActivity.this);
        RecyclerView.LayoutManager mCategoryManager = new LinearLayoutManager(BrowseActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerCategory.setLayoutManager(mCategoryManager);
        recyclerCategory.setItemAnimator(new DefaultItemAnimator());
        recyclerCategory.setAdapter(mCategoryAdapter);

        // Event Recycler View
        mEventAdapter = new EventAdapter(BrowseActivity.this, mEventList);
        RecyclerView.LayoutManager mEventManager = new LinearLayoutManager(BrowseActivity.this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager mEventManager2 = new LinearLayoutManager(BrowseActivity.this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager mEventManager3 = new LinearLayoutManager(BrowseActivity.this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager mEventManager4 = new LinearLayoutManager(BrowseActivity.this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager mEventManager5 = new LinearLayoutManager(BrowseActivity.this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager mEventManager6 = new LinearLayoutManager(BrowseActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerUpdate.setLayoutManager(mEventManager);
        recyclerUpdate.setItemAnimator(new DefaultItemAnimator());
        recyclerUpdate.setAdapter(mEventAdapter);

        recyclerRecommended.setLayoutManager(mEventManager2);
        recyclerRecommended.setItemAnimator(new DefaultItemAnimator());
        recyclerRecommended.setAdapter(mEventAdapter);

        recyclerAds.setLayoutManager(mEventManager3);
        recyclerAds.setItemAnimator(new DefaultItemAnimator());
        recyclerAds.setAdapter(mEventAdapter);

        recyclerAround.setLayoutManager(mEventManager4);
        recyclerAround.setItemAnimator(new DefaultItemAnimator());
        recyclerAround.setAdapter(mEventAdapter);

        recyclerPopular.setLayoutManager(mEventManager5);
        recyclerPopular.setItemAnimator(new DefaultItemAnimator());
        recyclerPopular.setAdapter(mEventAdapter);

        recyclerToday.setLayoutManager(mEventManager6);
        recyclerToday.setItemAnimator(new DefaultItemAnimator());
        recyclerToday.setAdapter(mEventAdapter);

        prepareEventData();
    }

    private void prepareEventData() {
        Event event = new Event(
                "GDG Surabaya",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "Muhibush",
                "https://www.google.co.id/search?q=event&dcr=0&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjZ2rreqITXAhVEQY8KHQc0AHoQ_AUICigB&biw=1920&bih=984#imgrc=rsbE5iEAHDJWEM:",
                "Concert",
                "18 July 2017",
                "16.00",
                "18 July 2017",
                "21.00",
                -7.267522,
                112.799088
        );
        mEventList.add(event);
        mEventList.add(event);
        mEventList.add(event);
        mEventList.add(event);
        mEventList.add(event);

        mEventAdapter.notifyDataSetChanged();
    }
}
