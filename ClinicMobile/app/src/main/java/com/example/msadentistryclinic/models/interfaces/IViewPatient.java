package com.example.msadentistryclinic.models.interfaces;

import com.example.msadentistryclinic.models.classes.CPatient;

import java.util.List;

public interface IViewPatient {
    public List<CPatient> viewPatients();
    public List<CPatient> searchPatients();
}
