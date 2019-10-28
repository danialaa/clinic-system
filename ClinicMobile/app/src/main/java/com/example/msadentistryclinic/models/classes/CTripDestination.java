package com.example.msadentistryclinic.models.classes;

public class CTripDestination {
    private int ID;
    private String city, governorate;

    public CTripDestination(int ID, String city, String governorate) {
        this.ID = ID;
        this.city = city;
        this.governorate = governorate;
    }

    public CTripDestination() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGovernorate() {
        return governorate;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }
}
