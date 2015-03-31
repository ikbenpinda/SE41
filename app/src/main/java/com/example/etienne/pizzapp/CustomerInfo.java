package com.example.etienne.pizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.example.etienne.pizzapp.InsertPaymentInfo;
import com.example.etienne.pizzapp.ProcessingPaymentActivity;
import com.example.etienne.pizzapp.R;

/**
 * Created by Sasa2905 on 3/31/2015.
 */
public class CustomerInfo extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        Button btnConfirm = (Button)findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent creditcardIntent = new Intent(v.getContext(), InsertPaymentInfo.class);
                creditcardIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                v.getContext().startActivity(creditcardIntent);
            }
        });
    }
}
