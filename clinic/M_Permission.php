<?php

class M_Permission {
	private $permissionID;
    private $linkName, $physicalLink;

    public function __construct($permissionID, $linkName, $physicalLink) {
        $this->permissionID = $permissionID;
        $this->linkName =     $linkName;
        $this->physicalLink = $physicalLink;
    }

    public function getAllPermissions($condition){
        $conn = DatabaseConnection::getINSTANCE();
		
		$result = $conn->select("permission", $condition);
		$permissions = array();
		
		while ($row = $result->fetch_assoc()) {
			$permission = new M_Permission($row["Permission_ID"], $row["Permission_Name"]
				, $row["Permission_Link"]);
			array_push($permissions, $permission);
		}
		
		return $permissions;
    }

    public function getPermissionID() {
        return $this->permissionID;
    }

    public function setPermissionID($permissionID) {
        $this->permissionID = $permissionID;
    }

    public function getLinkName() {
        return $this->linkName;
    }

    public function setLinkName($linkName) {
        $this->linkName = $linkName;
    }

    public function getPhysicalLink() {
        return $this->physicalLink;
    }

    public function setPhysicalLink($physicalLink) {
        $this->physicalLink = $physicalLink;
    }
}

?>