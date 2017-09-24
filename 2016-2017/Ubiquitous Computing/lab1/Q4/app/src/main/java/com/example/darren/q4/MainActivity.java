package com.example.darren.q4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    TextView scoreView;
    int score=0;
    int min=1,max=10;
    Random r = new Random();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        int temp = r.nextInt(max-min)+min;
        btn1.setText(""+temp);
        temp = r.nextInt(max-min)+min;
        btn2.setText(""+temp);
        scoreView=(TextView)findViewById(R.id.scoreView);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                int temp;
                String btn1Value=btn1.getText().toString();
                String btn2Value=btn2.getText().toString();

                int btn1Number = Integer.parseInt(btn1Value);
                int btn2Number = Integer.parseInt(btn2Value);

                if(btn1Number>=btn2Number)
                {
                    score++;
                    scoreView.setText("Score : "+score);
                }
                else
                {
                    scoreView.setText("Score : "+score+" No good!! >:)");
                }

                temp = r.nextInt(max-min)+min;
                btn1.setText(""+temp);

                temp = r.nextInt(max-min)+min;
                btn2.setText(""+temp);
                if(btn1Number==btn2Number)
                {
                    do {
                        temp = r.nextInt(max-min)+min;
                        btn2.setText(""+temp);
                    } while (btn1Number!=btn2Number);
                }

                /*int btn1Value = r.nextInt(max-min+1)+min;

                btn1.setText(""+btn1Value);

                int btn2Value = r.nextInt(max-min+1)+min;

                if(btn2Value==btn1Value)
                {
                    do {
                        btn2Value = r.nextInt(max-min+1)+min;
                    } while (btn2Value!=btn1Value);
                    btn2.setText(""+btn2Value);
                }
                else
                {
                    btn2.setText(""+btn2Value);
                }*/
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                int temp;
                String btn1Value=btn1.getText().toString();
                String btn2Value=btn2.getText().toString();

                int btn1Number = Integer.parseInt(btn1Value);
                int btn2Number = Integer.parseInt(btn2Value);

                if(btn2Number>=btn1Number)
                {
                    score++;
                    scoreView.setText("Score : "+score);
                }
                else
                {
                    scoreView.setText("Score : "+score+" No good!! >:)");
                }

                temp = r.nextInt(max-min)+min;
                btn1.setText(""+temp);

                temp = r.nextInt(max-min)+min;
                btn2.setText(""+temp);

                if(btn2Number==btn1Number)
                {
                    do {
                        temp = r.nextInt(max-min)+min;
                        btn1.setText(""+temp);
                    } while (btn1Number!=btn2Number);
                }

                /*int btn2Value = r.nextInt(max-min+1)+min;

                btn2.setText(""+btn2Value);

                int btn1Value = r.nextInt(max-min+1)+min;

                if(btn1Value==btn2Value)
                {
                    do {
                        btn2Value = r.nextInt(max-min+1)+min;
                    } while (btn2Value!=btn2Value);
                    btn1.setText(""+btn1Value);
                }
                else
                {
                    btn1.setText(""+btn1Value);
                }
                if(btn2Value>btn1Value)
                {
                    score++;
                    scoreView.setText("Score : "+score);
                }
                else
                {
                    scoreView.setText("Score : "+score+" No good!! >:)");
                }*/
            }
        });
    }
}

