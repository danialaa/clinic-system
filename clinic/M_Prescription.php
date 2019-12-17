<?php
class M_Prescription {
    private $pdate;
    private $instructions;
    private $patientID, $dentistID;

    public function __construct($date, $instructions, $patientID, $dentistID) {
        $this->pdate = $date;
        $this->instructions = $instructions;
        $this->patientID = $patientID;
        $this->dentistID = $dentistID;
    }

    public function getpDate() {
        return $this->pdate;
    }

    public function setDate($pdate) {
        $this->pdate = $pdate;
    }

    public function getInstructions() {
        return $this->instructions;
    }

    public function setInstructions($instructions) {
        $this->instructions = $instructions;
    }

    public function getPatientID() {
        return $this->patientID;
    }

    public function setPatientID($patientID) {
        $this->patientID = $patientID;
    }

    public function getDentistID() {
        return $this->dentistID;
    }

    public function setDentistID($dentistID) {
        $this->dentistID = $dentistID;
    }
}

?>