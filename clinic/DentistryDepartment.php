<?php
class DentistryDepartment{
	private const $DIAGNOSIS		= array("Diagnosis", 1);
    private const $OPERATIVE		= array("Operative", 2);
    private const $ENDODONTICS		= array("Endodontics", 3);
    private const $REMOVABLE_PROSTH	= array("Removable Prosth", 4);
    private const $PERIODONTICS		= array("Periodontics", 5);
    private const $SURGERY			= array("Surgery", 6);
    private const $CROWN_AND_BRIDGE = array("Crown and Bridge", 7);
    private const $PEDODONTICS	    = array["Pedodontics", 8);
    private const $POST_GRADUATE    = array["Post Graduate", 9);
	private const $INSTANCE;
	
	private __construct() { 
		$this->INSTANCE = array();
		array_push($this->INSTANCE, $this->DIAGNOSIS);
		array_push($this->INSTANCE, $this->OPERATIVE);	
		array_push($this->INSTANCE, $this->ENDODONTICS);
		array_push($this->INSTANCE, $this->REMOVABLE_PROSTH);
		array_push($this->INSTANCE, $this->PERIODONTICS);
		array_push($this->INSTANCE, $this->SURGERY);
		array_push($this->INSTANCE, $this->CROWN_AND_BRIDGE);
		array_push($this->INSTANCE, $this->PEDODONTICS);
		array_push($this->INSTANCE, $this->POST_GRADUATE);		
	}
	
	public static function getINSTANCE() {
		if ($this->INSTANCE == null) {
			$this->INSTANCE = new DentistryDepartment();
		}
		
		return $this->INSTANCE;
	}
	
	
}
?>