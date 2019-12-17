<?php
include "DatabaseConnection.php";

class M_Equipment {
	private $name;
    private $equipmentType;
    private $price, $id, $quantity;
    private $isAvailable;

    public function __construct($name, $equipmentType, $price, $id, $quantity, $isAvailable) {
        $this->name =          $name;
        $this->equipmentType = $equipmentType;
        $this->price =         $price;
        $this->id =            $id;
        $this->quantity =      $quantity;
        $this->isAvailable =   $isAvailable;
    }

    public function addEquipment() {
        $conn = DatabaseConnection::getINSTANCE();
		
		$available = 0;
		
		if($this->isAvailable == TRUE) {
			$available = 1;
		}
		
		return $conn->insertInto("equipment", "(Equipment_Type, Equipment_Name, Equipment_Price, 
			Equipment_Quantity, Equipment_IsAvailable)", "('". $this->equipmentType . "', '" .
			$this->name . "', '" . $this->price . "', '" . $this->quantity . "', '" . $available . "')");
    }
	
	public function getAllEquipment($condition) {
        $conn = DatabaseConnection::getINSTANCE();
		
		$result = $conn->select("equipment", $condition);
		$equipments = array();
		
		while ($row = $result->fetch_assoc()) {
			$available = FALSE;
			
			if($row["Equipment_IsAvailable"] == 1) {
				$available = TRUE;
			}
			
			$equipment = new M_Equipment($row["Equipment_Name"], $row["Equipment_Type"],
						$row["Equipment_Price"], $row["Equipment_ID"],
						$row["Equipment_Quantity"], $available);
			array_push($equipments, $equipment);
		}
		
		return $equipments;
    }

    public function getName() {
        return $this->name;
    }

    public function setName($name) {
        $this->name = $name;
    }

    public function getEquipmentType() {
        return $this->equipmentType;
    }

    public function setEquipmentType($equipmentType) {
        $this->equipmentType = $equipmentType;
    }

    public function getPrice() {
        return $this->price;
    }

    public function setPrice($price) {
        $this->price = $price;
    }

    public function isAvailable() {
        return $this->isAvailable;
    }

    public function setAvailable($available) {
        $this->isAvailable = $available;
    }

    public function getId() {
        return $this->id;
    }

    public function setId($id) {
        $this->id = $id;
    }

    public function getQuantity() {
        return $this->quantity;
    }

    public function setQuantity($quantity) {
        $this->quantity = $quantity;
    }
}

?>