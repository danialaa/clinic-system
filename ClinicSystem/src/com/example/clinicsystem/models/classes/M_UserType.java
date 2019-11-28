package com.example.clinicsystem.models.classes;

public class M_UserType {
    private int userTypeID;
    private String typeName;

    public M_UserType(int userTypeID, String typeName) {
        this.userTypeID = userTypeID;
        this.typeName = typeName;
    }

    public M_UserType() {
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
