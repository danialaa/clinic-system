package com.example.clinicsystem.models.classes;

import com.example.clinicsystem.helpers.DatabaseConnection;

import java.util.ArrayList;
import java.util.List;

public class M_UserType {
    private int userTypeID;
    private String typeName;
    private List<M_Permission> permissions;

    public M_UserType(int userTypeID, String typeName,List<M_Permission> permissions) {
        this.userTypeID = userTypeID;
        this.typeName = typeName;
        this.permissions = permissions;
    }

    public M_UserType() {
        permissions = new ArrayList<>();
    }

    public int addUserType() {
        return DatabaseConnection.getINSTANCE().insertInto("usertype","(UserType_Name)"
                ,"('" + this.getTypeName() + "')");
    }

    public void addTypeLink() {
        for(M_Permission permission : this.permissions) {
            DatabaseConnection.getINSTANCE().insertInto("type_permission","(Permission_ID," +
                    " UserType_ID)", "('" + permission.getPermissionID() + "', '" + this.getUserTypeID() + "')");
        }
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

    public List<M_Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<M_Permission> permissions) {
        this.permissions = permissions;
    }
}
