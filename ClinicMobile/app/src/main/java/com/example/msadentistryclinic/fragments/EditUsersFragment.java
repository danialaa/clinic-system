package com.example.msadentistryclinic.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.msadentistryclinic.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditUsersFragment extends Fragment {


    public EditUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_users, container, false);
    }

}
