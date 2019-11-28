package com.example.clinicsystem.models.classes;

import com.example.clinicsystem.helpers.DatabaseConnection;
import com.example.clinicsystem.models.enums.Gender;

public class M_Person {
    private String firstName, middleName, lastName, phoneNumber, birthDate;
    private int address;
    private int nationalID;
    private Gender gender;

    public M_Person(String firstName, String middleName, String lastName, String phoneNumber, String birthDate, int address, int nationalID, Gender gender) {
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
    }

    public int addPerson(DatabaseConnection databaseConnection) {
        int genderID;

        if (this.gender == Gender.MALE) {
            genderID = 1;
        } else {
            genderID = 2;
        }

        return databaseConnection.insertInto("person","(Address_ID, Gender_ID, Person_Birth" +
                ", Person_FN, Person_LN, Person_MN, Person_NationalID, Person_Phone)"
                ,"('" + this.address + "', '" + genderID + "', '" + this.birthDate + "', '" + this.firstName + "', '"
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

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
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
