package com.example.application_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class pro2 extends AppCompatActivity {

    Button bouton2;
    RadioGroup rg;
    RadioButton rb;
    int score ;
    String correctanswer = "Using namespace std;";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        bouton2 = findViewById(R.id.next_pro2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro2);
        rg = findViewById(R.id.rgpro2);
        bouton2 = findViewById(R.id.next_pro2);
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

                    Intent intent = new Intent(pro2.this, pro3.class).putExtra("score", score);
                    startActivity(intent);
                }


            }
        });
    }
}