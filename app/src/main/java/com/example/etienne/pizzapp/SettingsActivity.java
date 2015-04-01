package com.example.etienne.pizzapp;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import java.util.Locale;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.RadioGroup;
import android.widget.Toast;


public class SettingsActivity extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //set change listener
        RadioGroup rgroup = (RadioGroup) findViewById(R.id.rgrp_settings);
        rgroup.setOnCheckedChangeListener(this);

        Button button = (Button) findViewById(R.id.confirmButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Sets the language for the app.
     * @param view
     */
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.btn_lang_english:
                if (checked) // TODO: Set language to Dutch.
                {
                    RadioButton b = (RadioButton) findViewById(R.id.btn_lang_nederlands);
                    b.setChecked(false);next();
                    setLocale("nl");
                }
                break;
            case R.id.btn_lang_nederlands:
                if (checked) // TODO: Set language to English.
                {
                    RadioButton b = (RadioButton) findViewById(R.id.btn_lang_english);
                    b.setChecked(false);
                    setLocale("en-US");
                }
                break;
        }

        next();
    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

        //next();
    }

    private void next() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

        Context context = getApplicationContext();
        CharSequence text = "Instellingen opgeslagen";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        //next();
    }
}
