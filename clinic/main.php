<?php








//include 'V_Login.php';




// include_once "M_Invoice.php";
// include_once "M_InvoiceDetail.php";
// include_once "M_InvoiceDetailEquipment.php";
// include_once "M_Tax.php";

// $invoice = new M_Invoice(1, 0, 1, 1, FALSE, "", "", "");

// $invoiceDetail = new M_InvoiceDetail(1, $invoice, $invoice->getTotal());

// $equipmentDetail = new M_InvoiceDetailEquipment(1, 1, $invoiceDetail, 50);
// $tax = new M_Tax(20, $invoiceDetail, 0);


// echo "base price = " . $invoiceDetail->getPrice() . "<br>";
// $equipmentDetail->echoEquip();
// echo "edited price = " . $invoiceDetail->getPrice() . "<br>";
// $tax->echoTax();
// echo "edited price = " . $invoiceDetail->getPrice() . "<br>";


// include_once "M_Address.php";
// include_once "M_Person.php";

// public static $departments = array(1=>"Diagnosis", 2=>"Operative", 3=>"Endodontics", 4=>"Removable Prosth",
		// 5=>"Periodontics", 6=>"Surgery", 7=>"Crown and Bridge", 8=>"Pedodontics", 9=>"Post Graduate");
		
// public static $equipmentTypes = array("Drug", "Dental Engine", "Operational Tool", "Sterlization Tool");
		
// public static $genders = array(1=>"Male", 2=>"Female");
		
// public static $medicalAlerts = array(1=>"Allergies", 2=>"Hypertension", 3=>"Diabetes"
		// , 4=>"Bleeding Disorders", 5=>"Drugs", 6=>"Cardiovascular Diseases", 7=>"Anemia"
		// , 8=>"Asthma", 9=>"Cancer", 10=>"Blood Pressure");


// //array_keys($arr); //bytl3 a & b & g
// //	$array[$key]; // bytl3 green
// //	$key = array_search('green', $arr); // $key = g;

// $address = new M_Address(1, "Cairo", "faisal", "Cairo", "200");
// $person  = new M_Person("Dania", "Alaaeldin", "Mahdaly", "01017982064", "1998-09-06", $address, 1313432656, 2);

// $address->setID(70);

// $addresses = $person->getAllAddresses(""); 

// echo "<table border=2>";
// echo "<tr><td>ID</td><td>Governorate</td><td>City</td><td>Street</td><td>Apt</td></tr>";
// foreach($addresses as $address1)
// {
	// echo "<tr><td>".$address1->getID()."</td>"; 
	// echo "<td>".$address1->getGovernorate()."</td>"; 
	// echo "<td>".$address1->getCity()."</td>";
	// echo "<td>".$address1->getStreetName()."</td>"; 
	// echo "<td>".$address1->getApartmentNumber()."</td></tr>";
// }

// echo "</table>";

?>