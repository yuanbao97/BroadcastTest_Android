package com.example.broadcasttest.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.broadcasttest.R;
import com.example.broadcasttest.receiver.NetworkChangeReceiver;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.sendBroadcastButton)
    Button sendBroadcastButton;
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

    @OnClick(R.id.sendBroadcastButton)
    public void onClick() {
        Intent intent = new Intent("com.example.broadcasttest.receiver.MY_BROADCAST");
        intent.setComponent(new ComponentName(getPackageName(), "com.example.broadcasttest.receiver.MyBroadcastReceiver"));
        intent.putExtra("myBroadcast", "hello world !");
        sendBroadcast(intent);
    }
}