package com.codingblocks.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//                //The which tells us which button was clicked
//
//                switch (which){
//                    case DialogInterface.BUTTON_POSITIVE :
//                        //Do something
//                        break;
//                    case DialogInterface.BUTTON_NEGATIVE :
//                        //Do something
//                        break;
//                }
//
//            }
//        };

        Button btnAlert = findViewById(R.id.btnAlert);
        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Hello World")
                .setCancelable(false)
                .setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,
                                "Positive clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,
                                "Negative clicked", Toast.LENGTH_SHORT).show();

                    }
                })
                .setMessage("I'm an alert dialog")
                .create();
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
            }
        });


        Button btnCustomAlert = findViewById(R.id.btnCustomAlert);

        LayoutInflater layoutInflater = LayoutInflater.from(this);

        final View view = layoutInflater.inflate(R.layout.dialog_view, null);

        final AlertDialog customAlert = new AlertDialog.Builder(this)
//                .setTitle("Post Data to Server")
                .setView(view)
                .setPositiveButton("Post", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText email = view.findViewById(R.id.etEmail);
                        EditText password = view.findViewById(R.id.etPassword);

//                        Toast.makeText(MainActivity.this, email.getText().toString() + "  " + password.getText().toString(), Toast.LENGTH_SHORT).show();
                        //Post the data to the server
                    }
                })
                .create();

        btnCustomAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customAlert.show();

            }
        });


    }
}
