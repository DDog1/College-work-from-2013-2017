<?php
if(isset($_POST['nationality']))
{
	$username = $_SESSION["user_name"];
	$lang = $_POST['nationality'];
	require_once("include/db_connect.php");
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
			$query="UPDATE users
			SET nationality='$lang'
			WHERE user_name='$username'";

			$result = mysql_query($query) or die("SQL query failed");
			mysql_close($db_link);

			header('Location: userHome.php');
		}
	}
	else{
	echo "<span style='color:red;'>Sorry could not get results!!</span><br>";
	}
}
?>