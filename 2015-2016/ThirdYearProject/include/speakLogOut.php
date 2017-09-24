<?php
	$username = $_SESSION["username"];
	require_once("include/db_connect.php");
	$db_link = db_connect("majorgroupproject");
	$self = $_SERVER['PHP_SELF'];


	$result = @mysql_query("Select *
	From users
	WHERE username LIKE '$username'");

	$fields = mysql_list_fields("majorgroupproject","users");
	$num_cols = mysql_num_fields($fields);


	if(mysql_num_rows($result)>0)
	{
		while($row = mysql_fetch_array($result))
		{
			$speak = $row['Nationality'];
			echo $speak;
			if($speak=="english")
			{
				echo "<audio controls autoplay src = '../media/langs/english/bye.mp3' hidden='true'></audio>";
				session_destroy();
			}
			if($speak=="spanish")
			{
				echo "<audio controls autoplay src = '../media/langs/spanish/adios.mp3' hidden='true'></audio>";
				session_destroy();
			}
			else
			{
				echo "<audio controls autoplay src = '../media/langs/english/bye.mp3' hidden='true'></audio>";
			}
		}
	}
?>