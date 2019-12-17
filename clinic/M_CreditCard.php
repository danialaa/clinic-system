<?php
class M_CreditCard {
	private $creditCardNumber, $SVV;
	private $expirationDate, $bank;
	
	public function __construct($creditCardNumber, $SVV, $expirationDate, $bank) {
		$this->creditCardNumber = $creditCardNumber;
		$this->SVV = $SVV;
		$this->expirationDate = $expirationDate;
		$this->bank = $bank;
	}
	
	public function setCreditCard($creditCardNumber) {
		$this->creditCardNumber  = $creditCardNumber;
	}
	
	public function getCreditCard() {
		return $this->creditCardNumber;
	}
	
	public function setSVV($SVV) {
		$this->SVV  = $SVV;
	}
	
	public function getSVV() {
		return $this->SVV;
	}
	
	public function setExpirationDate($expirationDate) {
		$this->expirationDate  = $expirationDate;
	}
	
	public function getExpirationDate() {
		return $this->expirationDate;
	}
	
	public function setBank($bank) {
		$this->bank  = $bank;
	}
	
	public function getCreditCard() {
		return $this->bank;
	}
	
	
	
}

?>