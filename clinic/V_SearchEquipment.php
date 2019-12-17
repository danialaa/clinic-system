<!DOCTYPE HTML>  
<html>
<head>
</head>
<body> 

<?php
include_once "C_Equipment.php";


if ($_SERVER["REQUEST_METHOD"] == "POST") {
	if(isset($_POST["add"])) {
		
	}
	if(isset($_POST["back"])) {
		header("Location:V_HRHome.php");
		exit();
	}
}	

function loadTable() {
	$equipmentController = new C_Equipment();
	$equips = $equipmentController->request("R", null);
	
	echo "<tr><td><b>Name</b></td><td><b>Type</b></td><td><b>Price</b></td><td><b>Quantity</b></td></tr>";
	
	for($i=0; $i<count($equips); $i++) {
		echo "<tr><td>" . $equips[$i]->getName() . "</td><td>" . $equips[$i]->getEquipmentType() .
			"</td><td>" . $equips[$i]->getPrice() . "</td><td>" . $equips[$i]->getQuantity() . "</td></tr>";
	}
}
	
?>

<div style="margin: auto; width: 50%; text-align: center;">
	<h2 style="text-align: center;">Search Equipment</h2>
	<br><br>
	<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
		<table style="text-align: left; *margin: auto; width: 100%;" border="0">
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