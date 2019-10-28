package com.example.msadentistryclinic.models.classes;

import java.util.List;

public class CPrescription {
    private String date;
    private List<CPrescriptionInstruction> instructions;
    private int patientID, dentistID;

    public CPrescription(String date, List<CPrescriptionInstruction> instructions, int patientID, int dentistID) {
        this.date = date;
        this.instructions = instructions;
        this.patientID = patientID;
        this.dentistID = dentistID;
    }

    public CPrescription() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<CPrescriptionInstruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<CPrescriptionInstruction> instructions) {
        this.instructions = instructions;
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
}
