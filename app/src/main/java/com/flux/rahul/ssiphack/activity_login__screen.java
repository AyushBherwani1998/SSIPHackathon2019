package com.flux.rahul.ssiphack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuthException;

public class activity_login__screen extends AppCompatActivity {
    String emailid,password;
    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__screen);
        t1=findViewById(R.id.emailField);
        t2=findViewById(R.id.password);
        emailid=t1.getText().toString().trim();
        password=t2.getText().toString().trim();

    }
}
