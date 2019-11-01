package com.example.msadentistryclinic.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {
    private EditText emailEdt, passwordEdt;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private String email, password;
    private List<EditText> editTextList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        if (FirebaseAuth.getInstance().getCurrentUser() != null){
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            finish();
        }

        databaseReference = FirebaseDatabase.getInstance().getReference().child("users");

        emailEdt = findViewById(R.id.emailEdit);
        passwordEdt = findViewById(R.id.passwordEdit);
        editTextList.add(emailEdt);
        editTextList.add(passwordEdt);
    }

    public void notifyAdmin(View view) {

    }

    private void login(View view) {
         email = emailEdt.getText().toString();
         password = passwordEdt.getText().toString();

        if (Validator.isValidated(this, editTextList)) {
            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(MainActivity.this, R.string.welcome, Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(MainActivity.this, HomeActivity.class));
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, R.string.fail, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void PutAdmin(View view) {
        email = emailEdt.getText().toString();
        password = passwordEdt.getText().toString();

        if (Validator.isValidated(this, editTextList)) {
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            FirebaseUser user = authResult.getUser();
                            String uid = user.getUid();

                            HashMap<String, String> hashmap = new HashMap<>();
                            hashmap.put("userid", uid);
                            hashmap.put("email", email);
                            hashmap.put("name", "Admin");
                            hashmap.put("role", "Admin");
                            databaseReference.child(uid).setValue(hashmap);

                            Toast.makeText(MainActivity.this, R.string.welcome, Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, R.string.fail, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}