package com.example.msadentistryclinic.models.classes;

import com.example.msadentistryclinic.models.enums.DentistryDepartment;
import com.example.msadentistryclinic.models.enums.Gender;
import com.example.msadentistryclinic.models.interfaces.ITransfer;
import com.example.msadentistryclinic.models.interfaces.IViewAppointment;
import com.example.msadentistryclinic.models.interfaces.IViewPatient;

import java.util.List;

public class CReceptionist extends CEmployee implements IViewPatient, IViewAppointment, ITransfer {
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

    public CReceptionist(String firstName, String middleName, String lastName, String phoneNumber, String birthDate, CAddress address, int nationalID, Gender gender, int employeeID) {
        super(firstName, middleName, lastName, phoneNumber, birthDate, address, nationalID, gender, employeeID);
    }

    public CReceptionist() {
    }

    public void addToSchedule(CSchedule schedule) {
    }

    public boolean isAvailable(int dentistID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isAvailable(String date) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isAvailableRoom(int roomID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
