<?php
include_once "DatabaseConnection.php";

class M_User {
	private $id;
    private $password;
	private $isLogged;
	private $usertypeID;
	private static $INSTANCE;

    public function __construct($id, $password, $usertypeID) {
        $this->id =       $id;
        $this->password = $password;
		$this->usertypeID = $usertypeID;
    }
	
	public static function getINSTANCE() {
		if (self::$INSTANCE == null) {
			self::$INSTANCE = new M_User(1, 1, 1);
		}
		
		return self::$INSTANCE;
	}

	public function addUser() {
        $conn = DatabaseConnection::getINSTANCE();

        return $conn->insertInto("users", "(User_ID, UserType_ID,
						User_Password, User_IsLoggedIn)",
			"('" . $this->id . "', '" . $this->usertypeID . "', '" . $this->password
                        . "', '" . $this->isLogged . "')");
    }

    public function getAllUsers($condition) {
        $conn = DatabaseConnection::getINSTANCE();
		
		$result = $conn->select("users", $condition);
		$users = array();
		
		if($result != null) {
			while ($row = $result->fetch_assoc()) {
				$user = new M_User($row["User_ID"], $row["User_Password"], $row["UserType_ID"]);
				array_push($users, $user);
			}
		}
		
		return $users;
    }
	
	public function updateUser($column) {
        if($column == "login") {
			$conn = DatabaseConnection::getINSTANCE();
			$conn->update("users",
                    "User_IsLoggedIn = '" . $this->getLoggedIn()
						. "'", $this->id, 
						"User_ID");
		}
    }
	
	public function getTypeId() {
        return $this->usertypeID;
    }

    public function setTypeId($usertypeID) {
        $this->usertypeID = $usertypeID;
    }

    public function getId() {
        return $this->id;
    }

    public function setId($id) {
        $this->id = $id;
    }
	
	public function getLoggedIn() {
        return $this->isLogged;
    }

    public function setLoggedIn($isLogged) {
        $this->isLogged = $isLogged;
    }

    public function getPassword() {
        return $this->password;
    }

    public function setPassword($password) {
        $this->password = $password;
    }
}

?>