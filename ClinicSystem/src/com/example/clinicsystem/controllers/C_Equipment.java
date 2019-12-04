package com.example.clinicsystem.controllers;

import com.example.clinicsystem.helpers.TextFieldValidator;
import com.example.clinicsystem.models.classes.M_Equipment;

import javax.swing.*;
import java.util.List;

public class C_Equipment {
    public List request(String requestType, List list) {
        M_Equipment equipment = new M_Equipment();

        switch (requestType) {
            case "C":
                equipment.addEquipment();

                break;
            case "R":

            case "U":

            case "D":

        }

        return null;
    }

    public boolean isValidEquipmentData(List<JTextField> textFieldList, List<JLabel> labelList) {
        if(TextFieldValidator.validateEmpty(textFieldList, labelList) && TextFieldValidator.validateEmail(textFieldList.get(5), labelList.get(5))) {
            return true;
        }

        return false;
    }
}
