package com.example.msadentistryclinic.models.classes;

import com.example.msadentistryclinic.models.enums.DentistryDepartment;
import com.example.msadentistryclinic.models.enums.Gender;
import com.example.msadentistryclinic.models.interfaces.IOrder;
import com.example.msadentistryclinic.models.interfaces.IViewAppointment;
import com.example.msadentistryclinic.models.interfaces.IViewReport;

import java.util.List;

public class CNurse extends CEmployee implements IOrder, IViewAppointment, IViewReport {
    private DentistryDepartment department;

    @Override
    public void makeLabOrder(CLabOrder labOrder) {

    }

    @Override
    public List<CAppointment> viewAppointments() {
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

    public CNurse(String firstName, String middleName, String lastName, String phoneNumber, String birthDate, CAddress address, int nationalID, Gender gender, int employeeID, DentistryDepartment department) {
        super(firstName, middleName, lastName, phoneNumber, birthDate, address, nationalID, gender, employeeID);
        this.department = department;
    }

    public CNurse() {
    }

    public DentistryDepartment getDepartment() {
        return department;
    }

    public void setDepartment(DentistryDepartment department) {
        this.department = department;
    }

    public int checkEquipmentQuantity(int equipmentID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
