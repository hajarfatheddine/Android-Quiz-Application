package com.example.application_quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
    @Override
    public void onBackPressed()
    {

        // Create the object of
        // AlertDialog Builder class
        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(pro2.this);

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
                                Intent intent = new Intent(pro2.this, MainActivity3.class);
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
    }}