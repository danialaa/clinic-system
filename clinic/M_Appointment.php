<?php
include_once "M_Schedule.php";
include_once "M_Dentist.php";
include_once "M_Patient.php";

class M_Appointment extends M_Schedule {
	private $dentistID, $patientID;
    private $isByPhone;
    private $startTime, $endTime, $status, $dentistName, $patientName;
    private $appointmentType;
	
	public function __construct($id, $date, $dentistID, $patientID, $isByPhone, $startTime, $endTime,
	$status, $dentistName, $patientName, $appointmentType) {
		$this->id = $id;
		$this->sDate=$date;
		$this->dentistID=$dentistID;
		$this->city=$patientID;
		$this->isByPhone=$isByPhone;
		$this->$startTime=$startTime;
		$this->endTime=$endTime;
		$this->status=$status;
		$this->endTime=$endTime;
		$this->dentistName=$dentistName;
		$this->patientName=$patientName;
		$this->appointmentType=$appointmentType;
	}
	
	public function getAllAppointments($condition) {
		$conn = DatabaseConnection::getINSTANCE();
		
		$result = $conn->select("appointment", $condition);
		$appointments = array();
		
		while ($row = $result->fetch_assoc()) {
			$schedule = new M_Schedule(1, "");
			$schedule = $schedule->getAllSchedules(" WHERE Schedule_ID = " . $row["Schedule_ID"]);
			$dentist = new M_Dentist("", "", "", "", "", null, 0, null, 0, "", 0, FALSE);
			$dentist = $dentist->getAllDentists(" WHERE Employee_ID = " . $row["Employee_ID"]);
			$patient = new M_Patient("", "", "", "", "", null, 0, null, 0, "", 0, null, null);
			$patient = $patient->getAllPatients(" WHERE Person_ID = " . $row["Patient_ID"]);
			$type = FALSE;
			
			if($row["Appointment_Type"] == "By Phone") {
				$type = TRUE;
			}
			
			$appointment = new M_Appointment($schedule[0]->getID(), $schedule[0]->getsDate(),
				$row["Employee_ID"], $row["Patient_ID"], $type, $row["Appointment_StartTime"],
				$row["Appointment_FinishTime"], $row["Appointment_Status"], $dentist[0]->getFirstName() . " " . $dentist[0]->getLastName(),
				$patient[0]->getFirstName() . " " . $patient[0]->getLastName(), 1);
			$appointment->setPatientID($row["Patient_ID"]);
			$appointment->setDentistName($dentist[0]->getFirstName() . " " . $dentist[0]->getLastName());
			$appointment->setPatientName($patient[0]->getFirstName() . " " . $patient[0]->getLastName());
			
			array_push($appointments, $appointment);
		}
		
		return $appointments;
    }
	
	public function addAppointment() {
        $conn = DatabaseConnection::getINSTANCE();
		
		$type = "Frontdesk";

        if($this->isByPhone()) {
            $type = "By Phone";
        }

        return $conn->insertInto("appointment", "(Schedule_ID, Appointment_FinishTime,
						Appointment_StartTime, Appointment_Status, Appointment_Type,
						Department_ID, Employee_ID, Patient_ID)",
			"('" + $this->id + "', '" + $this->endTime + "', '" + $this->startTime
                        + "', '" + $this->status + "', '" + $type + "', '" + $this->appointmentType.getId() +
                        "', '" + $this->dentistID + "', '" + $this->patientID + "')");
    }
	
	public function getDentistID() {
        return $this->dentistID;
    }

    public function setDentistID($dentistID) {
        $this->dentistID=$dentistID;
    }

    public function getPatientID() {
        return $this->patientID;
    }

    public function setPatientID($patientID) {
        $this->patientID=$patientID;
    }

    public function isByPhone() {
        return $this->isByPhone;
    }

    public function setByPhone($byPhone) {
        $this->isByPhone=$byPhone;
    }

    public function getStartTime() {
        return $this->startTime;
    }

    public function setStartTime($startTime) {
        $this->startTime=$startTime;
    }

    public function getEndTime() {
        return $this->endTime;
    }

    public function setEndTime($endTime) {
        $this->endTime = $endTime;
    }

    public function getStatus() {
        return $this->status;
    }

    public function setStatus($status) {
        $this->status = $status;
    }

    public function getAppointmentType() {
        return $this->appointmentType;
    }

    public function setAppointmentType($appointmentType) {
        $this->appointmentType = $appointmentType;
    }

    public function getDentistName() {
        return $this->dentistName;
    }

    public function setDentistName($dentistName) {
        $this->dentistName = $dentistName;
    }

    public function getPatientName() {
        return $this->patientName;
    }

    public function setPatientName($patientName) {
        $this->patientName = $patientName;
    }
}

?>