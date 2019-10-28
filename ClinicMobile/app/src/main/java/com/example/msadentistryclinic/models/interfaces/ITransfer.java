package com.example.msadentistryclinic.models.interfaces;

import com.example.msadentistryclinic.models.enums.DentistryDepartment;

public interface ITransfer {
    public void transferPerson(DentistryDepartment newDepartment, int persontID);
}
