package com.example.clinicsystem.code.models.classes;

import com.example.clinicsystem.code.helpers.DatabaseConnection;

public class M_Address {
    private String city, streetName, governorate, apartmentNumber;

    public M_Address(String city, String streetName, String governorate, String apartmentNumber) {
        this.city = city;
        this.streetName = streetName;
        this.governorate = governorate;
        this.apartmentNumber = apartmentNumber;
    }

    public M_Address() {
    }

    public int addAddress(DatabaseConnection databaseConnection) {
        return databaseConnection.insertInto("address","(Address_City, Address_Street," +
                "Address_Apartment, Address_Governorate)" ,"('" + this.city + "', '"
                + this.streetName + "', '" + this.apartmentNumber + "', '" + this.governorate
                + "')");
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
