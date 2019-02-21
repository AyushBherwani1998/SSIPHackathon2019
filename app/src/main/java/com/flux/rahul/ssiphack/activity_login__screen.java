package com.flux.rahul.ssiphack;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class activity_login__screen extends AppCompatActivity {
    String emailid,password;
    EditText t1,t2;
    Button b1;
    String msg;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__screen);
        t1=findViewById(R.id.emailField);
        t2=findViewById(R.id.password);
        b1=findViewById(R.id.LoginButton);
        emailid=t1.getText().toString().trim();
        password=t2.getText().toString().trim();

        mAuth=FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(activity_login__screen.this, home.class));
            finish();
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(msg,emailid);
                Log.d(msg,password);
                mAuth.signInWithEmailAndPassword(emailid, password)
                        .addOnCompleteListener(activity_login__screen.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    // there was an error
                                        Toast.makeText(activity_login__screen.this, "Not Successful", Toast.LENGTH_LONG).show();

                                } else {
                                    Intent intent = new Intent(activity_login__screen.this, home.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

            }


        });
    }

    public void signin() {



    }

}
