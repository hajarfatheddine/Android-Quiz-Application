package com.example.application_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.lzyzsd.circleprogress.DonutProgress;
import com.google.firebase.auth.FirebaseAuth;

public class score extends AppCompatActivity {
    Button logut;
    Button trya;
    DonutProgress p;
    int score;
    FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        trya = findViewById(R.id.button);
        logut = findViewById(R.id.button2);
        p = findViewById(R.id.donut_progress);
        Intent i = getIntent();
        score = ((Intent) i).getIntExtra("score", 0);
        mauth = FirebaseAuth.getInstance();

        p.setDonut_progress(String.valueOf(score*100/5));
        trya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(score.this, MainActivity3.class);
                startActivity(int2);
            }
        });
        logut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mauth.signOut();
                Intent int2 = new Intent(score.this, MainActivity.class);
                startActivity(int2);

            }


        });
    }
}