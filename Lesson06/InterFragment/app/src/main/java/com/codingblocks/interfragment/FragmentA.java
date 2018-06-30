package com.codingblocks.interfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentA extends Fragment {

    ArrayList<String> stringArrayList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stringArrayList.add("a");
        stringArrayList.add("b");
        stringArrayList.add("c");
        stringArrayList.add("d");
        stringArrayList.add("e");
        stringArrayList.add("f");
        stringArrayList.add("g");
        stringArrayList.add("h");
        stringArrayList.add("i");
        stringArrayList.add("j");
        stringArrayList.add("k");
        stringArrayList.add("l");
        stringArrayList.add("m");
        stringArrayList.add("n");
        stringArrayList.add("o");
        stringArrayList.add("p");
        stringArrayList.add("q");
        stringArrayList.add("j");
        stringArrayList.add("k");
        stringArrayList.add("l");
        stringArrayList.add("m");
        stringArrayList.add("n");
        stringArrayList.add("o");
        stringArrayList.add("p");
        stringArrayList.add("q");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);

        RecyclerView recyclerView = view.findViewById(R.id.rvNotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        Communicator cm = (Communicator) getActivity();

        MyAdapter myAdapter = new MyAdapter(getContext(),stringArrayList,cm);

        recyclerView.setAdapter(myAdapter);

        return view;
    }
}
