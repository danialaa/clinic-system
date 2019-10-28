package com.example.msadentistryclinic.models.interfaces;

import com.example.msadentistryclinic.models.classes.CDentalReport;
import com.example.msadentistryclinic.models.classes.CPrescription;

import java.util.List;

public interface IViewReport {
    public List<CPrescription> viewPrescriptions();
    public List<CDentalReport> viewReports();
}
