package com.example.clinicsystem.models.classes;


import com.example.clinicsystem.helpers.DatabaseConnection;
import com.example.clinicsystem.models.enums.DentistryDepartment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class M_Appointment extends M_Schedule {
    private int dentistID, patientID;
    private boolean isByPhone;
    private String startTime, endTime, status, dentistName, patientName;
    private DentistryDepartment appointmentType;

    public M_Appointment(int ID, String date, int dentistID, int patientID, boolean isByPhone, String startTime, String endTime, String status, DentistryDepartment appointmentType) {
        super(ID, date);
        this.dentistID = dentistID;
        this.patientID = patientID;
        this.isByPhone = isByPhone;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.appointmentType = appointmentType;
    }

    public M_Appointment() {
    }

    public List<M_Appointment> getAllAppointments(String condition) {
        List<M_Appointment> appointments = new ArrayList<>();
        DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();
        ResultSet resultSet = databaseConnection.select("appointment", condition);

        if(resultSet != null) {
            try {
                while (resultSet.next()) {
                    int id = resultSet.getInt("Schedule_ID");
                    String finishTime = resultSet.getString("Appointment_FinishTime");
                    String startTime = resultSet.getString("Appointment_StartTime");
                    String status = resultSet.getString("Appointment_Status");
                    boolean phone = false;

                    if(resultSet.getString("Appointment_Type").equals("By Phone")) {
                        phone = true;
                    }

                    M_Patient patient = new M_Patient();
                    List<M_Patient> patients = patient.getAllPatients(" WHERE Person_ID = " + resultSet.getInt("Patient_ID"));
                    M_Dentist dentist = new M_Dentist();
                    List<M_Dentist> dentists = dentist.getAllDentists(" WHERE Employee_ID = " + resultSet.getInt("Employee_ID"));
                    List<M_Schedule> schedules = getAllSchedules(" WHERE Schedule_ID = " + id);

                    M_Appointment appointment = new M_Appointment(id, schedules.get(0).getDate(), dentists.get(0).getEmployeeID(),
                            patients.get(0).getPatientID(), phone, startTime, finishTime, status,
                            DentistryDepartment.getConstant(resultSet.getInt("Department_ID")));
                    appointment.setPatientName(patients.get(0).getFirstName() + " " + patients.get(0).getLastName());
                    appointment.setDentistName(dentists.get(0).getFirstName() + " " + dentists.get(0).getLastName());

                    appointments.add(appointment);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return appointments;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DentistryDepartment getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(DentistryDepartment appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getDentistName() {
        return dentistName;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
