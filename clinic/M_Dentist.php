<?php
include_once "M_Employee.php";
include_once "IViewReport.php";
include_once "ITransfer.php";
include_once "IViewAppointment.php";
include_once "IOrder.php";
include_once "IViewPatient.php";
include_once "main.php";

class M_Dentist extends M_Employee implements IViewReport, ITransfer, IViewAppointment, IOrder, IViewPatient {
	private $department;
    private $isSupervisor;

    public function __construct($firstName, $middleName, $lastName, $phoneNumber, $birthDate,
                     $address, $nationalID, $gender, $employeeID, $email, $department,
                     $isSupervisor) {
        $this->firstName = $firstName;
		$this->middleName =$middleName;
		$this->lastName =  $lastName;
		$this->phoneNumber =$phoneNumber;
		$this->birthDate =  $birthDate;
		$this->address =    $address;
		$this->nationalID = $nationalID;
		$this->gender = 	$gender;
        $this->employeeID = $employeeID;
        $this->email =      $email;
        $this->department =   $department;
        $this->isSupervisor = $isSupervisor;
    }


    public function getAllDentists($condition) {
        $conn = DatabaseConnection::getINSTANCE();
		
		$result = $conn->select("dentist", $condition);
		$dentists = array();
		
		while ($row = $result->fetch_assoc()) {
			$employees = $this->getAllEmployees(" WHERE Employee_ID = " . $row["Employee_ID"]);
			
			$dentist = new M_Dentist($employees[0]->getFirstName(), $employees[0]->getMiddleName()
				, $employees[0]->getLastName(), $employees[0]->getPhoneNumber(), $employees[0]->getPhoneNumber()
				, $employees[0]->getBirthDate(), $employees[0]->getAddress(), $employees[0]->getNationalID()
				, $employees[0]->getGender(), $row["Employee_ID"], $employees[0]->getEmail()
				, 1, $row["Dentist_IsSupervisor"]);
			$dentist->setFirstName($employees[0]->getFirstName());
			$dentist->setLastName($employees[0]->getLastName());
			
			array_push($dentists, $dentist);
		}
		
		return $dentists;
    }
	
	public function makeLabOrder($labOrder) {

    }

    public function transferPerson($newDepartment, $persontID) {

    }

    public function viewAppointments() {
        
    }

    public function viewPatients() {
        
    }

    public function searchPatients() {
        
    }

    public function viewPrescriptions() {
        
    }

    public function viewReports() {
        
    }
	
    public function getDepartment() {
        return $this->department;
    }

    public function setDepartment($department) {
        $this->department = $department;
    }

    public function isSupervisor() {
        return $this->isSupervisor;
    }

    public function setSupervisor($supervisor) {
        $this->isSupervisor = $supervisor;
    }
}

?>