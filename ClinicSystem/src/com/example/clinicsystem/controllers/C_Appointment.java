package com.example.clinicsystem.controllers;

import com.example.clinicsystem.models.classes.M_Appointment;
import com.example.clinicsystem.models.classes.M_Patient;
import com.example.clinicsystem.models.enums.DentistryDepartment;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class C_Appointment {
    public List request(String requestType, List list) {
        M_Appointment appointment = new M_Appointment();

        switch (requestType) {
            case "C":
                if(isValidAppointmentData(Integer.parseInt(list.get(0).toString()))){
                    appointment.setPatientID(Integer.parseInt(list.get(0).toString()));
                    appointment.setDentistID(Integer.parseInt(list.get(1).toString()));
                    appointment.setAppointmentType(DentistryDepartment.getConstant(list.get(2).toString()));
                    appointment.setDate(list.get(3).toString());
                    appointment.setByPhone((boolean)list.get(4));
                    appointment.setStartTime(list.get(5).toString());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Patient not Found");
                }

                return null;
            case "R":
                if(list == null) {
                    return appointment.getAllAppointments("");
                } else {
                    return appointment.getAllAppointments(list.get(0).toString());
                }

            case "U":

            case "D":

        }

        return null;
    }
    public boolean isValidAppointmentData(int PID){
        C_Patient patientController = new C_Patient();
        List<String> data = new ArrayList<>();
        String condition = " WHERE Patient_ID = " + PID;
        data.add(condition);
        List<M_Patient> result = patientController.request("R", data);

        for(int i = 0 ; i < result.size() ; i++)
        {
            if(Integer.compare(result.get(i).getPatientID(), PID) == 0){
                 return true;
            }
        }

        return false;
    }
}
