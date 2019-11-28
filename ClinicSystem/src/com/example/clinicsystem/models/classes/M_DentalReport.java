package com.example.clinicsystem.models.classes;

import com.example.clinicsystem.models.interfaces.IAddDetail;

public class M_DentalReport implements IAddDetail {
    private int reportID, patientID, dentistID, cavityCount, fillingDecayCount, appointmentID;
    private String date, gumStatus, xray, consentProof;
    private boolean isPatientConsent;

    @Override
    public void addDetail(M_Detail detail) {
        detail.parentID = this.reportID;
    }

    public M_DentalReport(int reportID, int patientID, int dentistID, int cavityCount, int fillingDecayCount, int appointmentID, String date, String gumStatus, String xray, String consentProof, boolean isPatientConsent) {
        this.reportID = reportID;
        this.patientID = patientID;
        this.dentistID = dentistID;
        this.cavityCount = cavityCount;
        this.fillingDecayCount = fillingDecayCount;
        this.appointmentID = appointmentID;
        this.date = date;
        this.gumStatus = gumStatus;
        this.xray = xray;
        this.consentProof = consentProof;
        this.isPatientConsent = isPatientConsent;
    }

    public M_DentalReport() {
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getDentistID() {
        return dentistID;
    }

    public void setDentistID(int dentistID) {
        this.dentistID = dentistID;
    }

    public int getCavityCount() {
        return cavityCount;
    }

    public void setCavityCount(int cavityCount) {
        this.cavityCount = cavityCount;
    }

    public int getFillingDecayCount() {
        return fillingDecayCount;
    }

    public void setFillingDecayCount(int fillingDecayCount) {
        this.fillingDecayCount = fillingDecayCount;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGumStatus() {
        return gumStatus;
    }

    public void setGumStatus(String gumStatus) {
        this.gumStatus = gumStatus;
    }

    public String getXray() {
        return xray;
    }

    public void setXray(String xray) {
        this.xray = xray;
    }

    public String getConsentProof() {
        return consentProof;
    }

    public void setConsentProof(String consentProof) {
        this.consentProof = consentProof;
    }

    public boolean isPatientConsent() {
        return isPatientConsent;
    }

    public void setPatientConsent(boolean patientConsent) {
        isPatientConsent = patientConsent;
    }
}
