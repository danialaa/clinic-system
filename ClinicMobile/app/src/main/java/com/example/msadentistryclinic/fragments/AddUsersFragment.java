package com.example.msadentistryclinic.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.msadentistryclinic.R;
import com.example.msadentistryclinic.services.Validator;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddUsersFragment extends Fragment {
    private Button add;
    private EditText passwordEdit, confirmPasswordEdit;
    private Spinner rolesSpinner, employeesSpinner;
    private List<EditText> editTextList = new ArrayList<>();
    private FirebaseAuth firebaseAuth, fakeFirebaseAuth;
    private DatabaseReference databaseReference;

    public AddUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_users, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
        fakeFirebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("users");

        passwordEdit = view.findViewById(R.id.userPasswordEdit);
        confirmPasswordEdit = view.findViewById(R.id.userConfirmPasswordEdit);
        rolesSpinner = view.findViewById(R.id.rolesSpinner);
        employeesSpinner = view.findViewById(R.id.employeesSpinner);
        editTextList.add(passwordEdit);
        editTextList.add(confirmPasswordEdit);
        add = view.findViewById(R.id.addUser);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String password = passwordEdit.getText().toString();
                final String email = "dania@gmail.com";
                final String name = "Dania";
                final String role = "Admin";

                if (Validator.isValidated(getActivity(), editTextList)) {
                    fakeFirebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    FirebaseUser user = authResult.getUser();
                                    String uid = user.getUid();

                                    HashMap<String, String> hashmap = new HashMap<>();
                                    hashmap.put("userid", uid);
                                    hashmap.put("email", email);
                                    hashmap.put("name", name);
                                    hashmap.put("role", role);
                                    databaseReference.child(uid).setValue(hashmap);

                                    fakeFirebaseAuth.signOut();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(), R.string.fail, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        return view;
    }
}