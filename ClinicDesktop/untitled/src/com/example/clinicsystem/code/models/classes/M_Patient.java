package com.example.clinicsystem.code.models.classes;

import com.example.clinicsystem.code.models.enums.DentistryDepartment;
import com.example.clinicsystem.code.models.enums.Gender;
import com.example.clinicsystem.code.models.enums.MedicalAlert;

import java.util.List;

public class M_Patient extends M_Person {
    private int patientID;
    private String registrationDate;
    private DentistryDepartment department;
    private int emergencyContact;
    private List<MedicalAlert> medicalAlerts;
    //private List<CDentalHistory> dentalHistory;
    private List<String> previousSurgeries, medications;

    public M_Patient(String firstName, String middleName, String lastName, String phoneNumber, String birthDate,
                     int address, int nationalID, Gender gender, int patientID, String registrationDate,
                     DentistryDepartment department, int emergencyContact, List<MedicalAlert> medicalAlerts,
                     List<String> previousSurgeries, List<String> medications) {
        super(firstName, middleName, lastName, phoneNumber, birthDate, address, nationalID, gender);
        this.patientID = patientID;
        this.registrationDate = registrationDate;
        this.department = department;
        this.emergencyContact = emergencyContact;
        this.medicalAlerts = medicalAlerts;
        //this.dentalHistory = dentalHistory;
        this.previousSurgeries = previousSurgeries;
        this.medications = medications;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public DentistryDepartment getDepartment() {
        return department;
    }

    public void setDepartment(DentistryDepartment department) {
        this.department = department;
    }

    public int getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(int emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public List<MedicalAlert> getMedicalAlerts() {
        return medicalAlerts;
    }

    public void setMedicalAlerts(List<MedicalAlert> medicalAlerts) {
        this.medicalAlerts = medicalAlerts;
    }

    /*public List<CDentalHistory> getDentalHistory() {
        return dentalHistory;
    }

    public void setDentalHistory(List<CDentalHistory> dentalHistory) {
        this.dentalHistory = dentalHistory;
    }*/

    public List<String> getPreviousSurgeries() {
        return previousSurgeries;
    }

    public void setPreviousSurgeries(List<String> previousSurgeries) {
        this.previousSurgeries = previousSurgeries;
    }

    public List<String> getMedications() {
        return medications;
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }
}
