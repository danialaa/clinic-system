package com.example.msadentistryclinic.models.classes;

import com.example.msadentistryclinic.models.enums.DentistryDepartment;
import com.example.msadentistryclinic.models.enums.Gender;
import com.example.msadentistryclinic.models.enums.MedicalAlert;

import java.util.List;

public class CPatient extends CPerson {
    private int patientID;
    private String registrationDate;
    private DentistryDepartment department;
    private CEmergencyContact emergencyContact;
    private List<MedicalAlert> medicalAlerts;
    private List<CDentalHistory> dentalHistory;
    private List<String> previousSurgeries, medications;

    public CPatient(String firstName, String middleName, String lastName, String phoneNumber, String birthDate, CAddress address, int nationalID, Gender gender, int patientID, String registrationDate, DentistryDepartment department, CEmergencyContact emergencyContact, List<MedicalAlert> medicalAlerts, List<CDentalHistory> dentalHistory, List<String> previousSurgeries, List<String> medications) {
        super(firstName, middleName, lastName, phoneNumber, birthDate, address, nationalID, gender);
        this.patientID = patientID;
        this.registrationDate = registrationDate;
        this.department = department;
        this.emergencyContact = emergencyContact;
        this.medicalAlerts = medicalAlerts;
        this.dentalHistory = dentalHistory;
        this.previousSurgeries = previousSurgeries;
        this.medications = medications;
    }

    public CPatient() {
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

    public CEmergencyContact getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(CEmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public List<MedicalAlert> getMedicalAlerts() {
        return medicalAlerts;
    }

    public void setMedicalAlerts(List<MedicalAlert> medicalAlerts) {
        this.medicalAlerts = medicalAlerts;
    }

    public List<CDentalHistory> getDentalHistory() {
        return dentalHistory;
    }

    public void setDentalHistory(List<CDentalHistory> dentalHistory) {
        this.dentalHistory = dentalHistory;
    }

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
