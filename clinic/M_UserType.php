<?php
include_once "M_Permission.php";

class M_UserType {
	private $userTypeID;
    private $typeName;
    private $permissions;

    public function __construct($userTypeID, $typeName) {
        $this->userTypeID =  $userTypeID;
        $this->typeName =    $typeName;
        //$this->permissions = $permissions;
    }

    public function addUserType() {
        $conn = DatabaseConnection::getINSTANCE();
		
		return $conn->insertInto("usertype", "(UserType_Name)", "('". $this->typeName . "')");
    }

    public function addTypeLink() {
		$conn = DatabaseConnection::getINSTANCE();
		
        foreach($this->permissions as $permission) {
            $conn->insertInto("type_permission", "(Permission_ID, UserType_ID)",
			"('" . $permission->getPermissionID() . "', '" . $this->userTypeID . "')");
        }
    }

	public function getAllUserTypes($condition) {
        $conn = DatabaseConnection::getINSTANCE();
		
		$result = $conn->select("usertype", $condition);
		$usertypes = array();
		
		while ($row = $result->fetch_assoc()) {
			$usertype = new M_UserType($row["UserType_ID"], $row["UserType_Name"]);
			array_push($usertypes, $usertype);
		}
		
		return $usertypes;
    }
	
    public function getUserTypeID() {
        return $this->userTypeID;
    }

    public function setUserTypeID($userTypeID) {
        $this->userTypeID = $userTypeID;
    }

    public function getTypeName() {
        return $this->typeName;
    }

    public function setTypeName($typeName) {
        $this->typeName = $typeName;
    }

    public function getPermissions() {
        return $this->permissions;
    }

    public function setPermissions($permissions) {
        $this->permissions = $permissions;
    }
}

?>