package com.example.msadentistryclinic.models.classes;

public class CAddress {
    private String city, streetName, governorate;
    private int apartmentNumber;

    public CAddress(String city, String streetName, String governorate, int apartmentNumber) {
        this.city = city;
        this.streetName = streetName;
        this.governorate = governorate;
        this.apartmentNumber = apartmentNumber;
    }

    public CAddress() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getGovernorate() {
        return governorate;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }
}
