<?php session_start();?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<!--<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Sign Up</title>

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
</head>
<body>
<div class="animated fadeInDownBig" style="z-index: 99; position: relative;">
    <?php include 'include/header.php';?>
</div>
<div class="container">
    <center style="margin-top: 90px;">

        <h1 class="animated bounce">Reset your account here:</h1>
        <?php include 'include/accountReset.php';?>
        <div class="animated fadeInLeft">
            <form action="<?php echo($_SERVER['PHP_SELF']); ?>" method="POST">
                <label for="email">Email</label>
                <input type="email" name="email" id="email" required>
                <br>
                <label for="password">Password</label>
                <input type="password" name="password">
                <br>
                <label for="password">Confirm Password</label>
                <input type="password" name="newpassword">
                <br>
                <div id="space">
                    <input type="submit" value="Submit">
                    <input type="reset" value="Reset">
                </div>
            </form>
            <a href="index.php">Back to Login Page</a>
        </div>
    </center>
</div>
</body>
</html>