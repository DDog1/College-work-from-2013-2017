package com.example.darren.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button display, settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (Button) findViewById(R.id.display);
        settings = (Button) findViewById(R.id.settings);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsIntent();
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayIntent();
            }
        });
    }

    public void settingsIntent()
    {
        String key="default", value="NOTHING";

        Intent sendIntent = new Intent(this,settings.class);
        sendIntent.putExtra(key,value);
        startActivity(sendIntent);
    }

    public void displayIntent()
    {
        String key="default", value="NOTHING";

        Intent sendIntent = new Intent(this,display.class);
        sendIntent.putExtra(key,value);
        startActivity(sendIntent);
    }

}
