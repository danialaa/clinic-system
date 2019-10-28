package com.example.msadentistryclinic.models.classes;

import com.example.msadentistryclinic.models.interfaces.IAddDetail;

public class CLabOrder implements IAddDetail {
    private int orderID, dentistID, patientID, supervisorID, extraFees;
    private boolean isRemovable;
    private String date, status;

    @Override
    public void addDetail(CDetail detail) {
        detail.parentID = this.orderID;
    }

    public CLabOrder(int orderID, int dentistID, int patientID, int supervisorID, int extraFees, boolean isRemovable, String date, String status) {
        this.orderID = orderID;
        this.dentistID = dentistID;
        this.patientID = patientID;
        this.supervisorID = supervisorID;
        this.extraFees = extraFees;
        this.isRemovable = isRemovable;
        this.date = date;
        this.status = status;
    }

    public CLabOrder() {
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getDentistID() {
        return dentistID;
    }

    public void setDentistID(int dentistID) {
        this.dentistID = dentistID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getSupervisorID() {
        return supervisorID;
    }

    public void setSupervisorID(int supervisorID) {
        this.supervisorID = supervisorID;
    }

    public int getExtraFees() {
        return extraFees;
    }

    public void setExtraFees(int extraFees) {
        this.extraFees = extraFees;
    }

    public boolean isRemovable() {
        return isRemovable;
    }

    public void setRemovable(boolean removable) {
        isRemovable = removable;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
