package com.example.clinicsystem.models.classes;

import com.example.clinicsystem.helpers.DatabaseConnection;
import com.example.clinicsystem.models.enums.DentistryDepartment;
import com.example.clinicsystem.models.enums.Gender;
import com.example.clinicsystem.models.enums.MedicalAlert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class M_Patient extends M_Person {
    private int patientID;
    private String registrationDate;
    private DentistryDepartment department;
    private M_EmergencyContact emergencyContact;
    private int EmergencyContact;
    private List<MedicalAlert> medicalAlerts;
    //private List<CDentalHistory> dentalHistory;
    private List<String> previousSurgeries, medications;

    public M_Patient(String firstName, String middleName, String lastName, String phoneNumber, String birthDate,
                     M_Address address, int nationalID, Gender gender, int patientID, String registrationDate,
                     DentistryDepartment department, M_EmergencyContact emergencyContact, List<MedicalAlert> medicalAlerts,
                     List<String> previousSurgeries, List<String> medications) {
        super(firstName, middleName, lastName, phoneNumber, birthDate, address, nationalID, gender);
        this.patientID = patientID;
        this.registrationDate = registrationDate;
        this.department = department;
        this.emergencyContact = emergencyContact;
        this.medicalAlerts = medicalAlerts;
        //this.dentalHistory = dentalHistory;
        this.previousSurgeries = previousSurgeries;
        this.medications = medications;
    }

    public M_Patient(String firstName, String middleName, String lastName, String phoneNumber, String birthDate,
                     M_Address address, int nationalID, Gender gender, int patientID, String registrationDate,
                     DentistryDepartment department, int emergencyContact) {
        super(firstName, middleName, lastName, phoneNumber, birthDate, address, nationalID, gender);
        this.patientID = patientID;
        this.registrationDate = registrationDate;
        this.department = department;
        this.EmergencyContact = emergencyContact;
        //this.medicalAlerts = medicalAlerts;
        //this.dentalHistory = dentalHistory;
        //this.previousSurgeries = previousSurgeries;
        //this.medications = medications;
    }

    public M_Patient() {
        medicalAlerts = new ArrayList<>();
        emergencyContact = new M_EmergencyContact();
    }

    public int addPatient(int personID,int Emergency_ID) {
       return DatabaseConnection.getINSTANCE().insertInto("patient"
                ,"(Department_ID,Emergency_ID,Person_ID,Regestration_Date)"
                ,"('" + this.department.getId() + "', '" + Emergency_ID
                        + "', '" + personID + "', '" + this.getRegistrationDate() + "')");
    }

    public int addEmergency() {
        return DatabaseConnection.getINSTANCE().insertInto("emergency_contact"
                ,"(Emergency_Name, Emergency_Phone, Emergency_Relation)"
                ,"('" + this.emergencyContact.getName() + "', '" + this.emergencyContact.getPhoneNumber()
                        + "', '" + this.emergencyContact.getRelation() + "')");
    }
    public void updateEmergency(int Patient_ID) {
        DatabaseConnection.getINSTANCE().insertInto("emergency_contact"
        ,"(Patient_ID)", "('" + patientID + "')");
    }

    public List<M_Patient> getAllPatients(String condition){
        List<M_Patient> patients = new ArrayList<>();
        DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();
        ResultSet resultSet = databaseConnection.select("patient", condition);

        if(resultSet != null) {
            try {
                while (resultSet.next()) {
                    int id = resultSet.getInt("Patient_ID");
                    int departmentId = resultSet.getInt("Department_ID");
                    String registrationDate = resultSet.getString("Registration_Date");
                    int emergencyId = resultSet.getInt("Emergency_ID");

                    List<M_Person> people = getAllPersons(" WHERE Person_ID = " + resultSet.getInt("Person_ID"));

                    M_Patient patient = new M_Patient(people.get(0).getFirstName(), people.get(0).getMiddleName(),
                            people.get(0).getLastName(), people.get(0).getPhoneNumber(), people.get(0).getBirthDate(),
                            people.get(0).getAddress(), people.get(0).getNationalID(), people.get(0).getGender(),
                            id, registrationDate, DentistryDepartment.DIAGNOSIS, EmergencyContact);

                    patients.add(patient);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return patients;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public DentistryDepartment getDepartment() {
        return department;
    }

    public void setDepartment(DentistryDepartment department) {
        this.department = department;
    }

    public M_EmergencyContact getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(M_EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public List<MedicalAlert> getMedicalAlerts() {
        return medicalAlerts;
    }

    public void setMedicalAlerts(List<MedicalAlert> medicalAlerts) {
        this.medicalAlerts = medicalAlerts;
    }

    /*public List<CDentalHistory> getDentalHistory() {
        return dentalHistory;
    }

    public void setDentalHistory(List<CDentalHistory> dentalHistory) {
        this.dentalHistory = dentalHistory;
    }*/

    public List<String> getPreviousSurgeries() {
        return previousSurgeries;
    }

    public void setPreviousSurgeries(List<String> previousSurgeries) {
        this.previousSurgeries = previousSurgeries;
    }

    public List<String> getMedications() {
        return medications;
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }
}
