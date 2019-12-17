<?php
include_once "M_InvoiceDetail.php";

class M_Tax extends M_InvoiceDetail {
	private $taxPercentage;
	
	public function __construct($taxPercentage, $invoice, $price) {
		$this->taxPercentage = $taxPercentage;
		$this->price = $price;
		$this->invoice = $invoice;
	}
	
	public function setTaxPercentage($taxPercentage) {
		$this->taxPercentage = $taxPercentage;
	}
	
	public function getTaxPercentage() {
		return $this->taxPercentage;
	}
	
	public function echoTax() {
		$tax = $this->invoice->getPrice() * $this->taxPercentage / 100;
		$this->invoice->price = $this->invoice->price + $tax;
	}
}

?>