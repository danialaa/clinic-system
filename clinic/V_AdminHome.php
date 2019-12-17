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
	} else if (isset($_POST["addUser"])) {
		header("Location:V_AddUser.php");
		exit();
	}
}	
	
?>

<div style="margin: auto; width: 50%; text-align: center;">
	<h2 style="text-align: center;">Choose</h2>
	<br><br>
	<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
		<input type="submit" name="addUser" 	value="Add User"> 
		<input type="submit" name="searchUsers" value="Search Users"> 
		<input type="submit" name="addUserType" value="Add User Type"> 
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