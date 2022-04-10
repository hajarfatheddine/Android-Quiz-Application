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

public class flag4 extends AppCompatActivity {

    Button bouton1;
    RadioGroup rg;
    RadioButton rb;
    int score;
    String correctanswer = "Thailande";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bouton1 = findViewById(R.id.next_flag4);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag4);
        rg = findViewById(R.id.rgflag4);
        bouton1 = findViewById(R.id.next_flag4);
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

                    Intent intent = new Intent(flag4.this, flag5.class).putExtra("score", score);
                    startActivity(intent);
                }


            }
        });
    }

}