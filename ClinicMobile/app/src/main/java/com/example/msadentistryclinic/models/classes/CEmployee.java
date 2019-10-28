package com.example.msadentistryclinic.models.classes;

import com.example.msadentistryclinic.models.enums.Gender;

public class CEmployee extends CPerson {
    private int employeeID;

    public CEmployee(String firstName, String middleName, String lastName, String phoneNumber, String birthDate, CAddress address, int nationalID, Gender gender, int employeeID) {
        super(firstName, middleName, lastName, phoneNumber, birthDate, address, nationalID, gender);
        this.employeeID = employeeID;
    }

    public CEmployee() {
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
