package com.codesch.afdolash.meetpoint.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.transition.Visibility;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.codesch.afdolash.meetpoint.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.Transition;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private CardView cardStarted;
    private RelativeLayout catCoffee, catTalkshow, catWorkshop, catContest, catConcert, catFestival, catExhibition, catCommunity, catReligion, catSocial;
    private RelativeLayout relativeCoffee, relativeTalkshow, relativeWorkshop, relativeContest, relativeConcert, relativeFestival, relativeExhibition, relativeCommunity, relativeReligion, relativeSocial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        changeStatusBarColor();

        cardStarted = (CardView) findViewById(R.id.card_started);

        catCoffee = (RelativeLayout) findViewById(R.id.cat_coffee);
        catTalkshow = (RelativeLayout) findViewById(R.id.cat_talkshow);
        catWorkshop = (RelativeLayout) findViewById(R.id.cat_workshop);
        catContest = (RelativeLayout) findViewById(R.id.cat_contest);
        catConcert = (RelativeLayout) findViewById(R.id.cat_concert);
        catFestival = (RelativeLayout) findViewById(R.id.cat_festival);
        catExhibition = (RelativeLayout) findViewById(R.id.cat_exhibition);
        catCommunity = (RelativeLayout) findViewById(R.id.cat_community);
        catReligion = (RelativeLayout) findViewById(R.id.cat_religion);
        catSocial = (RelativeLayout) findViewById(R.id.cat_social);

        relativeCoffee = (RelativeLayout) findViewById(R.id.relative_coffee);
        relativeTalkshow = (RelativeLayout) findViewById(R.id.relative_talkshow);
        relativeWorkshop = (RelativeLayout) findViewById(R.id.relative_workshop);
        relativeContest = (RelativeLayout) findViewById(R.id.relative_contest);
        relativeConcert = (RelativeLayout) findViewById(R.id.relative_concert);
        relativeFestival = (RelativeLayout) findViewById(R.id.relative_festival);
        relativeExhibition = (RelativeLayout) findViewById(R.id.relative_exhibition);
        relativeCommunity = (RelativeLayout) findViewById(R.id.relative_community);
        relativeReligion = (RelativeLayout) findViewById(R.id.relative_religion);
        relativeSocial = (RelativeLayout) findViewById(R.id.relative_social);

        cardStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> selectedCategory = new ArrayList<>();

                if (catCoffee.getVisibility() == View.VISIBLE) {
                    selectedCategory.add("Coffee Break");
                }

                if (catTalkshow.getVisibility() == View.VISIBLE) {
                    selectedCategory.add("Talkshow");
                }

                if (catWorkshop.getVisibility() == View.VISIBLE) {
                    selectedCategory.add("Workshop");
                }

                if (catContest.getVisibility() == View.VISIBLE) {
                    selectedCategory.add("Contest");
                }

                if (catConcert.getVisibility() == View.VISIBLE) {
                    selectedCategory.add("Concert");
                }

                if (catFestival.getVisibility() == View.VISIBLE) {
                    selectedCategory.add("Festival");
                }

                if (catExhibition.getVisibility() == View.VISIBLE) {
                    selectedCategory.add("Exhibition");
                }

                if (catCommunity.getVisibility() == View.VISIBLE) {
                    selectedCategory.add("Commnity");
                }

                if (catReligion.getVisibility() == View.VISIBLE) {
                    selectedCategory.add("Religion");
                }

                if (catSocial.getVisibility() == View.VISIBLE) {
                    selectedCategory.add("Social");
                }

                if (selectedCategory.size() >= 3) {
                    Intent intent = new Intent(CategoryActivity.this, BrowseActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(CategoryActivity.this, "Pilih minimal 3 kategori!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        relativeCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (catCoffee.getVisibility() == View.VISIBLE) {
                    catCoffee.setVisibility(View.INVISIBLE);
                } else {
                    catCoffee.setVisibility(View.VISIBLE);
                }
            }
        });

        relativeTalkshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (catTalkshow.getVisibility() == View.VISIBLE) {
                    catTalkshow.setVisibility(View.INVISIBLE);
                } else {
                    catTalkshow.setVisibility(View.VISIBLE);
                }
            }
        });

        relativeWorkshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (catWorkshop.getVisibility() == View.VISIBLE) {
                    catWorkshop.setVisibility(View.INVISIBLE);
                } else {
                    catWorkshop.setVisibility(View.VISIBLE);
                }
            }
        });

        relativeContest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (catContest.getVisibility() == View.VISIBLE) {
                    catContest.setVisibility(View.INVISIBLE);
                } else {
                    catContest.setVisibility(View.VISIBLE);
                }
            }
        });

        relativeConcert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (catConcert.getVisibility() == View.VISIBLE) {
                    catConcert.setVisibility(View.INVISIBLE);
                } else {
                    catConcert.setVisibility(View.VISIBLE);
                }
            }
        });

        relativeFestival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (catFestival.getVisibility() == View.VISIBLE) {
                    catFestival.setVisibility(View.INVISIBLE);
                } else {
                    catFestival.setVisibility(View.VISIBLE);
                }
            }
        });

        relativeExhibition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (catExhibition.getVisibility() == View.VISIBLE) {
                    catExhibition.setVisibility(View.INVISIBLE);
                } else {
                    catExhibition.setVisibility(View.VISIBLE);
                }
            }
        });

        relativeCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (catCommunity.getVisibility() == View.VISIBLE) {
                    catCommunity.setVisibility(View.INVISIBLE);
                } else {
                    catCommunity.setVisibility(View.VISIBLE);
                }
            }
        });

        relativeReligion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (catReligion.getVisibility() == View.VISIBLE) {
                    catReligion.setVisibility(View.INVISIBLE);
                } else {
                    catReligion.setVisibility(View.VISIBLE);
                }
            }
        });

        relativeSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (catSocial.getVisibility() == View.VISIBLE) {
                    catSocial.setVisibility(View.INVISIBLE);
                } else {
                    catSocial.setVisibility(View.VISIBLE);
                }
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
