package com.example.msadentistryclinic.models.classes;

import com.example.msadentistryclinic.models.enums.DentistryDepartment;
import com.example.msadentistryclinic.models.enums.Gender;
import com.example.msadentistryclinic.models.interfaces.IOrder;
import com.example.msadentistryclinic.models.interfaces.ITransfer;
import com.example.msadentistryclinic.models.interfaces.IViewAppointment;
import com.example.msadentistryclinic.models.interfaces.IViewPatient;
import com.example.msadentistryclinic.models.interfaces.IViewReport;

import java.util.List;

public class CDentist extends CEmployee implements IViewReport, ITransfer, IViewAppointment, IOrder, IViewPatient {
    private DentistryDepartment department;
    private boolean isSupervisor;

    @Override
    public void makeLabOrder(CLabOrder labOrder) {

    }

    @Override
    public void transferPerson(DentistryDepartment newDepartment, int persontID) {

    }

    @Override
    public List<CAppointment> viewAppointments() {
        return null;
    }

    @Override
    public List<CPatient> viewPatients() {
        return null;
    }

    @Override
    public List<CPatient> searchPatients() {
        return null;
    }

    @Override
    public List<CPrescription> viewPrescriptions() {
        return null;
    }

    @Override
    public List<CDentalReport> viewReports() {
        return null;
    }

    public CDentist(String firstName, String middleName, String lastName, String phoneNumber, String birthDate, CAddress address, int nationalID, Gender gender, int employeeID, DentistryDepartment department, boolean isSupervisor) {
        super(firstName, middleName, lastName, phoneNumber, birthDate, address, nationalID, gender, employeeID);
        this.department = department;
        this.isSupervisor = isSupervisor;
    }

    public CDentist() {
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
