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
include_once "M_User.php";

$idErr = $passwordErr = "";
$id = $password = "";
$clicked = 0;

if ($_SERVER["REQUEST_METHOD"] == "POST") {
	$valid = TRUE;
	
	if (empty($_POST["id"])) {
		$idErr = "ID is required";
		$valid = FALSE;
	} else {
		$id = test_input($_POST["id"]);
		
		if (!preg_match("/^[0-9]*$/", $id)) {
			$idErr = "Only digits allowed";
			$valid = FALSE;
		}
	}
	if (empty($_POST["password"])) {
		$passwordErr = "Password is required";
		$valid = FALSE;
	} else {
		$password = test_input($_POST["password"]);
	}
	
	if($valid == TRUE) {
		$userController = new C_User();
		$isExist = $userController->ifUserExist($id, $password);
		
		if($isExist == TRUE) {
			$userController->login($id);
			
			if(M_User::getINSTANCE()->getTypeId() == 1) {
				header("Location:V_AdminHome.php");
				exit();
			} else if (M_User::getINSTANCE()->getTypeId() == 2) {
				header("Location:V_HRHome.php");
				exit();
			} else if (M_User::getINSTANCE()->getTypeId() == 3) {
				header("Location:V_ReceptionistHome.php");
				exit();
			}
		} else {
			echo "<script language='javascript'>";
			echo "alert('User Does Not Exist')";
			echo "</script>";
		}
	}
}

function test_input($data) {
	$data = trim($data);
	$data = stripslashes($data);
	$data = htmlspecialchars($data);
	return $data;
}
?>

<div style="margin: auto; width: 50%; text-align: center;">
	<h2 style="text-align: center;">Login</h2>
	<br><br>
	<p style="text-align: center;"><span class="error">* required field</span></p>
	<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
		<table style="text-align: left; *margin: auto;" border="0">
			<tr>
				<td>ID: <input style="margin-left: 44px;" type="text" name="id" value="<?php echo $id;?>"></td>
				<td><span class="error">* <?php echo $idErr;?></span></td>
			</tr>
			<tr>
				<td>Password: <input type="password" name="password" value="<?php echo $password;?>"></td>
				<td><span class="error">* <?php echo $passwordErr;?></span></td>
			</tr>
		</table>
		<br><br><br><br>
		<input type="submit" name="login" value="Login"> 
	</form>
</div>
</body>
</html>