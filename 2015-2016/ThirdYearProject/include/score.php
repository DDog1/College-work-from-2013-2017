<?php
	$username = $_SESSION["user_name"];
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
			$score = $row['score'];
			$questionsright = $row['QuestionRight'];
			$questionswrong = $row['QuestionsWrong'];
		}
	}
	else{
	echo "<span style='color:red;'>Sorry could not get results!!</span><br>";
	}
?>