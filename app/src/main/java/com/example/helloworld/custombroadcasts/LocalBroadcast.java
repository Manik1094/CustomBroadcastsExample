package com.example.helloworld.custombroadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class LocalBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        if(MainActivity.CUSTOM_BROADCAST_ACTION.equals(action)){
            Log.e("LocalBroadcast" , "LocalBroadcast receive");
            Toast.makeText(context, "LocalBroadcast Receive", Toast.LENGTH_SHORT).show();
        }
    }
}
