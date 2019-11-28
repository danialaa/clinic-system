package com.example.clinicsystem.code.helpers;

import javax.swing.*;
import java.util.List;

public class TextFieldValidator {
    public static boolean validateEmpty (List<JTextField> textFields, List<JLabel> labels) {
        boolean isAllGood = true;

        for (int i=0; i<textFields.size(); i++) {
            if(textFields.get(i).getText().isEmpty()) {
                labels.get(i).setText("*Please Fill This Field");
                isAllGood = false;
            } else {
                labels.get(i).setText("");
            }
        }

        return isAllGood;
    }

    public static boolean validateEmail (JTextField textField, JLabel label) {
        if(textField.getText().contains("@")) {
            label.setText("");

            return true;
        } else {
            label.setText("*Please Provide an E-mail");

            return false;
        }
    }

    public static boolean validateAlphabetical (List<JTextField> textFields, List<JLabel> labels) {
        boolean isAllGood = true;
        String regex = ".*\\d+.";

        for (int i=0; i<textFields.size(); i++) {
            if(textFields.get(i).getText().matches(regex)) {
                labels.get(i).setText("*Please Only Enter Letters");
                isAllGood = false;
            } else {
                labels.get(i).setText("");
            }
        }

        return isAllGood;
    }
}
