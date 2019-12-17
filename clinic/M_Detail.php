<?php
class M_Detail {
    protected $detailID;

    public function __construct($detailID) {
        $this->detailID = $detailID;
    }

    public function getDetailID() {
        return $this->detailID;
    }

    public function setDetailID($detailID) {
        $this->detailID = $detailID;
	}
}

?>