package com.example.msadentistryclinic.models.classes;

import com.example.msadentistryclinic.models.enums.Gender;

public class CPostGraduate extends CPerson {
    private int universityID, level;

    public CPostGraduate(String firstName, String middleName, String lastName, String phoneNumber, String birthDate, CAddress address, int nationalID, Gender gender, int universityID, int level) {
        super(firstName, middleName, lastName, phoneNumber, birthDate, address, nationalID, gender);
        this.universityID = universityID;
        this.level = level;
    }

    public CPostGraduate() {
    }

    public int getUniversityID() {
        return universityID;
    }

    public void setUniversityID(int universityID) {
        this.universityID = universityID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
