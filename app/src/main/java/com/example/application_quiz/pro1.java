package com.example.application_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class pro1 extends AppCompatActivity {

    Button bouton1;
    RadioGroup rg;
    RadioButton rb;
    int score=0;
    String correctanswer = "3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro1);
        rg = findViewById(R.id.rgpro1);
        bouton1 = findViewById(R.id.next_pro1);
        bouton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rg.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Cochez une valeur", Toast.LENGTH_SHORT).show();
                } else {
                    rb = findViewById(rg.getCheckedRadioButtonId());
                    if (rb.getText().toString().equals(correctanswer)) {
                        score =score+1;
                    }

                    Intent intent = new Intent(pro1.this, pro2.class).putExtra("score", score);
                    startActivity(intent);
                }


            }
        });
    }
}