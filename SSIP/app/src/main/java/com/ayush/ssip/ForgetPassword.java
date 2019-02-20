package com.ayush.ssip;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {

    TextView loginText;
    Button mSendButton;
    EditText emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        loginText = findViewById(R.id.forgotPasswordLogin);
        emailText = findViewById(R.id.forgotPasswordEmail);
        mSendButton = findViewById(R.id.forgotPasswordButton);
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgetPassword.this,SignIn.class));
                finish();
            }
        });
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(TextUtils.isEmpty(emailText.getText().toString())){
                   Toast.makeText(ForgetPassword.this,"Please enter a valid email address",Toast.LENGTH_SHORT).show();
               }else{
                   FirebaseAuth.getInstance().sendPasswordResetEmail(emailText.getText().toString())
                           .addOnCompleteListener(new OnCompleteListener<Void>() {
                               @Override
                               public void onComplete(@NonNull Task<Void> task) {
                                   startActivity(new Intent(ForgetPassword.this,SignIn.class));
                                   finish();
                               }
                           });

               }
            }
        });
    }
}
