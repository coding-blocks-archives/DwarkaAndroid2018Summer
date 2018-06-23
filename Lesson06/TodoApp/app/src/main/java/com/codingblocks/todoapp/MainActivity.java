package com.codingblocks.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Note> notesArrayList = new ArrayList<>();
    Button addBtn;
    EditText noteEt;
    RecyclerView notesRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBtn = findViewById(R.id.addBtn);
        noteEt = findViewById(R.id.etNote);
        notesRv = findViewById(R.id.notesRv);
        final NoteAdapter noteAdapter = new NoteAdapter(notesArrayList,this);
        notesRv.setLayoutManager(new LinearLayoutManager(this));
        notesRv.setAdapter(noteAdapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredNote = noteEt.getText().toString();
                noteEt.setText("");
                Note note = new Note(enteredNote);
                notesArrayList.add(note);
                noteAdapter.notifyDataSetChanged();
            }
        });

    }
}
