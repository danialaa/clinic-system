<?php
include_once "M_Permission.php";

class C_Permission {


    public function request($requestType, $condition) {
        $permission = new M_Permission();

        switch ($requestType) {
            case "C":

            case "R":
                return $permission->getAllPermissions($condition);
            case "U":

            case "D":

        }

        return null;
    }
}
?>