package com.example.clinicsystem.code.models.interfaces;

import com.example.clinicsystem.code.models.classes.M_Patient;

import java.util.List;

public interface IViewPatient {
    public List<M_Patient> viewPatients();
    public List<M_Patient> searchPatients();
}
