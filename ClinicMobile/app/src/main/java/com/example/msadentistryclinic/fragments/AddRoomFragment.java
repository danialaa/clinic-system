package com.example.msadentistryclinic.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.msadentistryclinic.R;
import com.example.msadentistryclinic.services.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddRoomFragment extends Fragment {
    private Button add;
    private ImageButton increaseFloor, decreaseFloor, increaseCapacity, decreaseCapacity;
    private EditText roomEdit;
    private TextView floorText, capacityText;
    private Spinner departmentSpinner;
    private List<EditText> editTextList = new ArrayList<>();

    public AddRoomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_room, container, false);

        roomEdit = view.findViewById(R.id.roomNameEdit);
        editTextList.add(roomEdit);
        departmentSpinner = view.findViewById(R.id.departmentSpinner);
        floorText = view.findViewById(R.id.floorText);
        capacityText = view.findViewById(R.id.capacityText);
        increaseFloor = view.findViewById(R.id.addFloorButton);
        decreaseFloor = view.findViewById(R.id.removeFloorButton);
        increaseCapacity = view.findViewById(R.id.addCapacityButton);
        decreaseCapacity = view.findViewById(R.id.removeCapacityButton);
        add = view.findViewById(R.id.addRoom);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Validator.isValidated(getActivity(), editTextList)) {

                }
            }
        });
        increaseFloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(floorText.getText().toString()) < 4) {
                    int floor = Integer.parseInt(floorText.getText().toString());
                    floorText.setText("" + (floor + 1));
                }
            }
        });
        decreaseFloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(floorText.getText().toString()) > 1) {
                    int floor = Integer.parseInt(floorText.getText().toString());
                    floorText.setText("" + (floor - 1));
                }
            }
        });
        increaseCapacity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int capacity = Integer.parseInt(capacityText.getText().toString());
                capacityText.setText("" + (capacity + 1));
            }
        });
        decreaseCapacity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(capacityText.getText().toString()) > 1) {
                    int capacity = Integer.parseInt(capacityText.getText().toString());
                    capacityText.setText("" + (capacity - 1));
                }
            }
        });

        return view;
    }
}