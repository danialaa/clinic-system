package com.example.clinicsystem.models.classes;


import com.example.clinicsystem.helpers.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class M_Permission {
    private int permissionID;
    private String linkName, physicalLink;

    public M_Permission(int permissionID, String linkName, String physicalLink) {
        this.permissionID = permissionID;
        this.linkName = linkName;
        this.physicalLink = physicalLink;
    }

    public M_Permission() {
    }

    public List<M_Permission> getAllPermissions(String condition){
        List<M_Permission> permissions = new ArrayList<>();
        DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();
        ResultSet resultSet = databaseConnection.select("permission", condition);

        if(resultSet != null) {
            try {
                while (resultSet.next()) {
                    int id = resultSet.getInt("Permission_ID");
                    String name = resultSet.getString("Permission_Name");
                    String link = resultSet.getString("Permission_Link");
                    M_Permission permission = new M_Permission(id, name, link);
                    permissions.add(permission);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return permissions;
    }

    public int getLinkID() {
        return permissionID;
    }

    public void setLinkID(int permissionID) {
        this.permissionID = permissionID;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getPhysicalLink() {
        return physicalLink;
    }

    public void setPhysicalLink(String physicalLink) {
        this.physicalLink = physicalLink;
    }
}
