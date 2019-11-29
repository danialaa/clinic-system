package com.example.clinicsystem.models.classes;

public class M_Address {
    private int id;
    private String city, streetName, governorate, apartmentNumber;

    public M_Address(int id, String city, String streetName, String governorate, String apartmentNumber) {
        this.id = id;
        this.city = city;
        this.streetName = streetName;
        this.governorate = governorate;
        this.apartmentNumber = apartmentNumber;
    }

    public M_Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }
}
