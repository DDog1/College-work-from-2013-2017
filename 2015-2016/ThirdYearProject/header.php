<?php
if(isset($_POST['username']))
{
	$username = $_POST['username'];
	$password = $_POST['password'];
	// require_once("include/db_connect.php");
	require_once("config/db.php");
	// $db_link = db_connect("majorgroupproject");

	$this->db_connection = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);

	$self = $_SERVER['PHP_SELF'];

	$result = @mysql_query("Select *
	From users
	WHERE user_name LIKE '$username'
	AND user_password_hash LIKE '$password'");

	$fields = mysql_list_fields("majorgroupproject","users");
	$num_cols = mysql_num_fields($fields);
	$inDatabase='false';
	if(mysql_num_rows($result)>0)
	{
		while($row = mysql_fetch_array($result))
			$inDatabase='true';
		{
			echo "<div id='move down' style='margin-top: 60px;'><span style='color:red;'>Hello ".$row['username'].". Make sure you log out after you are done!!</span></div><br>";
			if($inDatabase=='true')
			{
				$_SESSION["username"]=$username;
				$_SESSION["password"]=$password;
				header('Location: userHome.php');
			}
		}
	}
	else{
		echo '<div class="alert alert-danger">';
	    echo '<strong>Warning!</strong> The username or the password is wrong!!';
  		echo '</div>';
		$inDatabase='false';
	}
}
?>