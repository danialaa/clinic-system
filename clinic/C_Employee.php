<?php
include_once "M_Employee.php";
include_once "C_Patient.php";

class C_Employee {
    public function request($requestType, $data) {
        $employee = new M_Employee("", "", "", "", "", null, 1, "", 1, "", 1, "");

        switch ($requestType) {
            case "C":
                $employee->getAddress->setApartmentNumber($data[0]);
                $employee->getAddress->setCity($data[1]);
                $employee->getAddress->setGovernorate($data[2]);
                $employee->getAddress->setStreetName($data[3]);
                $employee->getAddress->setID($employee->addAddress);
                
                $employee->setBirthDate($data[4]);
                $employee->setFirstName($data[5]);
                $employee->setMiddleName($data[6]);
                $employee->setLastName($data[7]);
                $employee->setPhoneNumber($data[8]);
                $employee->setNationalID($data[9]);

                /* if ($data[10] == "Male"){
                    $employee->setGender(Gender.MALE);
                }else{
                    $employee->setGender(Gender.FEMALE);
                } */

                $personID = $employee->addPerson();

                $employee->setEmployeeID($data[11]);
                $employee->setEmail($data[12]);
                
                $employee->addEmployee($personID);

                return null;
            case "R":
				if($data == null) {
                    return $employee->getAllEmployees("");
                } else {
                    return $employee->getAllEmployees($data[0]);
                }
            case "U":

            case "D":
			
			default:
				return null;
        }
    }

    /* public boolean isValidEmployeeData(List<JTextField> textFieldList, List<JLabel> labelList) {
        if(TextFieldValidator.validateEmpty(textFieldList, labelList) && TextFieldValidator.validateEmail(textFieldList.get(5), labelList.get(5))) {
            return true;
        }

        return false;
    } */
}
?>