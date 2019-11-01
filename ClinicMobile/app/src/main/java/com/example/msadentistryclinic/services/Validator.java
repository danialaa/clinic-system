package com.example.msadentistryclinic.services;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import com.example.msadentistryclinic.R;

import java.util.List;

public class Validator {
    public static boolean isValidated (Context context, List<EditText> editTextList) {
        for (EditText editText : editTextList) {
            String text = editText.getText().toString();

            if (TextUtils.isEmpty(text)) {
                if (TextUtils.isEmpty(text)) {
                    editText.setError(context.getResources().getString(R.string.required));
                }

                return false;
            } else {
                return true;
            }
        }

        return true;
    }
}
