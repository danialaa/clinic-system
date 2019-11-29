package com.example.clinicsystem.controllers;


import com.example.clinicsystem.helpers.DatabaseConnection;
import com.example.clinicsystem.helpers.TextFieldValidator;
import com.example.clinicsystem.models.classes.M_Address;
import com.example.clinicsystem.models.classes.M_Employee;
import com.example.clinicsystem.models.enums.Gender;

import javax.swing.*;
import java.util.List;

public class C_Employee {
    private DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();
    private M_Address address = new M_Address();
    private M_Employee employee = new M_Employee();

    public List request(String requestType, List<String> list) {
        switch (requestType) {
            case "C":
                address.setApartmentNumber(list.get(0));
                address.setCity(list.get(1));
                address.setGovernorate(list.get(2));
                address.setStreetName(list.get(3));
                int addressID = address.addAddress(databaseConnection);

                employee.setAddress(addressID);
                employee.setBirthDate(list.get(4));
                employee.setFirstName(list.get(5));
                employee.setMiddleName(list.get(6));
                employee.setLastName(list.get(7));
                employee.setPhoneNumber(list.get(8));
                employee.setNationalID(Integer.parseInt(list.get(9)));

                if(list.get(10) == "Male"){
                    employee.setGender(Gender.MALE);
                }else{
                    employee.setGender(Gender.FEMALE);
                }

                int personID = employee.addPerson(databaseConnection);

                employee.setEmployeeID(Integer.parseInt(list.get(11)));
                employee.setEmail(list.get(12));

                employee.addEmployee(databaseConnection, personID);

                return null;
            case "R":

            case "U":

            case "D":

        }

        return null;
    }

    public boolean isValidEmployeeData(List<JTextField> textFieldList, List<JLabel> labelList) {
        if(TextFieldValidator.validateEmpty(textFieldList, labelList) && TextFieldValidator.validateEmail(textFieldList.get(5), labelList.get(5))) {
            return true;
        }

        return false;
    }
}
