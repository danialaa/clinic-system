<?php

class M_InvoiceDetailReport {
	private $reportType;
	
	public function __construct($reportType, $invoice, $price) {
		$this->reportType = $reportType;
		$this->price = $price;
		$this->invoice = $invoice;
	}
	
	public function setReportType($reportType) {
		$this->reportType = $reportType;
	}
	
	public function getReportType() {
		return $this->reportType;
	}
}

?>