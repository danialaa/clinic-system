package com.example.clinicsystem.controllers;


import com.example.clinicsystem.models.classes.M_Permission;

import java.util.List;

public class C_Permission {


    public List request(String requestType, String condition) {
        M_Permission permission = new M_Permission();

        switch (requestType) {
            case "C":

            case "R":
                return permission.getAllPermissions(condition);
            case "U":

            case "D":

        }

        return null;
    }
}
