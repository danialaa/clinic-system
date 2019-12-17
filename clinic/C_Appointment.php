<?php
include_once "M_Appointment.php";
include_once "C_Patient.php";

class C_Appointment {
    public function request($requestType, $data) {
        $appointment = new M_Appointment(1, "", 1, 1, FALSE, "", "", "", "", "", 1);
		
        switch ($requestType) {
            case "C":
                $appointment->setPatientID($data[0]);
                $appointment->setPatientName($data[1]);
                $appointment->setDentistID($data[2]);
                $appointment->setDentistName($data[3]);
                $appointment->setStatus("Pending");
                //$appointment->setAppointmentType(DentistryDepartment.getConstant($data.get(4).toString()));
                $appointment->setsDate($data[5]);
                $appointment->setByPhone($data[6]);
                $appointment->setStartTime($data[7]);
                $appointment->setEndTime("00:00");
                $appointment->setID($appointment->addSchedule());
                $appointment->addAppointment();

                return null;
            case "R":
				if ($data == null) {
                    return $appointment->getAllAppointments("");
                } else {
                    return $appointment->getAllAppointments($data[0]);
                }
            case "U":

            case "D":
			
			default:
				return null;
        }
    }

    public function isValidAppointmentData($PID) {
        $patientController = new C_Patient();
        $data = array();
        $condition = " WHERE Patient_ID = " . $PID;
		array_push($data, $condition);
        $patients = $patientController->request("R", $data);

        if (sizeof($patients) > 0) {
            return TRUE;
        }

        return FALSE;
    }
}
?>