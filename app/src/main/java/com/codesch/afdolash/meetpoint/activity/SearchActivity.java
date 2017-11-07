package com.codesch.afdolash.meetpoint.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.codesch.afdolash.meetpoint.R;
import com.codesch.afdolash.meetpoint.adapter.AuthorAdapter;
import com.codesch.afdolash.meetpoint.adapter.CategoryAdapter;
import com.codesch.afdolash.meetpoint.adapter.EventAdapter;
import com.codesch.afdolash.meetpoint.adapter.HistoryAdapter;
import com.codesch.afdolash.meetpoint.adapter.TimelineAdapter;
import com.codesch.afdolash.meetpoint.model.Author;
import com.codesch.afdolash.meetpoint.model.Event;
import com.codesch.afdolash.meetpoint.model.History;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

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

        // Ads Recycler View
        mAdsAdapter = new EventAdapter(SearchActivity.this, mAdsList);
        RecyclerView.LayoutManager mAdsManager = new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerAds.setLayoutManager(mAdsManager);
        recyclerAds.setItemAnimator(new DefaultItemAnimator());
        recyclerAds.setAdapter(mAdsAdapter);

        // History Recycler View
        mHistoryAdapter = new HistoryAdapter(SearchActivity.this, mHistoryList);
        RecyclerView.LayoutManager mHistoryManager = new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.VERTICAL, false);

        recyclerHistory.setLayoutManager(mHistoryManager);
        recyclerHistory.setItemAnimator(new DefaultItemAnimator());
        recyclerHistory.setAdapter(mHistoryAdapter);
        recyclerHistory.setNestedScrollingEnabled(false);
        recyclerHistory.setFocusable(false);

        prepareAuthorData();
        prepareAdsData();
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

    private void prepareAdsData() {
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

        mAdsList.add(event);
        mAdsList.add(event);
        mAdsList.add(event);
        mAdsList.add(event);
        mAdsList.add(event);

        mAdsAdapter.notifyDataSetChanged();
    }

    private void prepareAuthorData() {
        Author author = new Author(
                "Afdolash",
                "Administrator",
                "",
                "",
                20000.0,
                20000.0
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
