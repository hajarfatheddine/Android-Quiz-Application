package com.example.application_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class flag5 extends AppCompatActivity {


    Button bouton1;
    RadioGroup rg;
    RadioButton rb;
    int score;
    String correctanswer = "L'inde";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bouton1 = findViewById(R.id.next_flag5);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag5);
        rg = findViewById(R.id.rgflag5);

        bouton1 = findViewById(R.id.next_flag5);
        Intent intet = getIntent(); //recuperer l intent
        score = intet.getIntExtra("score", 0);
        bouton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rg.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Cochez une valeur", Toast.LENGTH_SHORT).show();
                } else {
                    rb = findViewById(rg.getCheckedRadioButtonId());
                    if (rb.getText().toString().equals(correctanswer)) {
                        score = score + 1;
                    }

                    Intent intent = new Intent(flag5.this, score.class).putExtra("score", score);
                    startActivity(intent);
                }


            }
        });
    }

}