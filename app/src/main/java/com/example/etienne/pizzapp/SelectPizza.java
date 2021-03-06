package com.example.etienne.pizzapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
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
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
                i = new Intent(this, SettingsActivity.class);
                startActivity(i);
                return true;
            case R.id.action_checkout:
                i = new Intent(this, ConfirmOrder.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_select_pizza, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
