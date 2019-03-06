package com.push.jogger;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.huawei.hms.support.api.push.PushReceiver;

import java.io.UnsupportedEncodingException;

public class HuaweiPushRevicer extends PushReceiver {
    private static final String TAG = "HuaweiPushRevicer";

    @Override
    public void onToken(Context context, String token) {
        super.onToken(context, token);
        Log.e(TAG, "-----------onToken" + token);
    }

    @Override
    public void onEvent(Context context, Event event, Bundle extras) {
        super.onEvent(context, event, extras);
        Log.e(TAG, "-----------onEvent");
    }

    @Override
    public boolean onPushMsg(Context context, byte[] msg, Bundle bundle) {
        //开发者自行实现透传消息处理。
        String content = null;
        try {
            content = new String(msg, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "-----------onPushMsg"+content);
        return super.onPushMsg(context, msg, bundle);
    }
}
