<?php
include_once "DatabaseConnection.php";

class M_Schedule {
	protected $id;
    protected $sDate;
	
	public function __construct($id, $date) {
		$this->id=$id;
		$this->sDate=$date;
	}
	
	public function addSchedule() {
        $conn = DatabaseConnection::getINSTANCE();

        return $conn->insertInto("schedule", "(Schedule_Date)",
			"('" + this.date + "')");
    }

    public function getAllSchedules($condition) {
		$conn = DatabaseConnection::getINSTANCE();
		
		$result = $conn->select("schedule", $condition);
		$schedules = array();
		
		while ($row = $result->fetch_assoc()) {
			$schedule = new M_Schedule($row["Schedule_ID"], $row["Schedule_Date"]);
			array_push($schedules, $schedule);
		}
		
		return $schedules;
    }

    public function getID() {
        return $this->id;
    }

    public function setID($id) {
        $this->id = $id;
    }

    public function getsDate() {
        return $this->sDate;
    }

    public function setsDate($date) {
        $this->SsDate = $date;
    }
}

?>