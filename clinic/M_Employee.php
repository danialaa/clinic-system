<?php
include_once "M_Person.php";

class M_Employee extends M_Person {
	private $employeeID;
    private $email;
    private $firstName, $middleName, $lastName, $phoneNumber, $birthDate,
		$address, $nationalID, $gender;
    public function __construct($firstName, $middleName, $lastName, $phoneNumber, $birthDate,
		$address, $nationalID, $gender, $employeeID, $email) {
        $this->firstName =   $firstName;
		$this->middleName =  $middleName;
		$this->lastName =    $lastName;
		$this->phoneNumber = $phoneNumber;
		$this->birthDate =   $birthDate;
		$this->address =     $address;
		$this->nationalID =  $nationalID;
		$this->gender = 	 $gender;
        $this->employeeID =  $employeeID;
        $this->email      =  $email;
    }

    public function getAllEmployees($condition) {
        $conn = DatabaseConnection::getINSTANCE();
		
		$result = $conn->select("employee", $condition);
		$employees = array();
		
		while ($row = $result->fetch_assoc()) {
			$people = $this->getAllPersons(" WHERE Person_ID = " . 
				$row["Person_ID"]);
			$addresses = $this->getAllAddresses(" WHERE Address_ID = " . 
				$people[0]->getAddress()->getID());
			
			$employee = new M_Employee($people[0]->getFirstName(), $people[0]->getMiddleName()
				, $people[0]->getLastName(),$people[0]->getPhoneNumber(), $people[0]->getBirthDate()
				, $addresses[0], $people[0]->getNationalID(), $people[0]->getGender()
				, $row["Employee_ID"], $row["Employee_Email"]);
			array_push($employees, $employee);
		}
		
		return $employees;
    }

    public function addEmployee($person) {
        $conn = DatabaseConnection::getINSTANCE();
		
		return $conn->insertInto("employee", "(Employee_ID, Person_ID, Employee_Email)", "('". 
		$this->employeeID . "', '" . $person . "', '" . $this->email . "')");
    }

    public function getEmployeeID() {
        return $this->employeeID;
    }

    public function setEmployeeID($employeeID) {
        $this->employeeID = $employeeID;
    }

    public function getEmail() {
        return $this->email;
    }

    public function setEmail($email) {
        $this->email = $email;
    }

    public function getFirstName() {
        return $this->firstName;
    }

    public function setFirstName($firstName) {
        $this->firstName = $firstName;
    }

    public function getMiddleName() {
        return parent::getMiddleName();
    }

    public function setMiddleName($middleName) {
        parent::setMiddleName($middleName);
    }

    public function getLastName() {
        return parent::getLastName();
    }

    public function setLastName($lastName) {
        parent::setLastName($lastName);
    }

    public function getPhoneNumber() {
        return parent::getPhoneNumber();
    }

    public function setPhoneNumber($phoneNumber) {
        parent::setPhoneNumber($phoneNumber);
    }

    public function getBirthDate() {
        return parent::getBirthDate();
    }

    public function setBirthDate($birthDate) {
        parent::setBirthDate($birthDate);
    }

    public function getAddress() {
        return parent::getAddress();
    }

    public function setAddress($address) {
        parent::setAddress($address);
    }

    public function getNationalID() {
        return parent::getNationalID();
    }

    public function setNationalID($nationalID) {
        parent::setNationalID($nationalID);
    }

    public function getGender() {
        return parent::getGender();
    }

    public function setGender($gender) {
        $this->gender = $gender;
    }
}

?>