package com.codingblocks.todoapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HeterogeneousAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    @Override
    public int getItemViewType(int position) {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder2 extends RecyclerView.ViewHolder{
        TextView row2;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            row2 = itemView.findViewById(R.id.tvRow2);
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder{
        TextView row1;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            row1 = itemView.findViewById(R.id.tvRow1);
        }
    }

}
