<?php

class M_Address {
	private $id;
    private $city, $streetName, $governorate, $apartmentNumber;
	
	public function __construct($id, $city, $streetName, $governorate, $apartmentNumber) {
		$this->id=$id;
		$this->city=$city;
		$this->streetName=$streetName;
		$this->governorate=$governorate;
		$this->apartmentNumber=$apartmentNumber;
	}
	
	public function getID() {
        return $this->id;
    }

    public function setID($id) {
        $this->id=$id;
    }

    public function getCity() {
        return $this->city;
    }

    public function setCity($city) {
        $this->city=$city;
    }

    public function getStreetName() {
        return $this->streetName;
    }

    public function setStreetName($streetName) {
        $this->streetName=$streetName;
    }

    public function getGovernorate() {
        return $this->governorate;
    }

    public function setGovernorate($governorate) {
        $this->governorate=$governorate;
    }

    public function getApartmentNumber() {
        return $this->apartmentNumber;
    }

    public function setApartmentNumber($apartmentNumber) {
        $this->apartmentNumber=$apartmentNumber;
    }
}

?>