package com.example.application_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class GEOquiz3 extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    Button bouton2;
    String correctanswer = "le Pacifique";
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bouton2 = findViewById(R.id.next_geo3);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geoquiz3);
        rg = findViewById(R.id.rgGeo3);
        bouton2 = findViewById(R.id.next_geo3);
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
                    Intent int2 = new Intent(GEOquiz3.this, GEOquiz4.class).putExtra("score",score);
                    startActivity(int2);
                }


            }
        });
    }

}