package com.codingblocks.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MyStudentAdapter extends RecyclerView.Adapter<MyStudentAdapter.MyViewHolder> {

    private ArrayList<Student> studentArrayList;
    private Context context;

    public MyStudentAdapter(ArrayList<Student> students, Context ctx) {
        studentArrayList = students;
        context = ctx;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutInflater lif = LayoutInflater.from(context);
        View inflatedView = lif.inflate(R.layout.item_row,parent,false);
        return new MyViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Student currentStudent = studentArrayList.get(position);
        holder.name.setText(currentStudent.getName());
        holder.location.setText(currentStudent.getLocation());
        holder.batch.setText(currentStudent.getBatch());
        holder.number.setText(currentStudent.getNumber());
    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,number,batch,location;
        Button btn;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.studentName);
            number = itemView.findViewById(R.id.studentNumber);
            batch = itemView.findViewById(R.id.studentBatch);
            location = itemView.findViewById(R.id.studentLocation);
            btn = itemView.findViewById(R.id.idBtn);
        }
    }

}
