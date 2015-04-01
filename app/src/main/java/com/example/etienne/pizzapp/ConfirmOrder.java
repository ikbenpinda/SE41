package com.example.etienne.pizzapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ConfirmOrder extends ActionBarActivity {

    ArrayList<String> selectedPizzas = new ArrayList<String>();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent i = new Intent(this, SettingsActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

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

                Context context = getApplicationContext();
                CharSequence text = "pizza toegevoegd!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_confirm_order, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
