package com.example.clinicsystem.controllers;

import com.example.clinicsystem.models.classes.M_Equipment;

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
}
