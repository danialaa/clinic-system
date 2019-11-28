package com.example.clinicsystem.models.classes;


import com.example.clinicsystem.helpers.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class M_User {
    private String id;
    private String password;

    public M_User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public M_User() {
    }

    public List<M_User> getAllUsers(DatabaseConnection databaseConnection, String condition) {
        List<M_User> users = new ArrayList<>();
        ResultSet resultSet = databaseConnection.getAll("users", condition);

        if(resultSet != null) {
            try {
                while (resultSet.next()) {
                    String id = resultSet.getString("User_ID");
                    String password = resultSet.getString("User_Password");
                    M_User user = new M_User(id, password);
                    users.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
