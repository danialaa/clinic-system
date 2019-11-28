package com.example.clinicsystem.code.models.classes;

import com.example.clinicsystem.code.models.enums.DentistryDepartment;

public class M_Appointment extends M_Schedule {
    private int dentistID, patientID;
    private boolean isComplete, isByPhone;
    private String startTime, endTime;
    private DentistryDepartment appointmentType;

    public M_Appointment(int ID, String date, int dentistID, int patientID, boolean isComplete, boolean isByPhone, String startTime, String endTime, DentistryDepartment appointmentType) {
        super(ID, date);
        this.dentistID = dentistID;
        this.patientID = patientID;
        this.isComplete = isComplete;
        this.isByPhone = isByPhone;
        this.startTime = startTime;
        this.endTime = endTime;
        this.appointmentType = appointmentType;
    }

    public M_Appointment() {
    }

    public int getDentistID() {
        return dentistID;
    }

    public void setDentistID(int dentistID) {
        this.dentistID = dentistID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public boolean isByPhone() {
        return isByPhone;
    }

    public void setByPhone(boolean byPhone) {
        isByPhone = byPhone;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public DentistryDepartment getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(DentistryDepartment appointmentType) {
        this.appointmentType = appointmentType;
    }
}
