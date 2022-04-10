package com.example.application_quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    // declaration
    EditText email, password;
    Button signin;
    TextView register;
    FirebaseAuth auth;
    public int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recuperer les views par leur id
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signin = findViewById(R.id.submitButton);
        register = findViewById(R.id.register);
        auth = FirebaseAuth.getInstance();
        // ajouter un listener au button sign(event:onclick)
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please provide email and password", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent i = new Intent(MainActivity.this, MainActivity3.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
                //if(email.getText().toString().equals("test@gmail.com")
                //&& password.getText().toString().equals("test"))
                //{
                //création d'un objet de type intent(package context:first activity, second activity.class
                //  startActivity(new Intent(MainActivity.this, Quiz1Activity.class));
                //}
                //else
                //{
                //créer un objet de type toast(Toast est une classe static)
                //   Toast toast = Toast.makeText(getApplicationContext(),"Please check your email or your password", Toast.LENGTH_LONG);
                //  toast.show();
                //}
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });
    }
}
