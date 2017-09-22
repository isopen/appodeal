package com.appodeal.support.test;

import android.app.Activity;
import android.os.CountDownTimer;
import android.util.Log;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.BannerCallbacks;

class AppodealBannerCallbacks implements BannerCallbacks {

    private final Activity mActivity;

    AppodealBannerCallbacks(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void onBannerLoaded(int i, boolean b) {
        Log.d("Appodeal", "onBannerLoaded");
    }

    @Override
    public void onBannerFailedToLoad() {
        Log.d("Appodeal", "onBannerFailedToLoad");
    }

    @Override
    public void onBannerShown() {
        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long ms) {
            }

            @Override
            public void onFinish() {
                Appodeal.hide(mActivity, Appodeal.BANNER_TOP);
            }
        }.start();
        Log.d("Appodeal", "onBannerShown");
    }

    @Override
    public void onBannerClicked() {
        Log.d("Appodeal", "onBannerClicked");
    }
}
