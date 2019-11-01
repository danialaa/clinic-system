package com.example.msadentistryclinic.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.msadentistryclinic.R;
import com.example.msadentistryclinic.services.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddRolesFragment extends Fragment {
    private Button add;
    private EditText roleEdit;
    private List<EditText> editTextList = new ArrayList<>();

    public AddRolesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_roles, container, false);

        roleEdit = view.findViewById(R.id.roleNameEdit);
        editTextList.add(roleEdit);
        add = view.findViewById(R.id.addRole);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Validator.isValidated(getActivity(), editTextList)) {

                }
            }
        });

        return view;
    }

}
