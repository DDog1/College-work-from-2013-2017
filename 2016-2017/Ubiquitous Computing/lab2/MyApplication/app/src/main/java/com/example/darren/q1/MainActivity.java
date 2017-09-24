package com.example.darren.q1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText username,password,phoneNumber,email;
    TextView userText, passText,phoneText,emailText;
    boolean validate = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submit);
        //Inputs
        username = (EditText) findViewById(R.id.userInput);
        password = (EditText) findViewById(R.id.passInput);
        phoneNumber = (EditText) findViewById(R.id.phoneInput);
        email = (EditText) findViewById(R.id.emailInput);
        //Text
        userText = (TextView) findViewById(R.id.username);
        passText = (TextView) findViewById(R.id.password);
        phoneText = (TextView) findViewById(R.id.phoneNumber);
        emailText = (TextView) findViewById(R.id.email);

        submit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                boolean userPass = false, passwordPass = false, phonePass = false, emailPass = false;

                String eMail = email.getText().toString();
                String number = phoneNumber.getText().toString();
                String userName = username.getText().toString();
                String passWord = password.getText().toString();

                if (userName.isEmpty()) {
                    username.setError("Username can't be blank");
                } else if (userName.contains("0") || userName.contains("1") || userName.contains("2") || userName.contains("3") || userName.contains("4") || userName.contains("5") || userName.contains("6") || userName.contains("7") || userName.contains("8") || userName.contains("9") || userName.contains("#") || userName.contains("*")) {
                    username.setError("Username can't have a number or #,*");
                    userPass = false;
                } else {
                    userPass = true;
                }

                if (passWord.isEmpty()) {
                    password.setError("Password can't be blank");
                    passwordPass = false;
                } else {
                    passwordPass = true;
                }

                if (number.contains("#") || number.contains("*") || number.isEmpty()) {
                    phoneNumber.setError("Phone number can't be blank or have #,* in it");
                    phonePass = false;
                } else {
                    phonePass = true;
                }

                if (eMail.contains("@") && eMail.contains(".com")) {
                    if (eMail.contains("gmail") || eMail.contains("hotmail")) {
                        emailPass = true;
                    } else {
                        email.setError("email can't be blank and needs to be hotmail or gmail");
                        emailPass = false;
                    }
                } else {
                    email.setError("email missing ' or .com");

                }

                if (emailPass && phonePass && userPass && passwordPass) {
                    validate = true;
                } else {
                    validate = false;
                }

                if (validate == true) {
                    sendIntent(userName);
                    //Toast.makeText(getApplicationContext(),"Thank you, your request is being processed", Toast.LENGTH_SHORT).show();
                } else {
                    validate = false;
                }
            }
        });
    }

        public void sendIntent(String userName)
        {
            String key="formComplete", value="Thank you "+userName+", your request is being processed";

            Intent sendIntent = new Intent(this,Main2Activity.class);
            sendIntent.putExtra(key,value);
            startActivity(sendIntent);
        }

}
