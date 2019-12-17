<?php
class M_PrescriptionInstruction {
    private $drugID, $quantity, $duration, $dose;
    private $durationType, $instructionDetails;

    public function __construct($drugID,$duration,$dose,$durationType, $instructionDetails, $quantity) {
        $this->drugID =             $drugID;
        $this->duration =           $duration;
        $this->dose = 	  	        $dose;
        $this->durationType =       $durationType;
        $this->instructionDetails = $instructionDetails;
        $this->quantity = 			$quantity;
    }

    public function getDrugID() {
        return $this->drugID;
    }

    public function setDrugID($drugID) {
        $this->drugID = $drugID;
    }

    public function getDuration() {
        return $this->duration;
    }

    public function setDuration($duration) {
        $this->duration = $duration;
    }

    public function getDose() {
        return $this->dose;
    }

    public function setDose($dose) {
        $this->dose = $dose;
    }

    public function getDurationType() {
        return $this->durationType;
    }

    public function setDurationType($durationType) {
        $this->durationType = $durationType;
    }

    public function getInstructionDetails() {
        return $this->instructionDetails;
    }

    public function setInstructionDetails($instructionDetails) {
        $this->instructionDetails = $instructionDetails;
    }

    public function getQuantity() {
        return $this->quantity;
    }

    public function setQuantity($quantity) {
        $this->quantity = $quantity;
    }
?>