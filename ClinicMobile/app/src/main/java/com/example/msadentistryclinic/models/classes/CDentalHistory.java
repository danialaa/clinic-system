package com.example.msadentistryclinic.models.classes;

import com.example.msadentistryclinic.models.enums.DentistryDepartment;

public class CDentalHistory {
    private int dentalHistoryID, patientID, dentistID;
    private String date, details;
    private DentistryDepartment department;

    public CDentalHistory(int dentalHistoryID, int patientID, int dentistID, String date, String details, DentistryDepartment department) {
        this.dentalHistoryID = dentalHistoryID;
        this.patientID = patientID;
        this.dentistID = dentistID;
        this.date = date;
        this.details = details;
        this.department = department;
    }

    public CDentalHistory() {
    }

    public int getDentalHistoryID() {
        return dentalHistoryID;
    }

    public void setDentalHistoryID(int dentalHistoryID) {
        this.dentalHistoryID = dentalHistoryID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getDentistID() {
        return dentistID;
    }

    public void setDentistID(int dentistID) {
        this.dentistID = dentistID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public DentistryDepartment getDepartment() {
        return department;
    }

    public void setDepartment(DentistryDepartment department) {
        this.department = department;
    }
}
