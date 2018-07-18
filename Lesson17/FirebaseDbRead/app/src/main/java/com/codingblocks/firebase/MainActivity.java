package com.codingblocks.firebase;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ChildEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


//        childRef.removeEventListener(this);

        //ChildEventListener : Called with the child which was changed/added/removed
        //ValueEventListener : Called with the entire database when something was changed/added/removed
        //ListenerForSingleValueEvent : Called with the entire database only once (not realtime)
    }

    @Override
    protected void onStart() {
        super.onStart();

        final Button btnSubmit = findViewById(R.id.btnSubmit);

        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.
                getInstance();

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                // This is called in 3 scenarious :
                // 1. As soon as you attach the listener
                // 2. When the user logs in
                // 3. When the user logs out

                //Check to see if the user is logged in?
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

                if (firebaseUser == null) {
                    //An unauthenticated user is using the app
                    //Log the user in
                    //Use this to sign the user out
//                    AuthUI.getInstance().signOut(getBaseContext());
                    Intent loginIntent = AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setIsSmartLockEnabled(false)
                            .setAvailableProviders(Arrays.asList(
                                    new AuthUI.IdpConfig.GoogleBuilder().build(),
//                                    new AuthUI.IdpConfig.FacebookBuilder().build(),
//                                    new AuthUI.IdpConfig.TwitterBuilder().build(),
//                                    new AuthUI.IdpConfig.GitHubBuilder().build(),
                                    new AuthUI.IdpConfig.EmailBuilder().build(),
                                    new AuthUI.IdpConfig.PhoneBuilder().build())
                            )
                            .build();
                    startActivity(loginIntent);
                } else {


                    final DatabaseReference rootRef = firebaseDatabase.getReference();

                    final DatabaseReference childRef = rootRef.child(firebaseUser.getUid());
                    final EditText etName = findViewById(R.id.etName);
                    childRef.addChildEventListener(MainActivity.this);
                    //An authenticated user is using the app
                    btnSubmit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String name = etName.getText().toString();
                            Task task = new Task(System.currentTimeMillis(), name, "Test");

                            //Calling push() will create a random key for us

//                DatabaseReference pushRef = childRef.push();

//                childRef.child("dfjdhdhjfh");

//                            com.google.android.gms.tasks.Task<Void> asyncTask;

                            childRef.push().setValue(task);
//                            asyncTask.addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void aVoid) {
//                                    //The data push was completed successfully
//                                }
//                            }).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull com.google.android.gms.tasks.Task<Void> task) {
//                                    //This will always be called, similar to the `finally` block in java
//                                }
//                            });

                            //Push the content of EditText to my Firebase DB
                        }
                    });
                }

            }
        });


    }

    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        Task myTask = dataSnapshot.getValue(Task.class);
        Log.e("TAG", "onChildAdded: " + myTask.getTitle());
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
