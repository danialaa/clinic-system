<!DOCTYPE HTML>  
<html>
<head>
</head>
<body> 

<?php
include_once "C_Appointment.php";
include_once "IFilter.php";
include_once "M_FilterID.php";
include_once "M_FilterName.php";

$patient = $name = "";
$filter = null;
$names = array();
$patients = array();
$appointments = array();
$filtered = array();

if ($_SERVER["REQUEST_METHOD"] == "POST") {
	if(count($appointments) > 0) {
		if(isset($_POST["searchname"])) {
			$filter = new M_FilterName();
			$filtered = $filter->filterList($names, $_POST["dentist"]);
			load2();
		} else if (isset($_POST["searchid"])) {
			$filter = new M_FilterPatient();
			$filtered = $filter->filterList($patients, $_POST["patient"]);
			load2();
		}
	}
	if(isset($_POST["back"])) {
		header("Location:V_ReceptionistHome.php");
		exit();
	}
}	

function load2() {
	echo "<tr><td><b>Dentist</b></td><td><b>Patient</b></td><td><b>Status</b></td></tr>";
	
	for($i=0; $i<count($appointments); $i++) {
		for($u=0; $u<count($filtered); $u++) {
			if($appointments[$i]->getDentistName() == $filtered[$u] ||$appointments[$i]->getPatientName() == $filtered[$u] )
			{
				echo "<tr><td>" . $appointments[$i]->getDentistName() . "</td><td>" . $appointments[$i]->getPatientName() .
					"</td><td>" . $appointments[$i]->getStatus() . "</td></tr>";
					break;
			}
		}
	}
}

function loadTable() {
	$appointmentController = new C_Appointment();
	$appointments = $appointmentController->request("R", null);
	
	echo "<tr><td><b>Dentist</b></td><td><b>Patient</b></td><td><b>Status</b></td></tr>";
	
	$names=array();
	$patients=array();
	for($i=0; $i<count($appointments); $i++) {
		array_push($names, $appointments[$i]->getDentistName());
		array_push($patients, $appointments[$i]->getPatientName());
		echo "<tr><td>" . $appointments[$i]->getDentistName() . "</td><td>" . $appointments[$i]->getPatientName() .
			"</td><td>" . $appointments[$i]->getStatus() . "</td></tr>";
	}
}
	
?>

<div style="margin: auto; width: 50%; text-align: center;">
	<h2 style="text-align: center;">Search Appointment</h2>
	<br><br>
	<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
		<table style="text-align: left; *margin: auto; width: 100%;" border="0">
			<tr><td>Patient: <input type="text" name="patient" value="<?php echo $patient;?>"></td></tr>
			<tr><td>Dentist: <input type="text" name="dentist" value="<?php echo $name;?>"></td></tr>
			<tr><td><input type="submit" value="Search Patient" name="searchid"><input type="submit" value="Search Dentist" name="searchname"></td></tr>
			<?php
				loadTable();
			?>
		</table>
		<br><br><br><br>
		<input type="submit" name="back" value="Back">
	</form>
</div>

<?php

?>
</body>
</html>