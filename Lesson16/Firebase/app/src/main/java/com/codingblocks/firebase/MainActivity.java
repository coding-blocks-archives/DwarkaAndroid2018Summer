package com.codingblocks.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSubmit = findViewById(R.id.btnSubmit);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.
                getInstance();

        final DatabaseReference rootRef = firebaseDatabase.getReference();

        final DatabaseReference childRef = rootRef.child("abcd");
        final EditText etName = findViewById(R.id.etName);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString();

                Task task = new Task(System.currentTimeMillis(),name, "Test");

                //Calling push() will create a random key for us
                childRef.push().setValue(task);

                //Push the content of EditText to my Firebase DB

            }
        });

    }
}
