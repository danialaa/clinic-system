package com.example.clinicsystem.models.classes;

import com.example.clinicsystem.models.enums.DentistryDepartment;
import com.example.clinicsystem.models.enums.Gender;
import com.example.clinicsystem.models.interfaces.*;

import java.util.List;

public class M_Dentist extends M_Employee implements IViewReport, ITransfer, IViewAppointment, IOrder, IViewPatient {
    private DentistryDepartment department;
    private boolean isSupervisor;

    @Override
    public void makeLabOrder(M_LabOrder labOrder) {

    }

    @Override
    public void transferPerson(DentistryDepartment newDepartment, int persontID) {

    }

    @Override
    public List<M_Appointment> viewAppointments() {
        return null;
    }

    @Override
    public List<M_Patient> viewPatients() {
        return null;
    }

    @Override
    public List<M_Patient> searchPatients() {
        return null;
    }

    @Override
    public List<M_Prescription> viewPrescriptions() {
        return null;
    }

    @Override
    public List<M_DentalReport> viewReports() {
        return null;
    }

    public M_Dentist(String firstName, String middleName, String lastName, String phoneNumber, String birthDate,
                     M_Address address, int nationalID, Gender gender, int employeeID, String email, DentistryDepartment department,
                     boolean isSupervisor) {
        super(firstName, middleName, lastName, phoneNumber, birthDate, address, nationalID, gender, employeeID, email);
        this.department = department;
        this.isSupervisor = isSupervisor;
    }

    public M_Dentist() {
    }

    public DentistryDepartment getDepartment() {
        return department;
    }

    public void setDepartment(DentistryDepartment department) {
        this.department = department;
    }

    public boolean isSupervisor() {
        return isSupervisor;
    }

    public void setSupervisor(boolean supervisor) {
        isSupervisor = supervisor;
    }
}
