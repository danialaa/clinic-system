<?php
class M_EmergencyContact {
	private $contactID, $patientID;
    private $name, $relation, $phoneNumber;

    public function __construct($contactID, $patientID, $name, $relation, $phoneNumber) {
        $this->contactID =   $contactID;
        $this->patientID =   $patientID;
        $this->name =        $name;
        $this->relation =    $relation;
        $this->phoneNumber = $phoneNumber;
    }

    public function getContactID() {
        return $this->contactID;
    }

    public function setContactID($contactID) {
        $this->contactID = $contactID;
    }

    public function getPatientID() {
        return $this->patientID;
    }

    public function setPatientID($patientID) {
        $this->patientID = $patientID;
    }

    public function getName() {
        return $this->name;
    }

    public function setName($name) {
        $this->name = $name;
    }

    public function getRelation() {
        return $this->relation;
    }

    public function setRelation($relation) {
        $this->relation = $relation;
    }

    public function getPhoneNumber() {
        return $this->phoneNumber;
    }

    public function setPhoneNumber($phoneNumber) {
        $this->phoneNumber = $phoneNumber;
    }
}

?>