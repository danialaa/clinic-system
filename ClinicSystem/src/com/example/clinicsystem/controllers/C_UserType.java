package com.example.clinicsystem.controllers;

import com.example.clinicsystem.helpers.TextFieldValidator;
import com.example.clinicsystem.models.classes.M_Patient;
import com.example.clinicsystem.models.classes.M_Permission;
import com.example.clinicsystem.models.classes.M_User;
import com.example.clinicsystem.models.classes.M_UserType;

import javax.swing.*;
import java.util.List;

public class C_UserType {
    private M_UserType m_userType = new M_UserType();

    public List request(String requestType, List data) {
        switch (requestType) {
            case "C":
                m_userType.setTypeName(data.get(0).toString());
                for(int i =1;i<data.size();i++) {
                    M_Permission permission = new M_Permission();
                    permission.setLinkName(data.get(i).toString());
                    m_userType.getPermissions().add(permission);
                }
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
