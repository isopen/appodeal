package com.appodeal.support.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;

import android.view.View;
import android.widget.TextView;

import com.appodeal.ads.Appodeal;

public class MainActivity extends Activity {

    private static final String API_KEY = "8f3441a41b73cbea914b57338fd70d602e045b7832d84326";
    private CountDownTimer interstitialTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Appodeal.initialize(this, API_KEY, Appodeal.INTERSTITIAL | Appodeal.BANNER_TOP | Appodeal.NATIVE);

        Appodeal.show(MainActivity.this, Appodeal.INTERSTITIAL);

        Appodeal.show(this, Appodeal.BANNER_TOP);
        Appodeal.setBannerCallbacks(new AppodealBannerCallbacks(this));

        final TextView interstitialTimerTextView = findViewById(R.id.interstitial_timer_text_view);

        interstitialTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long ms) {
                interstitialTimerTextView.setText(String.valueOf(ms / 1000));
            }

            @Override
            public void onFinish() {
                interstitialTimerTextView.setText(String.valueOf(30));
                Appodeal.show(MainActivity.this, Appodeal.INTERSTITIAL);
            }
        };
        interstitialTimer.start();

        findViewById(R.id.native_advertising_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interstitialTimer.cancel();
            }
        });

        Appodeal.setInterstitialCallbacks(new AppodealInterstitialCallbacks(interstitialTimer));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
