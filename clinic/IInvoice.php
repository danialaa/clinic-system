<?php

interface IInvoice {
	public function changePaymentStatus($status);
	public function addCreditCard($creditCard);
	public function addCheque($cheque);
}

?>