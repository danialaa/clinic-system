<?php
include_once "M_User.php";
include_once "main.php";

class C_User {
    public function request($requestType, $data) {
        $user = M_User::getINSTANCE();

        switch ($requestType) {
            case "C":
            	$user->setId($data[0]);
            	$user->setPassword($data[1]);
            	$user->setLoggedIn(0);
            	$user->setTypeId($data[2]);

            	$user->addUser();
            case "R":
                return $user->getAllUsers($data[0]);
				
            case "U":
				$user->updateUser("login");
				
            case "D":

        }

        return null;
    }

    public function ifUserExist($id, $password) {
		$data = array();
		$condition = " WHERE User_ID = " . $id . " AND User_Password = " . $password;
		array_push($data, $condition);
        $users = $this->request("R", $data);
		
        if (count($users) > 0) {
			M_User::getINSTANCE()->setTypeId($users[0]->getTypeId());
			M_User::getINSTANCE()->setLoggedIn($users[0]->getLoggedIn());
			M_User::getINSTANCE()->setId($users[0]->getId());
			M_User::getINSTANCE()->setPassword($users[0]->getPassword());
            return TRUE;
        }
		
        return FALSE;
    }
	
	public function login($id) {
		$data = array();
		array_push($data, $id);
		$this->request("U", $data);
	}
}

?>