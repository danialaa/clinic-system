package com.example.msadentistryclinic.models.classes;

import com.example.msadentistryclinic.models.enums.Gender;

public class CIntern extends CPerson {
    private int internshipDuration;

    public CIntern(String firstName, String middleName, String lastName, String phoneNumber, String birthDate, CAddress address, int nationalID, Gender gender, int internshipDuration) {
        super(firstName, middleName, lastName, phoneNumber, birthDate, address, nationalID, gender);
        this.internshipDuration = internshipDuration;
    }

    public CIntern() {
    }

    public int getInternshipDuration() {
        return internshipDuration;
    }

    public void setInternshipDuration(int internshipDuration) {
        this.internshipDuration = internshipDuration;
    }
}
