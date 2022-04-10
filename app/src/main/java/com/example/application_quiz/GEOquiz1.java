package com.example.application_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class GEOquiz1 extends AppCompatActivity {
    Button bouton1;
    RadioGroup rg;
    RadioButton rb;
    int score = 0;
    String correctanswer = "les filandais";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geoquiz1);
        rg = findViewById(R.id.rgGeo1);
        bouton1 = findViewById(R.id.next_geo1);
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

                    Intent intent = new Intent(GEOquiz1.this, GEOquiz2.class).putExtra("score", score);
                    startActivity(intent);
                }


            }
        });
    }
}