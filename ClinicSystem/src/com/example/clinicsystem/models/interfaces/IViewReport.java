package com.example.clinicsystem.models.interfaces;


import com.example.clinicsystem.models.classes.M_DentalReport;
import com.example.clinicsystem.models.classes.M_Prescription;

import java.util.List;

public interface IViewReport {
    List<M_Prescription> viewPrescriptions();
    List<M_DentalReport> viewReports();
}
