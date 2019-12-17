<?php
include_once "M_InvoiceDetail.php";

class M_InvoiceDetailEquipment extends M_InvoiceDetail {
	public function __construct($quantity, $equipmentID, $invoice, $price) {
		$this->quantity = $quantity;
		$this->equipmentID = $equipmentID;
		$this->price = $price;
		$this->invoice = $invoice;
	}
	
	public function setQuantity($quantity) {
		$this->quantity = $quantity;
	}
	
	public function getQuantity() {
		return $this->quantity;
	}
	
	public function setEquipmentID($equipmentID) {
-		$this->equipmentID = $equipmentID;
	}
	
	public function getEquipmentID() {
		return $this->equipmentID;
	}
	
	public function echoEquip() {
		$this->invoice->price = $this->invoice->price + $this->price;
	}
}


?>