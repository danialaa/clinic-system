package com.example.msadentistryclinic.models.classes;

public class CSchedule {
    protected int ID;
    protected String date;

    public CSchedule(int ID, String date) {
        this.ID = ID;
        this.date = date;
    }

    public CSchedule() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
