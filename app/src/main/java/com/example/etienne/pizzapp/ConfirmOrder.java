package com.example.etienne.pizzapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class ConfirmOrder extends ActionBarActivity {

    ArrayList<String> selectedPizzas = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        if(!this.getIntent().getStringArrayListExtra("selectedPizzas").isEmpty())
        {
            selectedPizzas = this.getIntent().getStringArrayListExtra("selectedPizzas");
        }

        ListView lv = (ListView)findViewById(R.id.pizzasListView);
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
                addIntent.putExtra("selectedPizzas", selectedPizzas);
                v.getContext().startActivity(addIntent);
            }
        });
    }
}
