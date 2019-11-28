package com.example.msadentistryclinic.services;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.msadentistryclinic.activities.HomeActivity;

import java.util.List;

public class UsersViewModel extends AndroidViewModel {
    protected FirebaseManager firebaseManager;

    public UsersViewModel(@NonNull Application application) {
        super(application);

        firebaseManager = new FirebaseManager();
    }

    public boolean isLoggedIn() {
        return firebaseManager.isLoggedIn();
    }

    public void isLoggedIn(String email, String password, List<EditText> editTextList, Context context) {
        if (Validator.isValidated(context, editTextList)) {
            if(firebaseManager.isSuccessfulLogin(email, password)) {
                context.startActivity(new Intent(context, HomeActivity.class));
            }
        }
    }
}
