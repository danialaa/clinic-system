package com.example.clinicsystem.code.models.classes;

public class M_PrescriptionInstruction {
    private int drugID, quantity, duration, dose;
    private String durationType, instructionDetails;

    public M_PrescriptionInstruction(int drugID, int duration, int dose, String durationType, String instructionDetails, int quantity) {
        this.drugID = drugID;
        this.duration = duration;
        this.dose = dose;
        this.durationType = durationType;
        this.instructionDetails = instructionDetails;
        this.quantity = quantity;
    }

    public M_PrescriptionInstruction() {
    }

    public int getDrugID() {
        return drugID;
    }

    public void setDrugID(int drugID) {
        this.drugID = drugID;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public String getDurationType() {
        return durationType;
    }

    public void setDurationType(String durationType) {
        this.durationType = durationType;
    }

    public String getInstructionDetails() {
        return instructionDetails;
    }

    public void setInstructionDetails(String instructionDetails) {
        this.instructionDetails = instructionDetails;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
