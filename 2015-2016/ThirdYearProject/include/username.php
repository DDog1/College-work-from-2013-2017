<?php
if(isset($_POST['username']))
{
	$username = $_SESSION["user_name"];
	$newusername = $_POST['newusername'];
	$password = $_SESSION["password"];
	require_once("db_connect.php");
	$db_link = db_connect("majorgroupproject");
	$self = $_SERVER['PHP_SELF'];


	$result = @mysql_query("Select *
	From users
	WHERE user_name = '$username'");

	$fields = mysql_list_fields("majorgroupproject","users");
	$num_cols = mysql_num_fields($fields);

	if(mysql_num_rows($result)>0)
	{
		while($row = mysql_fetch_array($result))
		{

			$query="UPDATE users
			SET user_name='$newusername'
			WHERE user_name='$username'";

			$result = mysql_query($query) or die("SQL query failed");
			mysql_close($db_link);

			$_SESSION["username"]=$newusername;

			header('Location: userHome.php');
			/**************** CHANGE USERNAME SQL CODE GOES HERE!! *******************/
		}
	}
	else{
	echo "<span style='color:red;'>Sorry could not get results!!</span><br>";
	echo "<p style='color:red;'>Or wrong password used for this account</p>";
	}
}
?>