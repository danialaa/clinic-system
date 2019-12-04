package com.example.clinicsystem.controllers;

import com.example.clinicsystem.helpers.TextFieldValidator;
import com.example.clinicsystem.models.classes.*;
import com.example.clinicsystem.models.enums.EquipmentType;

import javax.swing.*;
import java.util.List;

public class C_Equipment {
    public List request(String requestType, List data) {
        M_Equipment equipment = new M_Equipment();

        switch (requestType) {
            case "C":
                equipment.setName(data.get(0).toString());
                equipment.setPrice(Integer.parseInt(data.get(1).toString()));
                equipment.setQuantity(Integer.parseInt(data.get(2).toString()));
                equipment.setEquipmentType(EquipmentType.getConstant(data.get(3).toString()));
                equipment.setAvailable((boolean)data.get(4));
                equipment.setId(equipment.addEquipment());

                if(data.get(5).toString().equals("drug")) {
                    M_Drug drug = new M_Drug();
                    drug.setExpiryDate(data.get(6).toString());
                    drug.setProductionDate(data.get(7).toString());
                    drug.addDrug();
                }
                if(data.get(5).toString().equals("engine")) {
                    M_DentalEngine dentalEngine = new M_DentalEngine();
                }
                if(data.get(5).toString().equals("operational")) {
                    M_OperationalTool operationalTool = new M_OperationalTool();
                }
                if(data.get(5).toString().equals("sterilization")) {
                    M_SterilizationTool sterilizationTool = new M_SterilizationTool();
                }

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
