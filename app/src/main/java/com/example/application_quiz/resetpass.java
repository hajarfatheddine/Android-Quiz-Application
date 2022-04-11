package com.example.application_quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class resetpass extends AppCompatActivity {

    EditText email_reset;
    Button useremail;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpass);
        email_reset=findViewById(R.id.resetemail);
        useremail=findViewById(R.id.submitreset);
        auth =FirebaseAuth.getInstance();

        useremail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.sendPasswordResetEmail(email_reset.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(resetpass.this, "Password sent, Please check your email", Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(resetpass.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
    }
}