package com.example.clinicsystem.models.interfaces;


import com.example.clinicsystem.models.enums.DentistryDepartment;

public interface ITransfer {
    void transferPerson(DentistryDepartment newDepartment, int persontID);
}
