package com.example.msadentistryclinic.models.classes;

import com.example.msadentistryclinic.models.enums.Gender;

public class CUser extends CEmployee {
    private String username, password;
    private boolean isLoggedIn;
    private int userID, userTypeID;

    public CUser(String firstName, String middleName, String lastName, String phoneNumber, String birthDate, CAddress address, int nationalID, Gender gender, int employeeID, String username, String password, boolean isLoggedIn, int userID, int userTypeID) {
        super(firstName, middleName, lastName, phoneNumber, birthDate, address, nationalID, gender, employeeID);
        this.username = username;
        this.password = password;
        this.isLoggedIn = isLoggedIn;
        this.userID = userID;
        this.userTypeID = userTypeID;
    }

    public CUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserTypeID() {
        return userTypeID;
    }

    public void setUserTypeID(int userTypeID) {
        this.userTypeID = userTypeID;
    }

    public void logout() {
    }

    public Object printItem(Object printable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isValidated(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void loadHomePage(String userType) {
    }
}
