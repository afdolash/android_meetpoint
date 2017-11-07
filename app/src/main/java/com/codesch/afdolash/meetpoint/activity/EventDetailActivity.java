package com.codesch.afdolash.meetpoint.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.codesch.afdolash.meetpoint.R;
import com.codesch.afdolash.meetpoint.adapter.AuthorAdapter;
import com.codesch.afdolash.meetpoint.adapter.EventAdapter;
import com.codesch.afdolash.meetpoint.model.Author;
import com.codesch.afdolash.meetpoint.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventDetailActivity extends AppCompatActivity {

    private RecyclerView recyclerSimillar, recyclerPeople;

    private List<Event> mSimillarList = new ArrayList<>();
    private List<Author> mPeopleList = new ArrayList<>();
    private EventAdapter mSimillarAdapter;
    private AuthorAdapter mPeopleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerPeople = (RecyclerView) findViewById(R.id.recycler_people);
        recyclerSimillar = (RecyclerView) findViewById(R.id.recycler_simillar);

        // Simillar Recycler View
        mSimillarAdapter = new EventAdapter(EventDetailActivity.this, mSimillarList);
        RecyclerView.LayoutManager mSimillarManager = new LinearLayoutManager(EventDetailActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerSimillar.setLayoutManager(mSimillarManager);
        recyclerSimillar.setItemAnimator(new DefaultItemAnimator());
        recyclerSimillar.setAdapter(mSimillarAdapter);

        // People Recycler View
        mPeopleAdapter = new AuthorAdapter(EventDetailActivity.this, mPeopleList);
        RecyclerView.LayoutManager mAuthorManager = new LinearLayoutManager(EventDetailActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerPeople.setLayoutManager(mAuthorManager);
        recyclerPeople.setItemAnimator(new DefaultItemAnimator());
        recyclerPeople.setAdapter(mPeopleAdapter);

        prepareAuthorData();
        prepareSimillarData();
    }

    private void prepareSimillarData() {
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

        mSimillarList.add(event);
        mSimillarList.add(event);
        mSimillarList.add(event);
        mSimillarList.add(event);
        mSimillarList.add(event);

        mSimillarAdapter.notifyDataSetChanged();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_detail, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_share:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();

        return super.onSupportNavigateUp();
    }
}
