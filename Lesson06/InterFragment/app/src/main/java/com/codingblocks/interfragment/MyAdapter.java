package com.codingblocks.interfragment;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myholder> {

    Context ctx;
    ArrayList<String> stringArrayList;
    Communicator communicator;

    public MyAdapter(Context ctx, ArrayList<String> stringArrayList, Communicator act) {
        this.communicator = act;
        this.ctx = ctx;
        this.stringArrayList = stringArrayList;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_row,viewGroup,false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder myholder, int i) {
        myholder.notesTv.setText(stringArrayList.get(i));
    }

    @Override
    public int getItemCount() {
        return stringArrayList.size();
    }

    class Myholder extends RecyclerView.ViewHolder{

        TextView notesTv;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            notesTv = itemView.findViewById(R.id.tvNote);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = stringArrayList.get(getAdapterPosition());
                    communicator.doSomething(name);
//                    act.getSupportFragmentManager().beginTransaction()
//                            .add(R.id.container,new FragmentB(stringArrayList.get(getAdapterPosition())))
//                            .commit();
                }
            });
        }
    }

}
