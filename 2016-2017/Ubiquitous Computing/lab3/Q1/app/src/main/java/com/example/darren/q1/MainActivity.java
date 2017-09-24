package com.example.darren.q1;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            //Landscape mode
            System.out.println("You are in Landscape mode");
        }

        else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            //Portrait mode
            System.out.println("You are in portrait mode");
        }
        else
        {
            //Unknown error
            System.out.println("Don't know what you are doing!!");
        }
    }
}
