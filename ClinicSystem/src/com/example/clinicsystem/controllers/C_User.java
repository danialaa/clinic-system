package com.example.clinicsystem.controllers;

import com.example.clinicsystem.models.classes.M_User;

import java.util.List;

public class C_User {
    private M_User user = new M_User();

    public List request(String requestType, String condition) {
        switch (requestType) {
            case "C":

            case "R":
                return user.getAllUsers(condition);
            case "U":

            case "D":

        }

        return null;
    }

    public boolean ifUserExist(String id, String password) {
        List<M_User> users = request("R", " WHERE User_ID = " + id + " AND User_Password = " + password);

        if (users.size() > 0) {
            return true;
        }

        return false;
    }
}
