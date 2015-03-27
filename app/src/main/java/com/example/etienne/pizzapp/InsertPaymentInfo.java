package com.example.etienne.pizzapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class InsertPaymentInfo extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_payment_info);

        Button creditcardButton = (Button)findViewById(R.id.creditcardButton);
        final Button idealButton = (Button)findViewById(R.id.idealButton);
        Button cashButton = (Button)findViewById(R.id.cashButton);

        creditcardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent creditcardIntent = new Intent(v.getContext(), ProcessingPaymentActivity.class);
                creditcardIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                v.getContext().startActivity(creditcardIntent);
            }
        });

        idealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent idealIntent = new Intent(v.getContext(), ProcessingPaymentActivity.class);
                idealIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                v.getContext().startActivity(idealIntent);
            }
        });

        cashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cashIntent = new Intent(v.getContext(), OrderCompletedActivity.class);
                cashIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                v.getContext().startActivity(cashIntent);
            }
        });
    }
}
