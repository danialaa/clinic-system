<?php
include_once "IAddDetail.php";
include_once "IInvoice.php";

class M_Invoice implements IAddDetail, IInvoice {
    private $ledgerID, $total, $issuerID, $holderID;
    private $isPaid;
    private $issuingDate, $paymentMethod, $dueDate;
	private $details;

    public function addDetail($detail) {
		array_push($detail, $this->details);
    }

    public function __construct($ledgerID, $total, $issuerID, $holderID, $isPaid, $issuingDate, $paymentMethod, $dueDate) {
        $this->ledgerID = $ledgerID;
        $this->total = $total;
        $this->issuerID = $issuerID;
        $this->holderID = $holderID;
        $this->isPaid = $isPaid;
        $this->issuingDate = $issuingDate;
        $this->paymentMethod = $paymentMethod;
        $this->dueDate = $dueDate;
    }
	
	public function changePaymentStatus($status) {
		
	}
	
	public function addCreditCard($creditCard) {
		echo "hi froom invoice";
	}
	
	public function addCheque($cheque) {
	
	}
	
    public function getLedgerID() {
        return $this->ledgerID;
    }

    public function setLedgerID($ledgerID) {
        $this->ledgerID = $ledgerID;
    }

    public function getTotal() {
        return $this->total;
    }

    public function setTotal($total) {
        $this->total = $total;
    }

    public function getIssuerID() {
        return $this->issuerID;
    }

    public function setIssuerID($issuerID) {
        $this->issuerID = $issuerID;
    }

    public function getHolderID() {
        return $this->holderID;
    }

    public function setHolderID($holderID) {
        $this->holderID = $holderID;
    }

    public function isPaid() {
        return $this->isPaid;
    }

    public function setPaid($paid) {
        $this->isPaid = $paid;
    }

    public function getIssuingDate() {
        return $this->issuingDate;
    }

    public function setIssuingDate($issuingDate) {
        $this->issuingDate = $issuingDate;
    }

    public function getPaymentMethod() {
        return $this->paymentMethod;
    }

    public function setPaymentMethod($paymentMethod) {
        $this->paymentMethod = $paymentMethod;
    }

    public function getDueDate() {
        return $this->dueDate;
    }

    public function setDueDate($dueDate) {
        $this->dueDate = $dueDate;
    }
}

?>