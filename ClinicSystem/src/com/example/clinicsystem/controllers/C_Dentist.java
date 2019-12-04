package com.example.clinicsystem.controllers;

import com.example.clinicsystem.models.classes.M_Dentist;
import com.example.clinicsystem.models.enums.DentistryDepartment;

import javax.swing.*;
import java.util.List;

public class C_Dentist {
    public List request(String requestType, List list) {
        M_Dentist dentist = new M_Dentist();

        switch (requestType) {
            case "C":

            case "R":
                if(list == null) {
                    return dentist.getAllDentists("");
                } else {
                    return dentist.getAllDentists(list.get(0).toString());
                }

            case "U":

            case "D":

        }

        return null;
    }
}
