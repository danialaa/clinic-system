package com.example.msadentistryclinic.models.classes;

import com.example.msadentistryclinic.models.enums.Gender;

public class CPerson {
    private String firstName, middleName, lastName, phoneNumber, birthDate;
    private CAddress address;
    private int nationalID;
    private Gender gender;

    public CPerson(String firstName, String middleName, String lastName, String phoneNumber, String birthDate, CAddress address, int nationalID, Gender gender) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = address;
        this.nationalID = nationalID;
        this.gender = gender;
    }

    public CPerson() {
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

    public CAddress getAddress() {
        return address;
    }

    public void setAddress(CAddress address) {
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
