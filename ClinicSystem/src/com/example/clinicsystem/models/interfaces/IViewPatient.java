package com.example.clinicsystem.models.interfaces;


import com.example.clinicsystem.models.classes.M_Patient;

import java.util.List;

public interface IViewPatient {
    List<M_Patient> viewPatients();
    List<M_Patient> searchPatients();
}
