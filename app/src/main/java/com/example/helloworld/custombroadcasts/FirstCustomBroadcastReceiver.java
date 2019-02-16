package com.example.helloworld.custombroadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class FirstCustomBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(MainActivity.CUSTOM_BROADCAST_ACTION.equals(action)){
            Log.e("TAG" , "FirstReceiver");
        }
    }
}
