<?php
include_once "M_Equipment.php";

class M_OperationalTool extends M_Equipment {
    private $isSterlized, $isReusable;

    public function __construct($name, $equipmentType, $price, $id, $quantity, $isAvailable, $isSterlized, $isReusable) {
        $this->name =          $name;
        $this->equipmentType = $equipmentType;
        $this->price =         $price;
        $this->id =            $id;
        $this->quantity =      $quantity;
        $this->isAvailable =   $isAvailable;
        $this->isSterlized = $isSterlized;
        $this->isReusable =  $isReusable;
    }

    public function addOperational() {
        $conn = DatabaseConnection::getINSTANCE();
		
		$sterlized = 0;
		$reusable = 0;
		
		if($this->isSterlized == TRUE) {
			$sterlized = 1;
		}
		if($this->isReusable == TRUE) {
			$reusable = 1;
		}
		
		return $conn->insertInto("operational_tool", "(Equipment_ID, Operational_IsSterlized,
			Operational_IsReusable)", "('". $this->id . "', '" . $sterlized . "', '" . $reusable . "')");
    }

    public function isSterlized() {
        return $this->isSterlized;
    }

    public function setSterlized($sterlized) {
        $this->isSterlized = $sterlized;
    }

    public function isReusable() {
        return $this->isReusable;
    }

    public function setReusable($reusable) {
        $this->isReusable = $reusable;
    }
}

?>