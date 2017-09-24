<?php session_start();?>
<?php include 'header.php';?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<!--<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Change Password</title>

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
</head>
<body>
<div class="animated fadeInDownBig" id="nav" style="z-index: 99; position: relative;">
	<?php include 'include/headerLOGIN.php';?>
</div>
<div class="container" id="container">
    <div class="animated fadeInLeft">
        <center style="margin-top: 90px;">
        <h1>Change Password</h1>
        <?php include 'include/password.php';?>

        <form action="<?php echo($_SERVER['PHP_SELF']); ?>" method="POST">
            <label for="password" style="width:130px">Current Password</label>
            <input type="password" name="password">
            <br>
            <label for="password" style="width:122px">New Password</label>
            <input type="password" name="newPassword">
            <br>
            <label for="password" style="width:122px">Repeat New Password</label>
            <input type="password" name="repeatNewPassword">
            <br>
            <div id="space">
                <input type="submit" value="Submit">
                <input type="reset" value="Reset">
            </div>
        </form>
        <p>Click <a onclick="transition('settings.php')">here</a> to go back to settings</p>
        </center>
    </div>
</div>
</body>
</html>