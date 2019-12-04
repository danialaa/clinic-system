package com.example.clinicsystem.controllers;

import com.example.clinicsystem.helpers.TextFieldValidator;
import com.example.clinicsystem.models.classes.M_Patient;
import com.example.clinicsystem.models.classes.M_Permission;
import com.example.clinicsystem.models.classes.M_User;
import com.example.clinicsystem.models.classes.M_UserType;

import javax.swing.*;
import java.util.List;

public class C_UserType {
    public List request(String requestType, List data) {
        M_UserType userType = new M_UserType();

        switch (requestType) {
            case "C":
                userType.setTypeName(data.get(0).toString());

                for(int i=1; i < data.size(); i++) {
                    M_Permission permission = (M_Permission)data.get(i);
                    userType.getPermissions().add(permission);
                }

                userType.setUserTypeID(userType.addUserType());
                userType.addTypeLink();

                return null;
            case "R":

            case "U":

            case "D":

        }

        return null;
    }

    public boolean isValidUserType(List<JTextField> textFields , List<JLabel> labels) {
        if(TextFieldValidator.validateEmpty(textFields,labels)) {
            return true;
        }

        return false;
    }
}
