<?php
include_once "M_Address.php";
include_once "DatabaseConnection.php";

class M_Person {
	private  $firstName, $middleName, $lastName, $phoneNumber, $birthDate;
    private  $address; //Object from M_Address.
    private  $nationalID;
    private  $gender; //Enum Gender.
	
	public function __construct($firstName, $middleName, $lastName, $phoneNumber, $birthDate
	, $address, $nationalID, $gender) {
		$this->firstName = $firstName;
		$this->middleName =$middleName;
		$this->lastName =  $lastName;
		$this->phoneNumber =$phoneNumber;
		$this->birthDate =  $birthDate;
		$this->address =    $address;
		$this->nationalID = $nationalID;
		$this->gender = 	$gender;
	}
	
	public function addAddress() {
		$conn = DatabaseConnection::getINSTANCE();
		
		return $conn->insertInto("address", "(Address_City, Address_Street, Address_Apartment, Address_Governorate)", "('". 
		$this->address->getCity() . "', '" . $this->address->getStreetName() . "', '" . $this->address->getApartmentNumber() .
		"', '" . $this->address->getGovernorate() . "')");
	}
	
	public function getAllAddresses($condition) {
        $conn = DatabaseConnection::getINSTANCE();
		
		$result = $conn->select("address", $condition);
		$addresses = array();
		
		while ($row = $result->fetch_assoc()) {
			$address = new M_Address($row["Address_ID"], $row["Address_City"]
				,$row["Address_Street"],$row["Address_Governorate"],$row["Address_Apartment"]);
			array_push($addresses, $address);
		}
		
		return $addresses;
    }

	public function getAllPersons($condition) {
		$conn = DatabaseConnection::getINSTANCE();
		
		$result = $conn->select("person", $condition);
		$people = array();
		
		if($result != null) {
			while ($row = $result->fetch_assoc()) {
				$addresses = $this->getAllAddresses(" WHERE Address_ID = " . 
					$row["Address_ID"]);
					
					$gender = "Female";
					
					if($row["Gender_ID"] == 1) {
						$gender = "Male";
					}
				
				$person = new M_Person($row["Person_FN"], $row["Person_MN"]
					, $row["Person_LN"],$row["Person_Phone"], $row["Person_Birth"]
					, $addresses[0], $row["Person_NationalID"], $gender);
				array_push($people, $person);
			}
		}
		
		return $people;
	}
	
	public function addPerson() {
		$conn = DatabaseConnection::getINSTANCE();
		
		$genderID = 1;
		
		if($this->gender == "female") {
			$genderID = 2;
		}
		
		return $conn->insertInto("person", "(Person_FN, Person_MN, Person_LN, Person_Phone,
			Person_Birth, Person_NationalID, Address_ID, Gender_ID)", "('" . $this->firstName . "', '" .
			$this->middleName . "', '" . $this->lastName . "', '" . $this->phoneNumber . "', '" .
			$this->birthDate . "', '" . $this->address->getID() . "', '" . $this->nationalID . "', '" . 
			$genderID . "')");
	}
	
	public function getFirstName() {
        return $this->firstName;
    }

    public function setFirstName($firstName) {
        $this->firstName = $firstName;
    }

    public function getMiddleName() {
        return $this->middleName;
    }

    public function setMiddleName($middleName) {
        $this->middleName = $middleName;
    }

    public function getLastName() {
        return $this->lastName;
    }

    public function setLastName($lastName) {
        $this->lastName = $lastName;
    }

    public function getPhoneNumber() {
        return $this->phoneNumber;
    }

    public function setPhoneNumber($phoneNumber) {
        $this->phoneNumber = $phoneNumber;
    }

    public function getBirthDate() {
        return $this->birthDate;
    }

    public function setBirthDate($birthDate) {
        $this->birthDate = $birthDate;
    }

    public function getAddress() {
        return $this->address;
    }

    public function setAddress($address) {
        $this->address = $address;
    }

    public function getNationalID() {
        return $this->nationalID;
    }

    public function setNationalID($nationalID) {
        $this->nationalID = $nationalID;
    }

    public function getGender() {
        return $this->gender;
    }

    public function setGender($gender) {
        $this->gender = $gender;
    }



}



?>