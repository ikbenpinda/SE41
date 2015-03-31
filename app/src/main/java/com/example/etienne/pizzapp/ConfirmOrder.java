package com.example.etienne.pizzapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class ConfirmOrder extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        ListView lv = (ListView)findViewById(R.id.pizzasListView);
        String[] selectedPizzas = getResources().getStringArray(R.array.selectedPizzas_array);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, selectedPizzas));

        Button confirmButton = (Button)findViewById(R.id.confirmButton);
        Button addButton = (Button)findViewById(R.id.addButton);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confirmIntent = new Intent(v.getContext(), CustomerInfo.class);
                v.getContext().startActivity(confirmIntent);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent(v.getContext(), SelectPizza.class);
                v.getContext().startActivity(addIntent);
            }
        });
    }
}
