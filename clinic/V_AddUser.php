<!DOCTYPE HTML>  
<html>
<head>
<style>
.error {color: #FF0000;}
</style>
</head>
<body> 

<?php
include_once "C_User.php";
include_once "C_Employee.php";
include_once "C_UserType.php";

$passwordErr = $confirmErr = "";
$password = $confirm = "";
$employeeController = new C_Employee();
$emps = $employeeController->request("R", null);
?>

<div style="margin: auto; width: 50%; text-align: center;">
	<h2 style="text-align: center;">Add User</h2>
	<br><br>
	<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
		<table style="text-align: left; *margin: auto;" border="0">
			<tr>
				<td>Employee: <select id="empSelect" name="empSelect" style="width: 57.5%; margin-left: 55px;"><option value="0">--Select Employee--</option></select></td>
			</tr>
			<tr>
				<td>User Type: <select id="typeSelect" name="typeSelect" style="width: 57.5%; margin-left: 54px;"><option value="0">--Select UserType--</option></select></td>
			</tr>
			<tr>
				<td>Password: <input style="margin-left: 59px;" type="password" name="password" value="<?php echo $password;?>"></td>
				<td><span class="error">* <?php echo $passwordErr;?></span></td>
			</tr>
			<tr>
				<td>Confirm Password: <input type="password" name="confirm" value="<?php echo $confirm;?>"></td>
				<td><span class="error">* <?php echo $confirmErr;?></span></td>
			</tr>
		</table>
		<br><br><br><br>
		<input type="submit" name="back" value="Back"> 
		<input type="submit" name="add" value="Add"> 
	</form>
</div>
<script>
function addEmps(name, id) {
	empSelect = document.getElementById('empSelect');
	empSelect.options[empSelect.options.length] = new Option(name, id);
}
function addTypes(name, id) {
	typeSelect = document.getElementById('typeSelect');
	typeSelect.options[typeSelect.options.length] = new Option(name, id);
}
</script>

<?php
$passwordErr = $confirmErr = "";
$password = $confirm = "";

$employeeController = new C_Employee();
$emps = $employeeController->request("R", null);

$typeController = new C_UserType();
$types = $typeController->request("R", null);

$userController = new C_User();

for ($i=0; $i<count($emps); $i++) {
	$id = $emps[$i]->getEmployeeID();
	$name = $emps[$i]->getFirstName() . " " . $emps[$i]->getLastName();
	
	echo '<script type="text/javascript">addEmps(\''.$name.'\', \''.$id.'\');</script>';
}

for ($i=0; $i<count($types); $i++) {
	$id = $types[$i]->getUserTypeID();
	$name = $types[$i]->getTypeName();

	echo '<script type="text/javascript">addTypes(\''.$name.'\', \''.$id.'\');</script>';
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
	$valid = TRUE;
	
	if (empty($_POST["password"])) {
		$passwordErr = "Password is required";
		$valid = FALSE;
	} else {
		$password = $_POST["password"];
	}
	if (empty($_POST["confirm"])) {
		$confirmErr = "Password is required";
		$valid = FALSE;
	} else {
		$confirm = $_POST["confirm"];
		
		if($confirm != $password) {
			$valid = FALSE;
			$confirmErr = "Must Match Password";
		}
	}
	
	if(isset($_POST["back"])) {
		header("Location:V_AdminHome.php");
		exit();
	}
	if(isset($_POST["add"])){
		$selEmp = $_POST["empSelect"];
		$selType = $_POST["typeSelect"];

		$data = array();
		array_push($data, $selEmp);
		array_push($data, $password);
		array_push($data, $selType);

		$userController->request("C", $data);
	}
}	
	
?>

</body>
</html>