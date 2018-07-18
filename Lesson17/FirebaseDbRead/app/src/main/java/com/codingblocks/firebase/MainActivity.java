package com.codingblocks.firebase;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements ChildEventListener {

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

//        childRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
////                DataSnapshot childSnapshot = dataSnapshot.child("abcd");
//
//                Iterable<DataSnapshot> dataSnapshots = dataSnapshot.getChildren();
//
//                for (DataSnapshot ds : dataSnapshots) {
//                    //ds refers to the current datasnapshot child
//                    Task currentTask = ds.getValue(Task.class);
//                    Log.e("TAG", "onDataChange: " + currentTask.getTitle());
//                }
                //Make a check to see if the user has purchased the pro plan or not
                //If he has, then do nothing, else remove the value event listener
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Log.e("TAG", "onCancelled: " + databaseError.getDetails());
//            }
//        });


        childRef.addChildEventListener(this);

//        childRef.removeEventListener(this);

        //ChildEventListener : Called with the child which was changed/added/removed
        //ValueEventListener : Called with the entire database when something was changed/added/removed
        //ListenerForSingleValueEvent : Called with the entire database only once (not realtime)

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString();

                Task task = new Task(System.currentTimeMillis(), name, "Test");

                //Calling push() will create a random key for us

//                DatabaseReference pushRef = childRef.push();

//                childRef.child("dfjdhdhjfh");

                com.google.android.gms.tasks.Task<Void> asyncTask = childRef.push().setValue(task);

                asyncTask.addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //The data push was completed successfully
                    }
                }).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull com.google.android.gms.tasks.Task<Void> task) {
                        //This will always be called, similar to the `finally` block in java
                    }
                });

                //Push the content of EditText to my Firebase DB

            }
        });

    }

    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        Task myTask = dataSnapshot.getValue(Task.class);
        Log.e("TAG", "onChildAdded: " + myTask.getTitle() );
    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
