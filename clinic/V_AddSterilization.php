<!DOCTYPE HTML>  
<html>
<head>
<style>
.error {color: #FF0000;}
</style>
<script>
function addTypes(name) {
	typeSelect = document.getElementById('typeSelect');
	typeSelect.options[typeSelect.options.length] = new Option(name, name);
}
</script>
</head>
<body> 

<?php
include_once "C_Equipment.php";

$nameErr = $priceErr = $quantityErr = "";
$name = $price = $quantity = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
	$valid = TRUE;
	
	if (empty($_POST["name"])) {
		$nameErr = "Name is required";
		$valid = FALSE;
	} else {
		$name = test_input($_POST["name"]);
		
		if (!preg_match("/^[a-zA-Z ]*$/", $name)) {
			$nameErr = "Only letters allowed";
			$valid = FALSE;
		}
	}
	if (empty($_POST["price"])) {
		$priceErr = "Price is required";
		$valid = FALSE;
	} else {
		$price = test_input($_POST["price"]);
		
		if (!preg_match("/^[0-9]*$/", $price)) {
			$priceErr = "Only digits allowed";
			$valid = FALSE;
		}
	}
	if (empty($_POST["quantity"])) {
		$quantityErr = "Quantity is required";
		$valid = FALSE;
	} else {
		$quantity = test_input($_POST["quantity"]);
		
		if (!preg_match("/^[0-9]*$/", $quantity)) {
			$quantityErr = "Only digits allowed";
			$valid = FALSE;
		}
	}
	
	if(isset($_POST["add"])) {
		if($valid == TRUE) {
			$equipmentController = new C_Equipment();
			
			$data = array();
			array_push($data, $name);
			array_push($data, $price);
			array_push($data, $quantity);
			array_push($data, $quantity);
			
			if(isset($_POST['availability'])) {
				if($_POST['availability'] == "available") {
					array_push($data, TRUE);
				}
			}
			
			array_push($data, FALSE);
			
			array_push($data, "sterilization");
			$selType = $_POST["typeSelect"];
			array_push($data, $selType);

			$equipmentController->request("C", $data);
		}
	}
	if(isset($_POST["back"])) {
		header("Location:V_AddEquipment.php");
		exit();
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
	<h2 style="text-align: center;">Add Sterilization Tool</h2>
	<br><br>
	<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
		<table style="text-align: left; *margin: auto;" border="0">
			<tr>
				<td>Name: <input style="margin-left: 59px;" type="text" name="name" value="<?php echo $name;?>"></td>
				<td><span class="error">* <?php echo $nameErr;?></span></td>
			</tr>
			<tr>
				<td>Price: <input style="margin-left: 64px;" type="text" name="price" value="<?php echo $price;?>"></td>
				<td><span class="error">* <?php echo $priceErr;?></span></td>
			</tr>
			<tr>
				<td><br>Availability: <input style="margin-left: 20px;" type="radio" name="availability" value="available">Available
				<input style="margin-left: 59px;" type="radio" name="availability" value="unavailable">Unavailable</td>
			</tr>
			<tr>
				<td><br>Quantity: <input style="margin-left: 40px;" type="text" name="quantity" value="<?php echo $quantity;?>"></td>
				<td><span class="error">* <?php echo $quantityErr;?></span></td>
			</tr>
			<tr>
				<td><br>Type: <select id="typeSelect" name="typeSelect" style="margin-left: 64px; width: 52%;"><option value="0">--Select Type--</option></select></td>
			</tr>
		</table>
		<br><br><br><br>
		<input type="submit" name="back" value="Back"> 
		<input type="submit" name="add" value="Add"> 
	</form>
</div>

<?php
$type = "Radiation";
echo '<script type="text/javascript">addTypes(\''.$type.'\');</script>';
$type = "Physical";
echo '<script type="text/javascript">addTypes(\''.$type.'\');</script>';
$type = "Chemical";
echo '<script type="text/javascript">addTypes(\''.$type.'\');</script>';
?>
</body>
</html>