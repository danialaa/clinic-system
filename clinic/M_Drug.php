<?php
include_once "M_Equipment.php";

class M_Drug extends M_Equipment {
    private $expiryDate, $productionDate;

    public function __construct($name, $equipmentType, $price, $id, $quantity, $isAvailable, $expiryDate, $productionDate) {
        $this->name =          $name;
        $this->equipmentType = $equipmentType;
        $this->price =         $price;
        $this->id =            $id;
        $this->quantity =      $quantity;
        $this->isAvailable =   $isAvailable;
        $this->expiryDate =    $expiryDate;
        $this->productionDate =$productionDate;
    }

    public function addDrug() {
		$conn = DatabaseConnection::getINSTANCE();
		
		return $conn->insertInto("drug", "(Equipment_ID, Drug_ExpiryDate, Drug_ProductionDate)", "('". 
		$this->id . "', '" . $this->expiryDate . "', '" . $this->productionDate . "')");
    }

    public function getExpiryDate() {
        return $this->expiryDate;
    }

    public function setExpiryDate($expiryDate) {
        $this->expiryDate = $expiryDate;
    }

    public function getProductionDate() {
        return $this->productionDate;
    }

    public function setProductionDate($productionDate) {
        $this->productionDate = $productionDate;
    }
}
?>