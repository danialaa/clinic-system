package com.example.clinicsystem.models.classes;

import com.example.clinicsystem.helpers.DatabaseConnection;
import com.example.clinicsystem.models.enums.Gender;

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
