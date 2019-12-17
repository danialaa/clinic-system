<!DOCTYPE HTML>  
<html>
<body>  

<?php
include_once "M_User.php";
include_once "C_User.php";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
	if(isset($_POST["logout"])) {
		$userController = new C_User();
		M_User::getINSTANCE()->setLoggedIn(0);
		$userController->login($id);
		
		header("Location:V_Login.php");
		exit();
	} else if (isset($_POST["addEquip"])) {
		header("Location:V_AddEquipment.php");
		exit();
	} else if (isset($_POST["searchEquip"])) {
		header("Location:V_SearchEquipment.php");
		exit();
	}
}	
	
?>

<div style="margin: auto; width: 50%; text-align: center;">
	<h2 style="text-align: center;">Choose</h2>
	<br><br>
	<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
		<input type="submit" name="addEquip" 	value="Add Equipment"> 
		<input type="submit" name="searchEquip" value="Search Equipment"> 
		<input type="submit" name="addEmp" value="Add Employee"> 
		<input type="submit" name="searchEmp" value="Search Employee"> 
		<input type="submit" name="addInvoice" value="Add Invoice"> 
		<br><br><br><br>
		<input type="submit" name="logout" value="Logout" onClick='return validate();'> 
	</form>
</div>

<script>
function validate()
{
   conf = confirm('Are You Sure You Want To Logout?');
   
   return conf;
}
</script>
</body>
</html>