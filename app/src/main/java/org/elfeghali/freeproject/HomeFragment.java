package org.elfeghali.freeproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();

        String about_wooters = "From woods to waters, and everything in between, this is a home to explorers, " +
                "adventurers and nature lovers to discover new places in Lebanon and share tips, " +
                "tricks and reviews on their previous trips.";
        TextView textView = view.findViewById(R.id.about_text_view);
        textView.setText(about_wooters);

        Button waters_button = view.findViewById(R.id.waters_button);
        Button woods_button = view.findViewById(R.id.woods_button);

        waters_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent waters_intent = new Intent(getContext(), WatersActivity.class);
                startActivity(waters_intent);
            }
        });

        woods_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent woods_intent = new Intent(getContext(), WoodsActivity.class);
                startActivity(woods_intent);
            }
        });
    }
}