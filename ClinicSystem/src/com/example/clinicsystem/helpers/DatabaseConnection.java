package com.example.clinicsystem.helpers;

import java.sql.*;

public class DatabaseConnection {
    private String host = "jdbc:mysql://localhost:3306/clinic";
    private String uName = "root";
    private String uPass = "Dania98Mahdaly";
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

    public ResultSet getAll(String table, String condition) {
        ResultSet resultSet;

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM " + table + condition;
            resultSet = statement.executeQuery(query);

            return resultSet;
        } catch (SQLException e) {
            System.out.println("Query Error: ");
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
            System.out.println("Query Error: ");
            e.printStackTrace();
        }

        return -1;
    }
/*
    public String getLastInserted(String table, String column) {
        ResultSet resultSet;

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT MAX(" + column + ") FROM " + table;
            resultSet = statement.executeQuery(query);

            String id = resultSet.getString(column);

            return id;
        } catch (SQLException e) {
            System.out.println("Query Error: ");
            e.printStackTrace();
            return null;
        }
    }

    public void insertAddress(M_Address address) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO address " +
                    "(Address_City, Address_Street, Address_Apartment, Address_Governorate) VALUES " +
                    "('" + address.getCity() + "', '" + address.getStreetName() + "', '" + address.getApartmentNumber() + "', '" + address.getGovernorate() + "')");
        } catch (SQLException e) {
            System.out.println("Query Error: ");
            e.printStackTrace();
        }
    }

    public boolean insertEmployee(M_Employee employee) {
        try {
            Statement statement = connection.createStatement();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }*/
}
