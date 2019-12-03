package com.example.clinicsystem.models.classes;

import com.example.clinicsystem.helpers.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class M_EmergencyContact {
    private int contactID, patientID;
    private String name, relation, phoneNumber;

    public M_EmergencyContact(int contactID, int patientID, String name, String relation, String phoneNumber) {
        this.contactID = contactID;
        this.patientID = patientID;
        this.name = name;
        this.relation = relation;
        this.phoneNumber = phoneNumber;
    }

    public M_EmergencyContact() {
    }

    public List<M_EmergencyContact> getAllEmergencyContacts(String condition){
        List<M_EmergencyContact> emergencyContacts = new ArrayList<>();
        DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();

        ResultSet resultSet = databaseConnection.select("emergency_contact", condition);

        if(resultSet != null) {
            try {
                while (resultSet.next()) {
                    int paitentId = resultSet.getInt("Patient_ID");
                    int emergencyId = resultSet.getInt("Emergency_ID");
                    String emergencyName = resultSet.getString("Emergency_Name");
                    String phone = resultSet.getString("Emergency_Phone");
                    String relation = resultSet.getString("Emergency_Relation");

                    M_EmergencyContact emergencyContact = new M_EmergencyContact();
                    emergencyContacts.add(emergencyContact);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emergencyContacts;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
