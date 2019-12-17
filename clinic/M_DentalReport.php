<?php
include_once "IAddDetail.php";

class M_DentalReport implements IAddDetail {
    private $reportID, $patientID, $dentistID, $cavityCount, $fillingDecayCount, $appointmentID;
    private $ddate, $gumStatus, $xray, $consentProof;
    private $isPatientConsent;

    public function addDetail($detail) {
        $detail->parentID = $this->reportID;
    }

    public function __construct($reportID, $patientID, $dentistID, $cavityCount, $fillingDecayCount, $appointmentID, $ddate, $gumStatus, $xray, $consentProof, $isPatientConsent) {
        $this->reportID = 			$reportID;
        $this->patientID = 			$patientID;
        $this->dentistID = 			$dentistID;
        $this->cavityCount = 		$cavityCount;
        $this->fillingDecayCount =  $fillingDecayCount;
        $this->appointmentID = 		$appointmentID;
        $this->ddate = 				$ddate;
        $this->gumStatus = 			$gumStatus;
        $this->xray = 				$xray;
        $this->consentProof = 		$consentProof;
        $this->isPatientConsent = 	$isPatientConsent;
    }

    public function getReportID() {
        return $this->reportID;
    }

    public function setReportID($reportID) {
        $this->reportID = reportID;
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

    public function getCavityCount() {
        return $this->cavityCount;
    }

    public function setCavityCount($cavityCount) {
        $this->cavityCount = $cavityCount;
    }

    public function getFillingDecayCount() {
        return $this->fillingDecayCount;
    }

    public function setFillingDecayCount($fillingDecayCount) {
        $this->fillingDecayCount = $fillingDecayCount;
    }

    public function getAppointmentID() {
        return $this->appointmentID;
    }

    public function setAppointmentID($appointmentID) {
        $this->appointmentID = $appointmentID;
    }

    public function getdDate() {
        return $this->ddate;
    }

    public function setDate($ddate) {
        $this->ddate = $ddate;
    }

    public function getGumStatus() {
        return $this->gumStatus;
    }

    public function setGumStatus($gumStatus) {
        $this->gumStatus = $gumStatus;
    }

    public function getXray() {
        return $this->xray;
    }

    public function setXray($xray) {
        $this->xray = $xray;
    }

    public function getConsentProof() {
        return $this->consentProof;
    }

    public function setConsentProof($consentProof) {
        $this->consentProof = $consentProof;
    }

    public function isPatientConsent() {
        return $this->isPatientConsent;
    }

    public function setPatientConsent($patientConsent) {
        $this->isPatientConsent = $patientConsent;
    }
}
?>