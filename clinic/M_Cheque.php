<?php 

class M_Cheque {
	private $bank;
	
	public function __construct($bank) {
		$this->bank = $bank;
	}
	
	public function setBank($bank) {
		$this->bank = $bank;
	}
	
	public function getBank() {
		return $this->bank;
	}
	
}

?>