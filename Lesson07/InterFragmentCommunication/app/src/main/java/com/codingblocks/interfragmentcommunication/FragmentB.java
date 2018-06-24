package com.codingblocks.interfragmentcommunication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentB extends Fragment {


    public static FragmentB newFragment(String name) {
        FragmentB fragment = new FragmentB();

        Bundle args = new Bundle();
        args.putString("KEY",name);

        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        Bundle bundle = getArguments();

        String name = bundle.getString("KEY");

        TextView textView = view.findViewById(R.id.tvFragB);

        textView.setText(name);
        return view;
    }
}
