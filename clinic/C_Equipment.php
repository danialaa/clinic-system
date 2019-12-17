<?php
include_once "M_Equipment.php";
include_once "M_Drug.php";
include_once "M_DentalEngine.php";
include_once "M_OperationalTool.php";
include_once "M_SterilizationTool.php";

class C_Equipment {
	public function request($requestType, $data) {
		$equipment = new M_Equipment("", "", 0, 1, 0, FALSE);
		
        switch ($requestType) {
            case "C":
                switch ($data[5]) {
					case "drug":
						$drug = new M_Drug("", null, 0, 1, 0, FALSE, "", "");
						$drug = makeObject($drug, $data);
						$drug->setExpiryDate($data[6]);
						$drug->setProductionDate($data[7]);
						$drug->addDrug();
						
						break;
					case "engine":
						$dentalEngine = new M_DentalEngine("", null, 0, 1, 0, FALSE, FALSE, FALSE, "");
						$dentalEngine = makeObject($dentalEngine, $data);
						$dentalEngine->setMaintained($data[6]);
						$dentalEngine->setOccupied($data[7]);
						$dentalEngine->setRoomID($data[8]);
						$dentalEngine->addEngine();
						
						break;
					case "operational":
						$operationalTool = new M_OperationalTool("", null, 0, 1, 0, FALSE, FALSE, FALSE);
						$operationalTool = makeObject($operationalTool, $data);
						$operationalTool->setSterlized($data[6]);
						$operationalTool->setReusable($data[7]);
						$operationalTool->addOperational();
						
						break;
					case "sterilization":
						$sterilizationTool = new M_SterilizationTool("", null, 0, 1, 0, FALSE, "");
						$sterilizationTool = $this->makeObject($sterilizationTool, $data);
						$sterilizationTool->myID = $sterilizationTool->getId();
						$sterilizationTool->setSterilizationType($data[6]);
						$sterilizationTool->addSterilization();
						
						break;
				}

                return null;
            case "R":
				if($data == null) {
                    return $equipment->getAllEquipment("");
                } else {
                    return $equipment->getAllEquipment($data[0]);
                }
            case "U":

            case "D":
			
			default:
				return null;
        }
    }
	
	private function makeObject($equipment, $data) {
		$equipment->setName($data[0]);
		$equipment->setPrice($data[1]);
		$equipment->setQuantity($data[2]);
		$equipment->setEquipmentType($data[5]);
		$equipment->setAvailable($data[4]);
		$equipment->setId($equipment->addEquipment());
		
		return $equipment;
	}

    /* public boolean isValidEquipmentData(List<JTextField> textFieldList, List<JLabel> labelList) {
        if(TextFieldValidator.validateEmpty(textFieldList, labelList) && TextFieldValidator.validateEmail(textFieldList.get(5), labelList.get(5))) {
            return true;
        }

        return false;
    } */
}
?>