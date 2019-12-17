<?php
include_once "M_Detail.php";
include_once "IInvoice.php";

class M_InvoiceDetail extends M_Detail implements IInvoice {
	protected $price;
    protected $invoice;

    public function __construct($detailID, $invoice, $price) {
        $this->detailID = $detailID;
		$this->price = $price;
		$this->invoice = $invoice;
    }
	
	public function changePaymentStatus($status) {
		
	}
	
	public function addCreditCard($creditCard) {
		echo $this->price;
	}
	
	public function addCheque($cheque) {
	
	}
	
	public function setPrice($price) {
		$this->price = $price;
	}
	
	public function getPrice() {
		return $this->price;
	}
	
	 public function getInvoice() {
        return $this->invoice;
    }

    public function setInvoice($invoice) {
        $this->invoice = $invoice;
    }

    public function getQuantity() {
        return $this->quantity;
    }

    public function setQuantity($quantity) {
        $this->quantity = $quantity;
    }

    public function getEquipment() {
        return $this->equipment;
    }

    public function setEquipment($equipment) {
        $this->equipment = $equipment;
    }
}

?>