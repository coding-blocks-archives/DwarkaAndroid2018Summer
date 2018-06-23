package com.codingblocks.todoapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyHolder> {

    private ArrayList<Note> noteArrayList;
    private Context ctx;

    public NoteAdapter(ArrayList<Note> noteArrayList, Context ctx) {
        this.noteArrayList = noteArrayList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflatedView = LayoutInflater
                .from(ctx)
                .inflate(R.layout.item_row, viewGroup, false);
        return new MyHolder(inflatedView);
//        return new MyHolder(LayoutInflater
//                .from(ctx)
//                .inflate(R.layout.item_row, viewGroup, false));
    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        Note currentNote = noteArrayList.get(i);
        myHolder.noteTv.setText(currentNote.getTitle());
//        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);
        //1
//        myHolder.noteTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView noteTv;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            noteTv = itemView.findViewById(R.id.tvNote);
            //2
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //get current position
                    int pos = getAdapterPosition();
                    notifyDataSetChanged();
                }
            });
        }
    }

}
