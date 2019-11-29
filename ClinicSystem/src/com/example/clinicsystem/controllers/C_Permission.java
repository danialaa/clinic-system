package com.example.clinicsystem.controllers;


import com.example.clinicsystem.helpers.DatabaseConnection;
import com.example.clinicsystem.models.classes.M_Permission;

import java.util.List;

public class C_Permission {
    private DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();
    private M_Permission permission = new M_Permission();

    public List request(String requestType, String condition) {
        switch (requestType) {
            case "C":

            case "R":
                return permission.getAllPermissions(databaseConnection, condition);
            case "U":

            case "D":

        }

        return null;
    }
}
