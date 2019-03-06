package com.push.jogger.pushdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.huawei.android.hms.agent.HMSAgent;
import com.huawei.android.hms.agent.common.handler.ConnectHandler;
import com.huawei.android.hms.agent.push.handler.EnableReceiveNotifyMsgHandler;
import com.huawei.android.hms.agent.push.handler.GetTokenHandler;
import com.huawei.hms.support.api.push.TokenResult;
import com.huawei.hmsagent.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HMSAgent.connect(this, new ConnectHandler() {
            @Override
            public void onConnect(int rst) {
                Log.e(TAG, "----HMS connect end:" + rst);
            }
        });
        HMSAgent.Push.enableReceiveNotifyMsg(true, new EnableReceiveNotifyMsgHandler() {
            @Override
            public void onResult(int rst) {
            }
        });
        getToken();
    }

    /**
     * 获取token
     */
    private void getToken() {
        HMSAgent.Push.getToken(new GetTokenHandler() {

            @Override
            public void onResult(int rst) {
                Log.e(TAG, "-------onResult" + rst);
            }

        });
    }
}
