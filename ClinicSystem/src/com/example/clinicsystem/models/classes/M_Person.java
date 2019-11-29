package com.example.clinicsystem.models.classes;

import com.example.clinicsystem.helpers.DatabaseConnection;
import com.example.clinicsystem.models.enums.Gender;

public class M_Person {
    private String firstName, middleName, lastName, phoneNumber, birthDate;
    private M_Address address;
    private int nationalID;
    private Gender gender;

    public M_Person(String firstName, String middleName, String lastName, String phoneNumber, String birthDate, M_Address address, int nationalID, Gender gender) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = address;
        this.nationalID = nationalID;
        this.gender = gender;
    }

    public M_Person() {
        this.address = new M_Address();
    }

    public int addAddress() {
        DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();

        return databaseConnection.insertInto("address","(Address_City, Address_Street," +
                "Address_Apartment, Address_Governorate)" ,"('" + address.getCity() + "', '"
                + address.getStreetName() + "', '" + address.getApartmentNumber() + "', '" + address.getGovernorate()
                + "')");
    }

    public int addPerson() {
        DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();
        int genderID;

        if (this.gender == Gender.MALE) {
            genderID = 1;
        } else {
            genderID = 2;
        }

        return databaseConnection.insertInto("person","(Address_ID, Gender_ID, Person_Birth" +
                ", Person_FN, Person_LN, Person_MN, Person_NationalID, Person_Phone)"
                ,"('" + this.address.getId() + "', '" + genderID + "', '" + this.birthDate + "', '" + this.firstName + "', '"
                + this.lastName + "', '" + this.middleName + "', '" + this.nationalID + "', '" + this.phoneNumber + "')");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public M_Address getAddress() {
        return address;
    }

    public void setAddress(M_Address address) {
        this.address = address;
    }

    public int getNationalID() {
        return nationalID;
    }

    public void setNationalID(int nationalID) {
        this.nationalID = nationalID;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
