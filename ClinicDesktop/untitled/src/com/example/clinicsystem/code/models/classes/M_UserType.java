package com.example.msadentistryclinic.models.classes;

public class CUserType {
    private int userTypeID;
    private String typeName;

    public CUserType(int userTypeID, String typeName) {
        this.userTypeID = userTypeID;
        this.typeName = typeName;
    }

    public CUserType() {
    }

    public int getUserTypeID() {
        return userTypeID;
    }

    public void setUserTypeID(int userTypeID) {
        this.userTypeID = userTypeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
