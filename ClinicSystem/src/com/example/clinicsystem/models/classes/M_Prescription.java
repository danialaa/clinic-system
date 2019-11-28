package com.example.clinicsystem.models.classes;

import java.util.List;

public class M_Prescription {
    private String date;
    private List<M_PrescriptionInstruction> instructions;
    private int patientID, dentistID;

    public M_Prescription(String date, List<M_PrescriptionInstruction> instructions, int patientID, int dentistID) {
        this.date = date;
        this.instructions = instructions;
        this.patientID = patientID;
        this.dentistID = dentistID;
    }

    public M_Prescription() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<M_PrescriptionInstruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<M_PrescriptionInstruction> instructions) {
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
