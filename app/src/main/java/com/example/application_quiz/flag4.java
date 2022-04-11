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
    @Override
    public void onBackPressed()
    {

        // Create the object of
        // AlertDialog Builder class
        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(flag4.this);

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
                            {

                                // When the user click yes button
                                // then app will close
                                Intent intent = new Intent(flag4.this, MainActivity3.class);
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