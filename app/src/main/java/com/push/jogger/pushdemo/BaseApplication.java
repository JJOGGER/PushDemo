package com.push.jogger.pushdemo;


import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.huawei.android.hms.agent.HMSAgent;

public class BaseApplication extends MultiDexApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        HMSAgent.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
