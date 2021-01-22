package com.example.broadcasttest.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String str = intent.getStringExtra("myBroadcast");
        Toast.makeText(context, "My Broadcast : " + str, Toast.LENGTH_SHORT).show();
    }
}