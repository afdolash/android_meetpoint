package com.codesch.afdolash.meetpoint.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ViewSwitcher;

import com.codesch.afdolash.meetpoint.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.Transition;

public class RegisterActivity extends AppCompatActivity implements KenBurnsView.TransitionListener {

    private ViewSwitcher mViewSwitcher;
    private KenBurnsView kbvImage1;
    private KenBurnsView kbvImage2;
    private CardView cardRegister, cardLogin;

    private static final int TRANSITIONS_TO_SWITCH = 3;
    private int mTransitionsCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        changeStatusBarColor();

        mViewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
        kbvImage1 = (KenBurnsView) findViewById(R.id.kbv_image1);
        kbvImage2 = (KenBurnsView) findViewById(R.id.kbv_image2);
        cardLogin = (CardView) findViewById(R.id.card_login);

        kbvImage1.setTransitionListener(this);
        kbvImage2.setTransitionListener(this);

        cardLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
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

    @Override
    public void onTransitionStart(Transition transition) {

    }

    @Override
    public void onTransitionEnd(Transition transition) {
        mTransitionsCount++;

        if (mTransitionsCount == TRANSITIONS_TO_SWITCH) {
            mViewSwitcher.showNext();
            mTransitionsCount = 0;
        }
    }
}
