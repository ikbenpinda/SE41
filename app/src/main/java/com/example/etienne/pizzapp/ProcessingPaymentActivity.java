package com.example.etienne.pizzapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;


public class ProcessingPaymentActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processing_payment);

        Timer timer = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                Intent completeIntent = new Intent(findViewById(R.id.processingLabel).getContext(), OrderCompletedActivity.class);
                findViewById(R.id.processingLabel).getContext().startActivity(completeIntent);
            }
        };

        timer.schedule(tt, 2000);
    }
}
