package com.example.clinicsystem.controllers;

import com.example.clinicsystem.helpers.TextFieldValidator;
import com.example.clinicsystem.models.classes.M_Patient;
import com.example.clinicsystem.models.enums.DentistryDepartment;
import com.example.clinicsystem.models.enums.Gender;
import com.example.clinicsystem.models.enums.MedicalAlert;

import javax.swing.*;
import java.util.List;

public class C_Patient {
    public List request(String requestType, List data) {
        M_Patient patient = new M_Patient();

        switch (requestType) {
            case "C":
                patient.setFirstName(data.get(0).toString());
                patient.setMiddleName(data.get(1).toString());
                patient.setLastName(data.get(2).toString());
                patient.setPhoneNumber(data.get(3).toString());
                patient.setBirthDate(data.get(4).toString());
                patient.setNationalID(Integer.parseInt(data.get(5).toString()));
                patient.setGender(Gender.getConstant(data.get(6).toString()));

                String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(System.currentTimeMillis()));
                patient.setRegistrationDate(date);

                patient.getAddress().setGovernorate(data.get(7).toString());
                patient.getAddress().setCity(data.get(8).toString());
                patient.getAddress().setStreetName(data.get(9).toString());
                patient.getAddress().setApartmentNumber(data.get(10).toString());
                patient.getEmergencyContact().setName(data.get(11).toString());
                patient.getEmergencyContact().setRelation(data.get(12).toString());
                patient.getEmergencyContact().setPhoneNumber(data.get(13).toString());
                patient.setDepartment(DentistryDepartment.getConstant(data.get(14).toString()));

                for(int i=15; i<data.size(); i++) {
                       patient.getMedicalAlerts().add(MedicalAlert.getConstant(data.get(i).toString()));
                }

                patient.getAddress().setId(patient.addAddress());
                int personID = patient.addPerson();
                patient.getEmergencyContact().setContactID(patient.addEmergency());
                patient.getEmergencyContact().setPatientID(patient.addPatient(personID));
                patient.updateEmergency("pid");

                return null;

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
