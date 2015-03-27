package com.example.etienne.pizzapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class SelectPizza extends ActionBarActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_pizza);

        lv = (ListView)findViewById(R.id.listView2);
        String[] previousOrders = getResources().getStringArray(R.array.pizzas_array);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, previousOrders));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent confirmIntent = new Intent(view.getContext(), ConfirmOrder.class);
                view.getContext().startActivity(confirmIntent);
            }
        });
    }
}
