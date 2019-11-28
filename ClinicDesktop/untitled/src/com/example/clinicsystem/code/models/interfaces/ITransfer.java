package com.example.clinicsystem.code.models.interfaces;

import com.example.clinicsystem.code.models.enums.DentistryDepartment;

public interface ITransfer {
    public void transferPerson(DentistryDepartment newDepartment, int persontID);
}
