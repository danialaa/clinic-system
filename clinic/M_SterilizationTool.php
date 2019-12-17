<?php
include_once "M_Equipment.php";
class M_SterilizationTool extends M_Equipment {
    private $sterilizationType;
	public $myID;

    public function __construct($name, $equipmentType, $price, $id, $quantity, $isAvailable, $sterilizationType) {
		$this->name =          $name;
        $this->equipmentType = $equipmentType;
        $this->price =         $price;
        $this->id =            $id;
        $this->quantity =      $quantity;
        $this->isAvailable =   $isAvailable;
        $this->sterilizationType = $sterilizationType;
    }

    public function addSterilization() {
        $conn = DatabaseConnection::getINSTANCE();
		
		return $conn->insertInto("sterilization_tool", "(Equipment_ID, Sterilization_type)",
			"('". $this->myID . "', '" . $this->sterilizationType . "')");
    }

    public function getSterilizationType() {
        return $this->sterilizationType;
    }

    public function setSterilizationType($sterilizationType) {
        $this->sterilizationType = $sterilizationType;
    }
}
?>