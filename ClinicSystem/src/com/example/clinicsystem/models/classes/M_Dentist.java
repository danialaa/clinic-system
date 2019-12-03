package com.example.clinicsystem.models.classes;

import com.example.clinicsystem.helpers.DatabaseConnection;
import com.example.clinicsystem.models.enums.DentistryDepartment;
import com.example.clinicsystem.models.enums.Gender;
import com.example.clinicsystem.models.interfaces.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public List<M_Dentist> getAllDentists(String condition) {
        List<M_Dentist> dentists = new ArrayList<>();
        DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();

        ResultSet resultSet = databaseConnection.select("dentist", condition);

        if(resultSet != null) {
            try {
                while (resultSet.next()) {
                    int empId = resultSet.getInt("Employee_ID");
                    int deptId = resultSet.getInt("Department_ID");
                    boolean isSuper = resultSet.getBoolean("Dentist_IsSupervisor");

                    List<M_Employee> employees = getAllEmployees(" WHERE Employee_ID = " + empId );

                    M_Dentist dentist = new M_Dentist(employees.get(0).getFirstName(), employees.get(0).getMiddleName(),
                            employees.get(0).getLastName(), employees.get(0).getPhoneNumber(), employees.get(0).getBirthDate(),
                            employees.get(0).getAddress(), employees.get(0).getNationalID(), employees.get(0).getGender(),
                            employees.get(0).getEmployeeID(), employees.get(0).getEmail(), DentistryDepartment.getConstant(deptId),
                            isSuper);
                    dentists.add(dentist);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dentists;
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
