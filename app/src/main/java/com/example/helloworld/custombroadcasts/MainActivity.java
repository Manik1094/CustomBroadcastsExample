package com.example.helloworld.custombroadcasts;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String CUSTOM_BROADCAST_ACTION = "com.example.helloworld.custombroadcasts.CUSTOM_BROADCAST";
    Button normal_br , ordered_br , local_br;
    FirstCustomBroadcastReceiver receiver1 = new FirstCustomBroadcastReceiver();
    SecondCustomBroadcastReceiver receiver2 = new SecondCustomBroadcastReceiver();
    LocalBroadcast receiver3 = new LocalBroadcast();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        normal_br = findViewById(R.id.normal_br);
        ordered_br = findViewById(R.id.ordered_br);
        local_br = findViewById(R.id.local_br);

        local_br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CUSTOM_BROADCAST_ACTION);
                LocalBroadcastManager.getInstance(MainActivity.this).sendBroadcast(intent);
            }
        });

        normal_br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(CUSTOM_BROADCAST_ACTION);
                sendBroadcast(intent);
            }
        });

        ordered_br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(CUSTOM_BROADCAST_ACTION);
                sendOrderedBroadcast(intent,null);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        MainActivity.this.registerReceiver(receiver1,new IntentFilter(CUSTOM_BROADCAST_ACTION));
        MainActivity.this.registerReceiver(receiver2,new IntentFilter(CUSTOM_BROADCAST_ACTION));

        LocalBroadcastManager.getInstance(this)
                .registerReceiver(receiver3,
                        new IntentFilter(CUSTOM_BROADCAST_ACTION));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MainActivity.this.unregisterReceiver(receiver1);
        MainActivity.this.unregisterReceiver(receiver2);
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(receiver3);

    }
}
