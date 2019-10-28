package com.example.msadentistryclinic.models.classes;

import com.example.msadentistryclinic.models.enums.Tooth;

public class CDentalReportDetail extends CDetail {
    private Tooth tooth;
    private String diagnosis, neededProcedure, shade, treatmentPlan;
    private int size;

    public CDentalReportDetail(int detailID, int parentID, Tooth tooth, String diagnosis, String neededProcedure, String shade, String treatmentPlan, int size) {
        super(detailID, parentID);
        this.tooth = tooth;
        this.diagnosis = diagnosis;
        this.neededProcedure = neededProcedure;
        this.shade = shade;
        this.treatmentPlan = treatmentPlan;
        this.size = size;
    }

    public CDentalReportDetail() {
    }

    public Tooth getTooth() {
        return tooth;
    }

    public void setTooth(Tooth tooth) {
        this.tooth = tooth;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getNeededProcedure() {
        return neededProcedure;
    }

    public void setNeededProcedure(String neededProcedure) {
        this.neededProcedure = neededProcedure;
    }

    public String getShade() {
        return shade;
    }

    public void setShade(String shade) {
        this.shade = shade;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setTreatmentPlan(String treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
