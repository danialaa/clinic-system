<?php
include_once "M_Dentist.php";

class C_Dentist {
    public List request($requestType,$data) {
        $dentist = new M_Dentist();

        switch ($requestType) {
            case "C":

            case "R":
                if($data == null) {
                    return $dentist->getAllDentists("");
                } else {
                    return $dentist->getAllDentists($data(0));
                }

            case "U":

            case "D":

        }

        return null;
    }
}

?>