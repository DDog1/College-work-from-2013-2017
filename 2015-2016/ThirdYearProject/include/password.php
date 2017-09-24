<?php
ob_start();
ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);

if(isset($_POST['password']))
{
	$user_name = $_SESSION["user_name"];
	$password = $_POST['password'];
	$newPassword = $_POST['newPassword'];
	$repeatNewPassword = $_POST['repeatNewPassword'];

	if ($newPassword != $repeatNewPassword) {
		die("Passwords don't match");
	}

	require_once("config/db.php");
	$mysqli = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
	$self = $_SERVER['PHP_SELF'];
	
	/* check connection */
	if (mysqli_connect_errno()) {
	    printf("Connect failed: %s\n", mysqli_connect_error());
	    exit();
	}

	$result = "SELECT user_name, user_password_hash
	            FROM users
	            WHERE user_name = '" . $user_name . "';
	         ";

	

	if ($result = $mysqli->query($result)) {
	    // while ($obj = $result->fetch_object()){
	 	while ($obj = mysqli_fetch_object($result)) {

	        // printf ("%s (%s)\n", $obj->user_name, $obj->user_password_hash);
					
	        if (password_verify($password, $obj->user_password_hash)) {
	    		$newPassword = password_hash($newPassword, PASSWORD_DEFAULT); //encrypts the password;
			    $resetPassQuery = " UPDATE users
									SET user_password_hash='$newPassword'
									WHERE user_name='$user_name';
								  ";

			$result = $mysqli->query($resetPassQuery);
			
			echo "Password successfully changed";

	        }else{
				echo "<p style='color:red;'>Wrong password!</p>";
				die($mysqli->error);
	        }

	    }
	}

}

?>