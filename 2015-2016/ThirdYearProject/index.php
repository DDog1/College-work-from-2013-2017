<?php
ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);
                require_once("config/db.php");

                // load the login class
                require_once("classes/Login.php");

                // create a login object. when this object is created, it will do all login/logout stuff automatically
                // so this single line handles the entire login process. in consequence, you can simply ...
                $login = new Login();

				$cookieName = "ReBootNetworking";
				if(!isset($_COOKIE[$cookieName])){
				setcookie("$cookieName", 1, time() + (86400 * 30), "/");
				}
?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>

	<!--<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Boombastics</title>
	<link rel="apple-touch-icon" href="images/iconIphone.png" />
	<link rel="icon" type="image/ico" href="images/icon.png">
	<style> @import "css/bootstrap.css";</style>
	<style> @import "css/bootstrap.min.css";</style>
	<script src="javaScript/jquery.js" type="text/javascript"></script>
	<script src="javaScript/bootstrap.js" type="text/javascript"></script>
	<script src="javaScript/bootstrap.min.js" type="text/javascript"></script>
	<style> @import "css/style.css";</style>

    <!-- TESTING ANIMATE -->
    <style> @import "css/animate.css";</style>
    <!-- TESTING ANIMATE -->

	<!-- Begin Cookie Consent plugin by Silktide - http://silktide.com/cookieconsent -->
	<script type="text/javascript">
		window.cookieconsent_options = {"message":"This application uses cookies to ensure you get the best experience throughout our application.","dismiss":"Sure Thing!","learnMore":"More Info.","link":null,"theme":"light-floating"};
	</script>

	<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/cookieconsent2/1.0.9/cookieconsent.min.js"></script>
	<!-- End Cookie Consent plugin -->

</head>
<body>
<div class="animated fadeInDownBig" style="z-index: 99; position: relative;">
<?php include 'include/header.php';?>
</div>
<center>
	<div class="container">
		<br>
        <img src="images/icon.png" class="animated flip" id="user-default" width="200px">
        <?php
                // checking for minimum PHP version
                if (version_compare(PHP_VERSION, '5.3.7', '<')) {
                    exit("Sorry, the system requires PHP version greater than 5.3.7 !");
                } else if (version_compare(PHP_VERSION, '5.5.0', '<')) {
                    // if you are using PHP 5.3 or PHP 5.4 you have to include the password_api_compatibility_library.php
                    // (this library adds the PHP 5.5 password hashing functions to older versions of PHP)
                    require_once("libraries/password_compatibility_library.php");
                }

                // include the configs / constants for the database connection

                // ... ask if we are logged in here:
                if ($login->isUserLoggedIn() == true) {
                    // the user is logged in. you can do whatever you want here.
                    // for demonstration purposes, we simply show the "you are logged in" view.
                    // include("views/logged_in.php");
                    die("<script>location.href = 'userHome.php'</script>");
                    // include("userHome.php");
                    $user_name = $_SESSION['user_name'];



                } else {
                    // the user is not logged in. you can do whatever you want here.
                    // for demonstration purposes, we simply show the "you are not logged in" view.
                    include("views/not_logged_in.php");
                }
        ?>

        <?php include 'include/footer.php';?>
	</div>
</center>
</body>
</html>
