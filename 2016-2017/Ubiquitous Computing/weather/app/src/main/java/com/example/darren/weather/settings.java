package com.example.darren.weather;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class settings extends AppCompatActivity {
    EditText daysForecast,rainThreshold;
    Spinner cityPick;
    Button save, cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        cityPick = (Spinner) findViewById(R.id.city);
        daysForecast = (EditText) findViewById(R.id.daysForecast);
        rainThreshold = (EditText) findViewById(R.id.rainThreshold);

        save = (Button) findViewById(R.id.save);
        cancel = (Button) findViewById(R.id.cancel);

        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root+"/weather");
        String fileName = "userData.txt";
        File file = new File(myDir,fileName);
        StringBuilder text = new StringBuilder();
        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                int count = 0;
                String city=null;
                while ((line = br.readLine()) != null) {
                    text.append(line);
                    text.append("\n");
                    if (count == 0) {
                        city = line;
                    } else if (count == 1) {
                        daysForecast.setText(line);
                    } else {
                        rainThreshold.setText(line);
                    }
                    count++;
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Please make sure you have set up your settings", Toast.LENGTH_SHORT).show();
        }

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go back to main activity
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean isDayNotEmpty,isRainNotEmpty;
                String city,day,rain;
                city = cityPick.getSelectedItem().toString();
                day = daysForecast.getText().toString();
                rain = rainThreshold.getText().toString();
                if (day.isEmpty()){
                    daysForecast.setError("You need to fill this in.");
                    isDayNotEmpty=false;
                } else{
                    int days = Integer.parseInt(day);
                    if (days==1 || days==2 || days==3 || days==4|| days==5 || days==6 || days==7 || days==8 || days==9 || days==10 || days==11 || days==12 || days==13 || days==14 || days==15 || days==16)
                    {
                        isDayNotEmpty=true;
                    } else {
                        isDayNotEmpty=false;
                        daysForecast.setError("You need to put in 1 to 16.");
                    }
                }
                if (rain.isEmpty()){
                    rainThreshold.setError("You need to fill this in.");
                    isRainNotEmpty=false;
                } else{
                    isRainNotEmpty=true;
                }
                if (isDayNotEmpty&&isRainNotEmpty){
                    String root = Environment.getExternalStorageDirectory().toString();
                    File myDir = new File(root+"/weather");
                    myDir.mkdir();
                    String fileName = "userData.txt";
                    File file = new File(myDir,fileName);
                    if (file.exists()){
                        file.delete();
                    }
                    try {
                        FileWriter writer = new FileWriter(file);
                        writer.append(city);
                        writer.append("\n");
                        writer.append(day);
                        writer.append("\n");
                        writer.append(rain);
                        writer.flush();
                        writer.close();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
//**********************************
                    starMyService();

 //*********************************
                    finish();
                }
            }
        });
    }
    public void starMyService()
    {
        Intent intent = new Intent(this, MyService.class);
        //intent.setAction("com.example.darren.weather.MyService");
        startService(intent);
    }
}
