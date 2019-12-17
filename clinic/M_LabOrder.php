<?php
include_once "IAddDetail.php";

class M_LabOrder implements IAddDetail {
    private $orderID, $dentistID, $patientID, $supervisorID, $extraFees;
    private $isRemovable;
    private $ldate, $status;

    public function addDetail(M_Detail detail) {
        detail.parentID = this.orderID;
    }

    public function __construct($orderID, $dentistID, $patientID, $supervisorID, $extraFees, $isRemovable, $ldate, $status) {
        $this->orderID = $orderID;
        $this->dentistID = $dentistID;
        $this->patientID = $patientID;
        $this->supervisorID = $supervisorID;
        $this->extraFees = $extraFees;
        $this->isRemovable = $isRemovable;
        $this->ldate = $ldate;
        $this->status = $status;
    }

    public function getOrderID() {
        return $this->orderID;
    }

    public function setOrderID($orderID) {
        $this->orderID = $orderID;
    }

    public function getDentistID() {
        return $this->dentistID;
    }

    public function setDentistID($dentistID) {
        $this->dentistID = $dentistID;
    }

    public function getPatientID() {
        return $this->patientID;
    }

    public function setPatientID($patientID) {
        $this->patientID = $patientID;
    }

    public function getSupervisorID() {
        return $this->supervisorID;
    }

    public function setSupervisorID($supervisorID) {
        $this->supervisorID = $supervisorID;
    }

    public function getExtraFees() {
        return $this->extraFees;
    }

    public function setExtraFees($extraFees) {
        $this->extraFees = $extraFees;
    }

    public function isRemovable() {
        return $this->isRemovable;
    }

    public function setRemovable($removable) {
        $this->isRemovable = $removable;
    }

    public function getlDate() {
        return $this->ldate;
    }

    public function setDate($ldate) {
        $this->ldate = $ldate;
    }

    public function getStatus() {
        return $this->status;
    }

    public function setStatus($status) {
        $this->status = $status;
    }
}
?>