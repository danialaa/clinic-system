<?php
include_once "M_UserType.php";
include_once "M_Permission.php";

class C_UserType {
    public function request($requestType, $data) {
        $userType = new M_UserType(1, "", null);
		
        switch ($requestType) {
            case "C":
                $userType->setTypeName($data[0]);

                for($i=1; $i < sizeof($data); $i++) {
                    $permission = $data[i];
					array_push($userType->getPermissions(), $permission);
                }

                $userType->setUserTypeID($userType->addUserType());
                $userType->addTypeLink();

                return null;
            case "R":
				if($data == null) {
                    return $userType->getAllUserTypes("");
                } else {
                    return $userType->getAllUserTypes($data[0]);
                }
            case "U":

            case "D":
			
			default:
				return null;
        }
    }

    /*public function isValidUserType($textFields , $labels) {
        if(TextFieldValidator.validateEmpty(textFields,labels)) {
            return true;
        }

        return false;
    }*/
}
?>