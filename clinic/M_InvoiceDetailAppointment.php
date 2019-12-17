<?php
include_once "M_InvoiceDetail.php";

class M_InvoiceDetailAppointment {
	private $appointmentType;
	
	public function __construct ($appointmentType, $invoice, $price) {
		$this->appointmentType = $appointmentType;
		$this->price = $price;
		$this->invoice = $invoice;
	}
	
	public function setAppointmentType($appointmentType) {
		$this->appointmentType = $appointmentType;
	}
	
	public function getAppointmentType() {
		return $this->appointmentType;
	}
}

?>