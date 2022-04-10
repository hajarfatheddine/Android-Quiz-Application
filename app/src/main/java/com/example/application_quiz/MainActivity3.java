package com.example.application_quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    CardView quiz1;
    CardView quiz2;
    CardView quiz3;
    CardView quiz4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        quiz1=findViewById(R.id.start_quiz1);
        quiz2=findViewById(R.id.start_quiz2);
        quiz3=findViewById(R.id.start_quiz3);
        quiz4=findViewById(R.id.start_quiz4);

        quiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(new Intent(MainActivity3.this, quiz1.class));
                }
        });
        quiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity3.this, GEOquiz1.class));
            }
        });
        quiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity3.this, flag1.class));
            }
        });
        quiz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity3.this, pro1.class));
            }
        });

    }
}