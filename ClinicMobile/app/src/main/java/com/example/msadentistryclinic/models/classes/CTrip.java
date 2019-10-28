package com.example.msadentistryclinic.models.classes;

import java.util.List;

public class CTrip {
    private int durationInDays;
    private List<Integer> employeesJoined, equipmentsID, destinations;
    private String date;
    private boolean isCompleted;

    public CTrip(int durationInDays, List<Integer> employeesJoined, List<Integer> equipmentsID, String date, boolean isCompleted) {
        this.durationInDays = durationInDays;
        this.employeesJoined = employeesJoined;
        this.equipmentsID = equipmentsID;
        this.date = date;
        this.isCompleted = isCompleted;
    }

    public CTrip() {
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public List<Integer> getEmployeesJoined() {
        return employeesJoined;
    }

    public void setEmployeesJoined(List<Integer> employeesJoined) {
        this.employeesJoined = employeesJoined;
    }

    public List<Integer> getEquipmentsID() {
        return equipmentsID;
    }

    public void setEquipmentsID(List<Integer> equipmentsID) {
        this.equipmentsID = equipmentsID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void addDestination(CTripDestination destination) {
        this.destinations.add(destination.getID());
    }

    public void addEquipment(int equipmentID) {
        this.equipmentsID.add(equipmentID);
    }
}
