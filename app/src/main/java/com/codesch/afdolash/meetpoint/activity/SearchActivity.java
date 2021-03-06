package com.codesch.afdolash.meetpoint.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.codesch.afdolash.meetpoint.R;
import com.codesch.afdolash.meetpoint.adapter.AuthorAdapter;
import com.codesch.afdolash.meetpoint.adapter.CategoryAdapter;
import com.codesch.afdolash.meetpoint.adapter.EventAdapter;
import com.codesch.afdolash.meetpoint.adapter.HistoryAdapter;
import com.codesch.afdolash.meetpoint.adapter.TimelineAdapter;
import com.codesch.afdolash.meetpoint.model.Author;
import com.codesch.afdolash.meetpoint.model.Event;
import com.codesch.afdolash.meetpoint.model.History;
import com.codesch.afdolash.meetpoint.services.ApiServices;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    private MaterialSearchView searchView;
    private RecyclerView recyclerCategory, recyclerPeople, recyclerTimeline, recyclerAds, recyclerHistory;

    private List<Author> mPeopleList = new ArrayList<>();
    private List<Event> mAdsList = new ArrayList<>();
    private List<History> mHistoryList = new ArrayList<>();
    private CategoryAdapter mCategoryAdapter;
    private TimelineAdapter mTimelineAdapter;
    private AuthorAdapter mPeopleAdapter;
    private EventAdapter mAdsAdapter;
    private HistoryAdapter mHistoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerCategory = (RecyclerView) findViewById(R.id.recycler_category);
        recyclerPeople = (RecyclerView) findViewById(R.id.recycler_people);
        recyclerTimeline = (RecyclerView) findViewById(R.id.recycler_timeline);
        recyclerAds = (RecyclerView) findViewById(R.id.recycler_ads);
        recyclerHistory = (RecyclerView) findViewById(R.id.recycler_history);
        searchView = (MaterialSearchView) findViewById(R.id.search_view);

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });

        // Event Ads Recycler View
        final RecyclerView.LayoutManager mEventManagerAds = new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerAds.setLayoutManager(mEventManagerAds);
        recyclerAds.setItemAnimator(new DefaultItemAnimator());

        ApiServices.service_get.getAllEvent().enqueue(new Callback<ArrayList<Event>>() {
            @Override
            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
                mAdsList = response.body()  ;

                mAdsAdapter = new EventAdapter(SearchActivity.this, mAdsList);
                mAdsAdapter.notifyDataSetChanged();

                recyclerAds.setAdapter(mAdsAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
                Toast.makeText(SearchActivity.this,"Mohon maaf terjadi gangguan dengan jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });

        // Category Recycler View
        mCategoryAdapter = new CategoryAdapter(SearchActivity.this);
        RecyclerView.LayoutManager mCategoryManager = new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerCategory.setLayoutManager(mCategoryManager);
        recyclerCategory.setItemAnimator(new DefaultItemAnimator());
        recyclerCategory.setAdapter(mCategoryAdapter);

        // People Recycler View
        mPeopleAdapter = new AuthorAdapter(SearchActivity.this, mPeopleList);
        RecyclerView.LayoutManager mAuthorManager = new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerPeople.setLayoutManager(mAuthorManager);
        recyclerPeople.setItemAnimator(new DefaultItemAnimator());
        recyclerPeople.setAdapter(mPeopleAdapter);

        // Timeline Recycler View
        mTimelineAdapter = new TimelineAdapter(SearchActivity.this);
        RecyclerView.LayoutManager mTimelineManager = new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerTimeline.setLayoutManager(mTimelineManager);
        recyclerTimeline.setItemAnimator(new DefaultItemAnimator());
        recyclerTimeline.setAdapter(mTimelineAdapter);

        // History Recycler View
        mHistoryAdapter = new HistoryAdapter(SearchActivity.this, mHistoryList);
        RecyclerView.LayoutManager mHistoryManager = new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.VERTICAL, false);

        recyclerHistory.setLayoutManager(mHistoryManager);
        recyclerHistory.setItemAnimator(new DefaultItemAnimator());
        recyclerHistory.setAdapter(mHistoryAdapter);
        recyclerHistory.setNestedScrollingEnabled(false);
        recyclerHistory.setFocusable(false);

        prepareAuthorData();
        prepareHistoryData();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();

        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem item = menu.findItem(R.id.nav_search);
        searchView.setMenuItem(item);

        return true;
    }

    private void prepareAuthorData() {
        Author author = new Author(
                7,
                "Afdolash",
                "Administrator",
                2.0f,
                "00000",
                17,
                "Pria"
        );

        mPeopleList.add(author);
        mPeopleList.add(author);
        mPeopleList.add(author);
        mPeopleList.add(author);
        mPeopleList.add(author);
        mPeopleList.add(author);
        mPeopleList.add(author);
        mPeopleList.add(author);
        mPeopleList.add(author);
        mPeopleList.add(author);

        mPeopleAdapter.notifyDataSetChanged();
    }

    private void prepareHistoryData() {
        History history = new History("Concert");

        mHistoryList.add(history);
        mHistoryList.add(history);
        mHistoryList.add(history);
        mHistoryList.add(history);
        mHistoryList.add(history);
        mHistoryList.add(history);
        mHistoryList.add(history);
        mHistoryList.add(history);
        mHistoryList.add(history);
        mHistoryList.add(history);

        mPeopleAdapter.notifyDataSetChanged();
    }
}
