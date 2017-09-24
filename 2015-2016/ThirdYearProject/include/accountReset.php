<?php
if(isset($_POST['email']))
{
	$password = $_POST['password'];
	$newpassword = $_POST['newpassword'];
	$email = $_POST['email'];

	require_once("include/db_connect.php");
	$db_link = db_connect("majorgroupproject");
	$self = $_SERVER['PHP_SELF'];

	$result = @mysql_query("Select *
	From users
	WHERE user_email LIKE '$email'");

	$fields = mysql_list_fields("majorgroupproject","users");
	$num_cols = mysql_num_fields($fields);
	if($password == $newpassword)
	{
		if(mysql_num_rows($result)>0)
		{
			while($row = mysql_fetch_array($result))
			{
				$query="UPDATE users
				SET user_password_hash='$password'
				WHERE user_email='$email'";

				$result = mysql_query($query) or die("SQL query failed");
				mysql_close($db_link);
				$username = $row['username'];
				$_SESSION["username"]=$username;
				header('Location: userHome.php');
			}
		}
		else{
			echo "<span style='color:red;'>Sorry could not get results!!</span><br>";
			echo "<span style='color:red;'>Please check the email address</span><br>";
		}
	}
	else
	{
		echo "<span style='color:red;'>Sorry passwords don't match!!</span><br>";
	}
}
?>