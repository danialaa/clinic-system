<?php
include_once "M_Person.php";
include_once "M_EmergencyContact.php";
include_once "main.php";
class M_Patient extends M_Person {
	private $patientID;
    private $registrationDate;
    private $department;
    private $emergencyContact;
    private $medicalAlerts;
    //private $dentalHistory;
    //private $previousSurgeries, medications;
	private $firstName, $middleName, $lastName, $phoneNumber, $birthDate,
		$address, $nationalID, $gender;

    public function __construct($firstName, $middleName, $lastName, $phoneNumber, $birthDate,
                     $address, $nationalID, $gender, $patientID, $registrationDate,
                     $department, $emergencyContact, $medicalAlerts) {
        $this->firstName = $firstName;
		$this->middleName =$middleName;
		$this->lastName =  $lastName;
		$this->phoneNumber =$phoneNumber;
		$this->birthDate =  $birthDate;
		$this->address =    $address;
		$this->nationalID = $nationalID;
		$this->gender = 	$gender;
        $this->patientID =           $patientID;
        $this->registrationDate =    $registrationDate;
        $this->department =          $department;
        $this->emergencyContact =    $emergencyContact;
        $this->medicalAlerts =       $medicalAlerts;
        //$this->dentalHistory =     $dentalHistory;
        //$this->previousSurgeries = $previousSurgeries;
        //$this->medications =       $medications;
    }

    public function addPatient($personID) {
		$conn = DatabaseConnection::getINSTANCE();
		
		return $conn->InsertInto("patient","(Department_ID, Emergency_ID, Person_ID, Registration_Date)"
                ,"('" . array_search($this->department, main::departments) . "', '" . $this->emergencyContact->getContactID()
                        . "', '" . $personID . "', '" . $this->getRegistrationDate() . "')");
    }

    public function addEmergency() {
        $conn = DatabaseConnection::getINSTANCE();
		
		return $conn->insertInto("emergency_contact", "(Emergency_Relation, Emergency_Phone,
			Emergency_Name)", "('". $this->emergencyContact->getRelation() . "', '" .
			$this->emergencyContact->getPhone() . "', '" . $this->emergencyContact->getName() . "')");
    }

    public function updateEmergency($column) {
        if($column == "pid") {
			$conn = DatabaseConnection::getINSTANCE();
			$conn->update("emergency_contact",
                    "Patient_ID = '" . $this->getEmergencyContact()->getPatientID()
						. "'", $this->emergencyContact->getContactID(), 
						"Emergency_ID");
		}
    }

    public function getAllEmergencyContacts($condition){
        $conn = DatabaseConnection::getINSTANCE();
		
		$result = $conn->select("emergency_contact", $condition);
		$emergencies = array();
		
		while ($row = $result->fetch_assoc()) {
			$emergency = new M_EmergencyContact($row["Emergency_ID"], $row["Patient_ID"]
				, $row["Emergency_Name"], $row["Emergency_Relation"]
				, $row["Emergency_Phone"]);
			array_push($emergencies, $emergency);
		}
		
		return $emergencies;
    }

    public function getAllPatients($condition){
        $conn = DatabaseConnection::getINSTANCE();
		
		$result = $conn->select("patient", $condition);
		$patients = array();
		
		while ($row = $result->fetch_assoc()) {
			$emergencies = $this->getAllEmergencyContacts(" WHERE Emergency_ID = " . 
				$row["Emergency_ID"]);
			$people = $this->getAllPersons(" WHERE Person_ID = " . $row["Person_ID"]);
		
			$patient = new M_Patient($people[0]->getFirstName(), $people[0]->getMiddleName()
				, $people[0]->getLastName(), $people[0]->getPhoneNumber(), $people[0]->getBirthDate()
				, $people[0]->getAddress(), $people[0]->getNationalID(), 2
				, $row["Person_ID"], "", 1, $emergencies[0], null);
			
			
			array_push($patients, $patient);
		}
		
		return $patients;
    }

    public function getPatientID() {
        return $this->patientID;
    }

    public function setPatientID($patientID) {
        $this->patientID = $patientID;
    }

    public function getRegistrationDate() {
        return $this->registrationDate;
    }

    public function setRegistrationDate($registrationDate) {
        $this->registrationDate = $registrationDate;
    }

    public function getDepartment() {
        return $this->department;
    }

    public function setDepartment($department) {
        $this->department = $department;
    }

    public function getEmergencyContact() {
        return $this->emergencyContact;
    }

    public function setEmergencyContact($emergencyContact) {
        $this->emergencyContact = $emergencyContact;
    }

    public function getMedicalAlerts() {
        return $this->medicalAlerts;
    }

    public function setMedicalAlerts($medicalAlerts) {
        $this->medicalAlerts = $medicalAlerts;
    }

    /*public function getDentalHistory() {
        return $this->dentalHistory;
    }

    public function setDentalHistory($dentalHistory) {
        $this->dentalHistory = $dentalHistory;
    }

    public function getPreviousSurgeries() {
        return $this->previousSurgeries;
    }

    public function setPreviousSurgeries($previousSurgeries) {
        $this->previousSurgeries = $previousSurgeries;
    }

    public function getMedications() {
        return $this->medications;
    }

    public function setMedications($medications) {
        $this->medications = $medications;
    }*/
	
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