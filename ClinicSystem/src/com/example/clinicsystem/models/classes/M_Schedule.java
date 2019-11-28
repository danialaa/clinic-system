package com.example.clinicsystem.models.classes;

public class M_Schedule {
    protected int ID;
    protected String date;

    public M_Schedule(int ID, String date) {
        this.ID = ID;
        this.date = date;
    }

    public M_Schedule() {
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
