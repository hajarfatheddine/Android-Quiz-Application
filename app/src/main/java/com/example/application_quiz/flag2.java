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

public class flag2 extends AppCompatActivity {

    Button bouton2;
    RadioGroup rg;
    RadioButton rb;
    int score ;
    String correctanswer = "Mexique";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bouton2 = findViewById(R.id.next_flag2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag2);
        rg = findViewById(R.id.rgflag2);

        bouton2 = findViewById(R.id.next_flag2);
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

                    Intent intent = new Intent(flag2.this, flag3.class).putExtra("score", score);
                    startActivity(intent);
                }


            }
        });
    }
 /*   private void startTimer(TextView textView, RadioGroup rg){
        CountDownTimer timer = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Used for formatting digit to be in 2 digits only
                NumberFormat f = new DecimalFormat("00");
                long hour = (millisUntilFinished / 3600000) % 24;
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                textView.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
            }
            // When the task is over it will print 00:00:00 there
            public void onFinish() {
                textView.setText("00:00:00");
                rg.setEnabled(false);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(flag2.this, flag3.class);
                startActivity(intent);
            }
        }.start();


    }*/

}