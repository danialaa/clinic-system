package com.example.clinicsystem.helpers;

import java.sql.*;

public class DatabaseConnection {
    private String host = "jdbc:mysql://localhost:3306/clinic";
    private String uName = "root";
    private String uPass = "Awsomemosta12232";
    private Connection connection;
    private static DatabaseConnection INSTANCE = null;

    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(host, uName, uPass);
        } catch (SQLException e) {
            System.out.println("Connection Error: ");
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getINSTANCE() {
        if(INSTANCE == null) {
            INSTANCE = new DatabaseConnection();
        }

        return INSTANCE;
    }

    public ResultSet select(String table, String condition) {
        ResultSet resultSet;

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM " + table + condition;
            resultSet = statement.executeQuery(query);

            return resultSet;
        } catch (SQLException e) {
            System.out.println("Select Query Error: ");
            e.printStackTrace();
            return null;
        }
    }

    public int insertInto(String table, String columns, String values) {
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO " + table + " " + columns + " VALUES " + values;
            int id = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }

            return id;
        } catch (SQLException e) {
            System.out.println("Insert Query Error: ");
            e.printStackTrace();
        }

        return -1;
    }

    public void update(String table, String newValues, int id, String idColumn) {
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE " + table + " SET " + newValues + " WHERE " + idColumn + " = " + id;

            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Update Query Error: ");
            e.printStackTrace();
        }
    }
}
