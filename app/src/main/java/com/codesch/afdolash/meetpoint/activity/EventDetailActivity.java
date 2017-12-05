package com.codesch.afdolash.meetpoint.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codesch.afdolash.meetpoint.R;
import com.codesch.afdolash.meetpoint.adapter.AuthorAdapter;
import com.codesch.afdolash.meetpoint.adapter.EventAdapter;
import com.codesch.afdolash.meetpoint.model.Author;
import com.codesch.afdolash.meetpoint.model.Event;
import com.codesch.afdolash.meetpoint.services.ApiServices;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventDetailActivity extends AppCompatActivity {

    private ImageView imgEvent, imgEventBg, imgAuthor, imgBadge;
    private TextView tvTitle, tvLocation, tvDescription, tvReadMore, tvAuthor, tvTitleRating, tvRate,
            tvLiker, tvStartDate, tvStartTime, tvEndDate, tvEndTime, tvMoreSimillar;
    private View viewTransparent;
    private CardView cardRating, cardFavorite;
    private LinearLayout linearContact, linearWebsite, linearReport;
    private RecyclerView recyclerSimillar, recyclerPeople;

    private Event mEvent;
    private List<Event> mSimillarList = new ArrayList<>();
    private List<Author> mPeopleList = new ArrayList<>();
    private EventAdapter mSimillarAdapter;
    private AuthorAdapter mPeopleAdapter;

    private int ID_EVENT;
    private String[] date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ID_EVENT = getIntent().getExtras().getInt("id_event", 0);

        recyclerPeople = (RecyclerView) findViewById(R.id.recycler_people);
        recyclerSimillar = (RecyclerView) findViewById(R.id.recycler_simillar);
        imgEvent = (ImageView) findViewById(R.id.img_event);
        imgEventBg = (ImageView) findViewById(R.id.img_event_bg);
        imgAuthor = (ImageView) findViewById(R.id.img_author);
        imgBadge = (ImageView) findViewById(R.id.img_badge);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvLocation = (TextView) findViewById(R.id.tv_location);
        tvDescription = (TextView) findViewById(R.id.tv_description);
        tvReadMore = (TextView) findViewById(R.id.tv_readMore);
        tvAuthor = (TextView) findViewById(R.id.tv_author);
        tvTitleRating = (TextView) findViewById(R.id.tv_title_rating);
        tvRate = (TextView) findViewById(R.id.tv_rate);
        tvLiker = (TextView) findViewById(R.id.tv_liker);
        tvStartDate = (TextView) findViewById(R.id.tv_startDate);
        tvStartTime = (TextView) findViewById(R.id.tv_startTime);
        tvEndDate = (TextView) findViewById(R.id.tv_endDate);
        tvEndTime = (TextView) findViewById(R.id.tv_endTime);
        tvMoreSimillar = (TextView) findViewById(R.id.tv_moreSimillar);
        viewTransparent = findViewById(R.id.view_transparent);
        cardRating = (CardView) findViewById(R.id.card_rating);
        cardFavorite = (CardView) findViewById(R.id.card_favorite);
        linearContact = (LinearLayout) findViewById(R.id.linear_contact);
        linearWebsite = (LinearLayout) findViewById(R.id.linear_website);
        linearReport = (LinearLayout) findViewById(R.id.linear_report);

        ApiServices.service_post.eventDetail(ID_EVENT).enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {
                mEvent = response.body();

                tvTitle.setText(mEvent.getTitle_event());
                tvLocation.setText(mEvent.getLocation_event());
                tvDescription.setText(Html.fromHtml(mEvent.getDescription_event()));
                if (mEvent.getId_user() == null) {
                    tvAuthor.setText(mEvent.getAuthor_event());
                } else {
                    tvAuthor.setText(mEvent.getId_user().getNama_user());
                    tvRate.setText(String.format("%.1f", mEvent.getId_user().getRating_user()));
                }
                tvStartDate.setText(mEvent.getDateStart_event());
                tvStartTime.setText("pukul "+ mEvent.getTimeStart_event() +" wib");
                if (mEvent.getDateEnd_event() == null) {
                    tvEndDate.setText(mEvent.getDateStart_event());
                    tvEndTime.setText("pukul "+ mEvent.getTimeStart_event() +" wib");
                } else {
                    tvEndDate.setText(mEvent.getDateEnd_event());
                    tvEndTime.setText("pukul "+ mEvent.getTimeEnd_event() +" wib");
                }

                Glide.with(EventDetailActivity.this)
                        .load(mEvent.getImage_event())
                        .into(imgEvent);

                Glide.with(EventDetailActivity.this)
                        .load(mEvent.getImage_event())
                        .into(imgEventBg);
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {

            }
        });
    }

    private String dateEvent(String dataDate) {
        String sDate = null;
        date = dataDate.split("-");

        switch (date[1]) {
            case "01":
                sDate = date[2] +" Januari "+ date[0];
                break;
            case "02":
                sDate = date[2] +" Februari "+ date[0];
                break;
            case "03":
                sDate = date[2] +" Maret "+ date[0];
                break;
            case "04":
                sDate = date[2] +" April "+ date[0];
                break;
            case "05":
                sDate = date[2] +" Mei "+ date[0];
                break;
            case "06":
                sDate = date[2] +" Juni "+ date[0];
                break;
            case "07":
                sDate = date[2] +" Juli "+ date[0];
                break;
            case "08":
                sDate = date[2] +" Agustus "+ date[0];
                break;
            case "09":
                sDate = date[2] +" September "+ date[0];
                break;
            case "10":
                sDate = date[2] +" Oktober "+ date[0];
                break;
            case "11" :
                sDate = date[2] +" November "+ date[0];
                break;
            case "12":
                sDate = date[2] +" Desember "+ date[0];
                break;
        }

        return sDate;
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
