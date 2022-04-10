package com.example.application_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class pro5 extends AppCompatActivity {


    Button bouton2;
    RadioGroup rg;
    RadioButton rb;
    int score ;
    String correctanswer = "protected";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        bouton2 = findViewById(R.id.next_pro5);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro5);
        rg = findViewById(R.id.rgpro5);
        bouton2 = findViewById(R.id.next_pro5);
        Intent intet = getIntent(); //recuperer l intent
        score = intet.getIntExtra("score", 0);
        bouton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rg.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Cochez une valeur", Toast.LENGTH_SHORT).show();
                } else {
                    rb = findViewById(rg.getCheckedRadioButtonId());
                    if (rb.getText().toString().equals(correctanswer)) {
                        score =score+1;
                    }

                    Intent intent = new Intent(pro5.this, score.class).putExtra("score", score);
                    startActivity(intent);
                }


            }
        });
    }
}