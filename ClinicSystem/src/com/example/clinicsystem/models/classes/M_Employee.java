package com.example.clinicsystem.models.classes;

import com.example.clinicsystem.helpers.DatabaseConnection;
import com.example.clinicsystem.models.enums.Gender;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class M_Employee extends M_Person {
    private int employeeID;
    private String email;

    public M_Employee(String firstName, String middleName, String lastName, String phoneNumber, String birthDate, M_Address address, int nationalID, Gender gender, int employeeID, String email) {
        super(firstName, middleName, lastName, phoneNumber, birthDate, address, nationalID, gender);
        this.employeeID = employeeID;
        this.email = email;
    }

    public M_Employee() {
        super();
    }

    public List<M_Employee> getAllEmployees(String condition) {
        List<M_Employee> employees = new ArrayList<>();
        DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();
        ResultSet resultSet = databaseConnection.select("employee", condition);

        if(resultSet != null) {
            try {
                while (resultSet.next()) {
                    int id = resultSet.getInt("Employee_ID");
                    String email = resultSet.getString("Employee_Email");

                    List<M_Person> people = getAllPersons(" WHERE Person_ID = " + resultSet.getInt("Person_ID"));

                    M_Employee employee = new M_Employee(people.get(0).getFirstName(), people.get(0).getMiddleName(),
                            people.get(0).getLastName(), people.get(0).getPhoneNumber(), people.get(0).getBirthDate(),
                            people.get(0).getAddress(), people.get(0).getNationalID(), people.get(0).getGender(),
                            id, email);

                    employees.add(employee);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return employees;
    }

    public void addEmployee(int person) {
        DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();

        databaseConnection.insertInto("employee","(Employee_ID, Person_ID, Employee_Email)" ,"('" + this.employeeID + "', '"
                + person + "', '" + this.email + "')");
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
