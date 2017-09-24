<?php session_start();?>
<?php include 'header.php';?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<!--<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Settings</title>

	<link rel="icon" type="image/ico" href="images/icon.png">
	<style> @import "css/bootstrap.css";</style>
	<style> @import "css/bootstrap.min.css";</style>
	<script src="javaScript/jquery.js" type="text/javascript"></script>
	<script src="javaScript/bootstrap.js" type="text/javascript"></script>
	<script src="javaScript/bootstrap.min.js" type="text/javascript"></script>
	<style> @import "css/style.css";</style>
	<script  src="javaScript/anamations.js" type="text/javascript"></script>

	<!-- TESTING ANIMATE -->
	<style> @import "css/animate.css";</style>
	<!-- TESTING ANIMATE -->
	<script  src="javaScript/anamations.js" type="text/javascript"></script>
</head>
<body>
<div class="animated fadeInDownBig" id="nav" style="z-index: 99; position: relative;">
    <?php include 'include/headerLOGIN.php';?>
</div>
	<div class="container" id="container">
		<center style="margin-top: 90px;">
        <div id="button_container">
			<h1 class="animated bounce">Settings</h1>
			<div class="animated fadeInLeft">
				<button type = "button" class = "btn btn-primary btn-lg btn-block" id="button_color" onclick="transition('password.php')">
					Change Password
				</button>
				<button type = "button" class = "btn btn-primary btn-lg btn-block" id="button_color" onclick="transition('email.php')">
					Change Email
				</button>
				<button type = "button" class = "btn btn-primary btn-lg btn-block" id="button_color" onclick="transition('username.php')">
					Change Username
				</button>
				<button type = "button" class = "btn btn-primary btn-lg btn-block" id="button_color" onclick="transition('lang.php')">
					Change Languages
				</button>
				<button type = "button" class = "btn btn-primary btn-lg btn-block" id="button_color" onclick="transition('userHome.php')" style="margin-bottom: 20px;">
					Main Menu
				</button>
			</div>
        </div>
			<!--
		<input type="button" onclick="window.location.href='password.php';" class="btn btn-default" id="button_size" value="Change Password">
		<input type="button" onclick="window.location.href='email.php';" class="btn btn-default" id="button_size" value="Change Email">
		<br>
		<input type="button" onclick="window.location.href='username.php';" class="btn btn-default" id="button_size" value="Change Username">
		<input type="button" onclick="window.location.href='lang.php';" class="btn btn-default" id="button_size" value="Change Languages">
		<br>
		<input type="button" onclick="window.location.href='userHome.php';" class="btn btn-default" id="button_size" value="Main Menu">-->
		</center>
	</div>
</body>
</html>