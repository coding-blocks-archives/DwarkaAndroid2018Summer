package com.codingblocks.heterogeneousrv;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HeterogeneousAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Object> objects;
    Context context;
    public static final int IMAGE = 0;
    public static final int NAME = 1;

    public HeterogeneousAdapter(ArrayList<Object> objects, Context context) {
        this.objects = objects;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        Object currentObject = objects.get(position);
        if (currentObject instanceof ImageUrl) {
            return IMAGE;
        } else if (currentObject instanceof Name) {
            return NAME;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = LayoutInflater.from(context);
        if (i == NAME){
            View inflatedView = li.inflate(R.layout.item_row_1,viewGroup,false);
            return new ViewHolder1(inflatedView);
        }else if (i == IMAGE){
            View inflatedView = li.inflate(R.layout.item_row_2,viewGroup,false);
            return new ViewHolder2(inflatedView);
        }
        else return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder.getItemViewType() == NAME){
            ViewHolder1 vh1= (ViewHolder1) viewHolder;
            Name currentName = (Name) objects.get(i);
            vh1.row1.setText(currentName.name);
        } else if (viewHolder.getItemViewType() == IMAGE){
            ViewHolder2 vh2 = (ViewHolder2) viewHolder;
            ImageUrl currentImage = (ImageUrl) objects.get(i);
            Picasso.get().load(currentImage.url).into(vh2.row2);
        }
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        ImageView row2;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            row2 = itemView.findViewById(R.id.ivRow2);
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        TextView row1;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            row1 = itemView.findViewById(R.id.tvRow1);
        }
    }

}
