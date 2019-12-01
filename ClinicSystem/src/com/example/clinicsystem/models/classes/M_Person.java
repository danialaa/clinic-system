package com.example.clinicsystem.models.classes;

import com.example.clinicsystem.helpers.DatabaseConnection;
import com.example.clinicsystem.models.enums.Gender;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<M_Address> getAllAddresses(String condition) {
        List<M_Address> addresses = new ArrayList<>();
        DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();
        ResultSet resultSet = databaseConnection.select("address", condition);

        if(resultSet != null) {
            try {
                while (resultSet.next()) {
                    int id = resultSet.getInt("Address_ID");
                    String apt = resultSet.getString("Address_Apartment");
                    String city = resultSet.getString("Address_City");
                    String gover = resultSet.getString("Address_Governorate");
                    String st = resultSet.getString("Address_Street");

                    M_Address address = new M_Address(id, city, st, gover, apt);
                    addresses.add(address);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return addresses;
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

    public List<M_Person> getAllPersons(String condition) {
        List<M_Person> people = new ArrayList<>();
        DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();
        ResultSet resultSet = databaseConnection.select("person", condition);

        if(resultSet != null) {
            try {
                while (resultSet.next()) {
                    String fn = resultSet.getString("Person_FN");
                    String mn = resultSet.getString("Person_MN");
                    String ln = resultSet.getString("Person_LN");
                    String dob = resultSet.getString("Person_Birth");
                    int id = resultSet.getInt("Person_NationalID");
                    String phone = resultSet.getString("Person_Phone");
                    Gender gender;

                    if(resultSet.getInt("Gender_ID") == 1) {
                        gender = Gender.MALE;
                    } else {
                        gender = Gender.FEMALE;
                    }

                    List<M_Address> addresses = getAllAddresses(" WHERE Address_ID = " + resultSet.getInt("Address_ID"));

                    M_Person person = new M_Person(fn, mn, ln, phone, dob, addresses.get(0), id, gender);
                    people.add(person);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return people;
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
