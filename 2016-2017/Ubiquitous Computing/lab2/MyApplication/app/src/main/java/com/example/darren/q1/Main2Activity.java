package com.example.darren.q1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        confirm=(TextView)findViewById(R.id.confirm);

        Intent recive = getIntent();

        String temp = (String) recive.getSerializableExtra("formComplete");

        confirm.setText(temp);
    }
}
