package com.example.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LoginViewActivity extends BaseActivity {
    private Button forceOffline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);
        forceOffline = (Button) findViewById(R.id.force_offline);
        forceOffline.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.FORCE_OFFLINE");
                        sendBroadcast(intent);
                        Log.d("TEST1","SENDBROADCAST");
                    }
                }
        );
    }
}
