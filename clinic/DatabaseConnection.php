<?php

class DatabaseConnection {
	private $host="localhost";
	private $user="root";
	private $password="";
	private $dbname="clinic";
	private static $INSTANCE;
	private $connection;
	
	private function __construct() {
		$conn = mysqli_connect($this->host, $this->user, $this->password, $this->dbname);
		
		if($conn) {
			$this->connection=$conn;
		} else {
			die("Connection failed: " . mysqli_connect_error());
		}
	}
	
	public static function getINSTANCE() {
		if (self::$INSTANCE == null) {
			self::$INSTANCE = new DatabaseConnection();
		}
		
		return self::$INSTANCE;
	}
	
	public function select($table, $condition) {
		$query = "SELECT * FROM " . $table . $condition;
		$resultSet = mysqli_query($this->connection, $query);
		
		if($resultSet != null) {
			return $resultSet;
		} else {
			//echo "No Data Available.";
			return null;
		}
		
    }

    public function insertInto($table, $columns, $values) {
		$query = "INSERT INTO " . $table . " " . $columns . " VALUES " . $values;
		
		if ($this->connection->query($query) == TRUE) {
			return $this->connection->insert_id;
		} else {
			echo "Insert unsuccessful: " . $this->connection->error . "<br>";
		}
    }

    public function update($table, $newValues, $id, $idColumn) {
		$query = "UPDATE " . $table . " SET " . $newValues . " WHERE " .
			$idColumn . " = " . $id;
			
		if ($this->connection->query($query) == TRUE) {
				
		} else {
			echo "Insert unsuccessful: " . $this->connection->error . "<br>";
		}   
    }
}

?>