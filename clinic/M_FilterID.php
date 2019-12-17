<?php
include_once "IFilter.php";
include_once "M_Dentist.php";
include_once "M_Patient.php";

class M_FilterPatient implements IFilter {
	
	public function filterList($list, $column) {
		for($i=0; $i<count($list); $i++) {
			if($list[$i] != $column) {
				unset($list[$i]);
			}
		}
		
		return $list;
	}
}

?>