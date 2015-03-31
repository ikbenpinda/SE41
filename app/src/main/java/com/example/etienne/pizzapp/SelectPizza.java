package com.example.etienne.pizzapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class SelectPizza extends ActionBarActivity {

    ListView lv;
    ArrayList<String> selectedPizzas = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_pizza);

        if(this.getIntent().getStringArrayListExtra("selectedPizzas") != null)
        {
            selectedPizzas = this.getIntent().getStringArrayListExtra("selectedPizzas");
        }

        lv = (ListView)findViewById(R.id.listView2);
        String[] previousOrders = getResources().getStringArray(R.array.pizzas_array);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, previousOrders));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedPizza = lv.getItemAtPosition(position).toString();

                Intent confirmIntent = new Intent(view.getContext(), ConfirmOrder.class);
                selectedPizzas.add(selectedPizza);
                confirmIntent.putExtra("selectedPizzas", selectedPizzas);
                view.getContext().startActivity(confirmIntent);
            }
        });
    }
}
