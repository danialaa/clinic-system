<?php
include_once "M_Patient.php";

class C_Patient {
    public function request($requestType, $data) {
        $patient = new M_Patient();

        switch ($requestType) {
            case "C":
                $patient->setFirstName($data(0));
                $patient->setMiddleName($data(1));
                $patient->setLastName($data(2));
                $patient->setPhoneNumber($data(3));
                $patient->setBirthDate($data(4));
                $patient->setNationalID($data(5));
                //$patient->setGender(Gender.getConstant(data(6));

                $ddate = date("Y-m-d");
                $patient->setRegistrationDate($ddate);

                $patient->getAddress()->setGovernorate($data(7));
                $patient->getAddress()->setCity($data(8));
                $patient->getAddress()->setStreetName($data(9));
                $patient->getAddress()->setApartmentNumber($data(10));
                $patient->getEmergencyContact()->setName($data(11));
                $patient->getEmergencyContact()->setRelation($data(12));
                $patient->getEmergencyContact()->setPhoneNumber($data(13));
                //$patient->setDepartment(DentistryDepartment.getConstant($data(14)));
				
				$data_Count = count($data);
				
                /*for(int i=15; i<$data_Count; i++) {
                       $patient->getMedicalAlerts()->add(MedicalAlert.getConstant(data.get(i).toString()));
                }*/

                $patient->getAddress()->setId($patient->addAddress());
                $personID = $patient->addPerson();
                $patient->getEmergencyContact()->setContactID($patient->addEmergency());
                $patient->getEmergencyContact()->setPatientID($patient->addPatient(personID));
                $patient->updateEmergency("pid");

                return null;

            case "R":
                if($data == null) {
                    return $patient->getAllPatients("");
                } else {           
                    return $patient->getAllPatients($data(0));
                }

            case "U":

            case "D":

        }

        return null;
    }

    public function isValidPatient($textFields , $labels) {
        if($TextFieldValidator->validateEmpty($textFields, $labels)) {
            return true;
        }

        return false;
    }
}
?>