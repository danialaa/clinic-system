package com.example.clinicsystem.controllers;

import com.example.clinicsystem.helpers.DatabaseConnection;
import com.example.clinicsystem.helpers.TextFieldValidator;
import com.example.clinicsystem.models.classes.M_Patient;
import com.example.clinicsystem.models.enums.DentistryDepartment;
import com.example.clinicsystem.models.enums.Gender;
import com.example.clinicsystem.models.enums.MedicalAlert;

import javax.swing.*;
import java.text.DateFormat;
import java.util.List;

public class C_Patient {
    private M_Patient patient = new M_Patient();
    //first name, middle name, last name, phone, date, id, gender, gov, city, strt, apt, emer name, relation, emer phone, alerts
    public List request(String requestType, List data) {
        switch (requestType) {
            case "C":
                patient.setFirstName(data.get(0).toString());
                patient.setMiddleName(data.get(1).toString());
                patient.setLastName(data.get(2).toString());
                patient.setPhoneNumber(data.get(3).toString());
                patient.setBirthDate(data.get(4).toString());
                patient.setNationalID(Integer.parseInt(data.get(5).toString()));
                patient.setGender((Gender)data.get(6));

                String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(System.currentTimeMillis()));
                patient.setRegistrationDate(date);

                patient.getAddress().setGovernorate(data.get(7).toString());
                patient.getAddress().setCity(data.get(8).toString());
                patient.getAddress().setStreetName(data.get(9).toString());
                patient.getAddress().setApartmentNumber(data.get(10).toString());
                patient.getEmergencyContact().setName(data.get(11).toString());
                patient.getEmergencyContact().setRelation(data.get(12).toString());
                patient.getEmergencyContact().setPhoneNumber(data.get(13).toString());
                patient.setDepartment((DentistryDepartment)data.get(14));

                for(int i=15; i<data.size(); i++) {
                       patient.getMedicalAlerts().add((MedicalAlert)data.get(i));
                }

                patient.getAddress().setId(patient.addAddress());

                int personID = patient.addPerson();
                int emergency_ID = patient.addEmergency();
                int patient_ID = patient.addPatient(personID,emergency_ID);
                patient.updateEmergency(patient_ID);
            case "R":
                if(data == null) {
                    return patient.getAllPatients("");
                } else {
                    return patient.getAllPatients(data.get(0).toString());
                }
            case "U":

            case "D":

        }

        return null;
    }

    public boolean isValidPatient(List<JTextField> textFields , List<JLabel> labels) {
        if(TextFieldValidator.validateEmpty(textFields,labels)) {
            return true;
        }
        return false;
    }
}
