package com.example.clinicsystem.code.models.classes;

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
