<!DOCTYPE HTML>  
<html>
<body>  

<?php
include_once "M_User.php";
include_once "C_User.php";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
	if(isset($_POST["addSterilization"])) {
		header("Location:V_AddSterilization.php");
		exit();
	}
	
	if(isset($_POST["back"])) {
		header("Location:V_HRHome.php");
		exit();
	}
}	
	
?>

<div style="margin: auto; width: 50%; text-align: center;">
	<h2 style="text-align: center;">Add Equipment</h2>
	<br><br>
	<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
		<input type="submit" name="addDrug" value="Add Drug"> 
		<input type="submit" name="addEngine" value="Add Dental Engine"> 
		<input type="submit" name="addOperational" value="Add Operational Tool"> 
		<input type="submit" name="addSterilization" value="Add Sterilization Tool"> 
		<br><br><br><br>
		<input type="submit" name="back" value="Back"> 
	</form>
</div>
</body>
</html>