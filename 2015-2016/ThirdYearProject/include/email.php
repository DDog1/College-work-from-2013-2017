<?php
if(isset($_POST['email']))
{
	$username = $_SESSION["user_name"];
	$newemail = $_POST['newemail'];
	$email = $_POST['email'];
	require_once("db_connect.php");
	$db_link = db_connect("majorgroupproject");
	$self = $_SERVER['PHP_SELF'];


	$result = @mysql_query("Select *
	From users
	WHERE user_name LIKE '$username'");

	$fields = mysql_list_fields("majorgroupproject","users");
	$num_cols = mysql_num_fields($fields);

	if(mysql_num_rows($result)>0)
	{
		while($row = mysql_fetch_array($result))
		{
			if($email==$newemail)
			{
				$query="UPDATE users
				SET user_email='$newemail'
				WHERE user_name='$username'";

				$result = mysql_query($query) or die("SQL query failed");
				mysql_close($db_link);

				header('Location: userHome.php');
				/**************** CHANGE EMAIL SQL CODE GOES HERE!! *******************/
			}
			else{
				echo "<span style='color:red;'>Sorry Email did not match!!</span><br>";
			}
		}
	}
	else{
	echo "<span style='color:red;'>Sorry could not get results!!</span><br>";
	echo "<p style='color:red;'>Or wrong email did not match!!</p>";
	}
}
?>