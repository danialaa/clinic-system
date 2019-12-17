<?php
include_once "M_Equipment.php";

class M_DentalEngine extends M_Equipment{
	private $isMaintained, $isOccupied;
	private $roomID;
	
	public function __construct($name, $equipmentType, $price, $id, $quantity,
                           $isAvailable, $isMaintained, $isOccupied, $roomID) {
		$this->name =          $name;
        $this->equipmentType = $equipmentType;
        $this->price =         $price;
        $this->id =            $id;
        $this->quantity =      $quantity;
        $this->isAvailable =   $isAvailable;
		$this->isMaintained = $isMaintained;
		$this->isOccupied = $isOccupied;
		$this->roomID = $roomID;
	}
	
	public function addEngine() {
        $conn = DatabaseConnection::getINSTANCE();
		
		$maintained = 0;
		$occupied = 0;
		
		if($this->isMaintained == TRUE) {
			$maintained = 1;
		}
		if($this->isOccupied == TRUE) {
			$occupied = 1;
		}
		
		return $conn->insertInto("dental_engine", "(Equipment_ID, Engine_IsMaintained,
			Engine_IsOccupied, Engine_Room)", "('". $this->id . "', '" . $maintained . "', '" . $occupied .
				"', '" . $this->roomID . "')");
    }
	
	public function isMaintained() {
        return $this->isMaintained;
    }

    public function setMaintained($maintained) {
        $this->isMaintained = $maintained;
    }

    public function isOccupied() {
        return $this->isOccupied;
    }

    public function setOccupied($occupied) {
        $this->isOccupied = $occupied;
    }

    public function getRoomID() {
        return $this->roomID;
    }

    public function setRoomID($roomID) {
        $this->roomID = $roomID;
    }
	
}

?>