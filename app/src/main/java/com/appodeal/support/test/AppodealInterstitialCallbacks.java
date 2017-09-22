package com.appodeal.support.test;

import android.os.CountDownTimer;
import android.util.Log;

import com.appodeal.ads.InterstitialCallbacks;

class AppodealInterstitialCallbacks implements InterstitialCallbacks {

    private final CountDownTimer countDownTimer;

    AppodealInterstitialCallbacks(CountDownTimer timer) {
        countDownTimer = timer;
    }

    @Override
    public void onInterstitialLoaded(boolean b) {
        Log.d("Appodeal", "onInterstitialLoaded");
    }

    @Override
    public void onInterstitialFailedToLoad() {
        Log.d("Appodeal", "onInterstitialFailedToLoad");
    }

    @Override
    public void onInterstitialShown() {
        Log.d("Appodeal", "onInterstitialShown");
    }

    @Override
    public void onInterstitialClicked() {
        Log.d("Appodeal", "onInterstitialClicked");
    }

    @Override
    public void onInterstitialClosed() {
        countDownTimer.start();
        Log.d("Appodeal", "onInterstitialClosed");
    }
}
