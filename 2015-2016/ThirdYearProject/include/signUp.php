<?php
	if(isset($_POST['username']))
	{
		$username = $_POST['username'];
		$password = $_POST['password'];
		$name = $_POST['name'];
		$email = $_POST['email'];
		$nationality = $_POST['nationality'];

		require_once("./include/db_connect.php");
		$db_link = db_connect("majorgroupproject");
		$self = $_SERVER['PHP_SELF'];

		$result = @mysql_query("Select *
		From users
		WHERE username LIKE '$username'");

		$fields = mysql_list_fields("majorgroupproject","users");
		$num_cols = mysql_num_fields($fields);

		?>

		<?php
		$inDatabase='false';
		if(mysql_num_rows($result)>0)
		{
			while($row = mysql_fetch_array($result))
			{
				$inDatabase='true';
				if($inDatabase=='true')
				{
					echo "<p style='color:red;'>$username is in the database.</p>";
					echo "<p style='color:red;'>Please pick a different username.</p>";
				}
			}
		}
		else
		{
			$username = $_POST['username'];
			$password = $_POST['password'];
			$name = $_POST['name'];
			$nationality = $_POST['nationality'];

			require_once("include/db_connect.php");
			$db_link = db_connect("majorgroupproject");

			$amount = @mysql_query("Select *
			From users");
			$ID = mysql_num_rows($amount);
			$ID = $ID+1;

			$query = "INSERT INTO users VALUES ('".$ID."','".$name."','".$username."','".$password."','".NULL."','".NULL."','".NULL."','".$email."','".$nationality."')";
			$result = mysql_query($query) or die("SQL query failed");
			// echo "$ID";
			mysql_close($db_link);

			$_SESSION["password"]=$password;

			echo "$username is not in the database and will be added now hello and welcome to our first ever app $username";
			$inDatabase='false';
			$_SESSION["username"]=$username;
			header('Location: userHome.php');
		}

	}
	?>