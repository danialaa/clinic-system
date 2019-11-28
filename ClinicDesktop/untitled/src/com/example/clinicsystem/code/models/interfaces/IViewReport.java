package com.example.clinicsystem.code.models.interfaces;

import com.example.clinicsystem.code.models.classes.M_DentalReport;
import com.example.clinicsystem.code.models.classes.M_Prescription;

import java.util.List;

public interface IViewReport {
    public List<M_Prescription> viewPrescriptions();
    public List<M_DentalReport> viewReports();
}
