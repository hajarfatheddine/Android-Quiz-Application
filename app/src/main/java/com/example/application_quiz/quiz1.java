package com.example.application_quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

public class quiz1 extends AppCompatActivity {
    //définir un bouton qui va recevoir lid du bouton next
    Button bouton1;
    RadioGroup rg;
    RadioButton rb;
    int score = 0;
    String correctanswer = "Oui";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        rg = findViewById(R.id.radioGroup);
        bouton1 = findViewById(R.id.next_quiz1);
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

                    Intent intent = new Intent(quiz1.this, quiz2.class).putExtra("score", score);
                    startActivity(intent);
                }


            }
        });
    }
    @Override
    public void onBackPressed()
    {

        // Create the object of
        // AlertDialog Builder class
        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(quiz1.this);

        // Set the message show for the Alert time
        builder.setMessage("are you sure you want to exit");

        // Set Alert Title
        builder.setTitle("EXIT");

        // Set Cancelable false
        // for when the user clicks on the outside
        // the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name
        // OnClickListener method is use of
        // DialogInterface interface.

        builder
                .setPositiveButton(
                        "Yes",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                                    //which est l'identifiant du bouton negative
                            {

                                // When the user click yes button
                                // then app will close
                                Intent intent = new Intent(quiz1.this, MainActivity3.class);
                                startActivity(intent);
                                finish();
                            }
                        });

        // Set the Negative button with No name
        // OnClickListener method is use
        // of DialogInterface interface.
        builder
                .setNegativeButton(
                        "No",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // If user click no
                                // then dialog box is canceled.
                                dialog.cancel();
                            }
                        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();

        // Show the Alert Dialog box
        alertDialog.show();
    }

}