<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>House of Beauty</title>

	<style> @import "css/photoShow.css";</style>
	<!--<link href="themeroller/jquery-ui.css" rel="stylesheet">-->
	<link rel="icon" type="image/ico" href="images/image_1.ico">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="javaScript/jquery.js" type="text/javascript"></script>
	<script src="javaScript/photoShow.js" type="text/javascript"></script>
	<script src="javaScript/hideImage.js" type="text/javascript"></script>
	<script src="javaScript/load.js" type="text/javascript"></script>
	<script	src="http://maps.googleapis.com/maps/api/js"></script>
	<script src="javaScript/googleMap.js" type="text/javascript"></script>
	<script src="javaScript/setHomedefault.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<style> @import "css/style.css";</style>
	<style> @import "css/nav.css";</style>
	<style> @import "css/styleSwitcher.css";</style>
	<style> @import "css/Php.css"</style>
	<script src="javaScript/styleSwitcher.js"></script>

</head>
<body id="top">
<center>

	<img src="images/logo.png" style="width:30%;height:300px; float:left; margin:0; background-color:white;">
	<img src="images/headImage.jpg" style="width:70%;height:300px; margin:0;">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
		  <div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
			  <span class="icon-bar"></span>
			  <span class="icon-bar"></span>
			  <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#" id="home" onclick="showImage();">House of Beauty</a>
		  </div>
		  <div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
			<li id="treatments" onclick="clearSpace();"><a href="#" onclick="hideImage();">Treatments</a></li>
			<li id="packages" onclick="clearSpace();"><a href="#" onclick="hideImage();">Packages</a></li>
			<li id="specials" onclick="clearSpace();"><a href="#" onclick="hideImage();">Specials</a></li>
			<li id="gallery" onclick="clearSpace();"><a href="#" onclick="hideImage();">Gallery</a></li>
			<li id="contact" onclick="initialize();"><a href="#"  onclick="hideImage();">Contact us</a></li>
			</ul>
		  </div>
		</div>
	</nav>


</center>

	 <div id="switcher">
		<h3 style="color:#BA0BDA;">Style Switcher</h3>
		<div class="button selected" id="switcher-default">
		  Default
		</div>
		<div class="button" id="switcher-large">
		  Large Print
		</div>
      </div>

    <div id="photoShow" class="container-fluid" style="display:none;">
        <div class="current">
            <img src="images/image_5.jpe" alt="Photo Gallery" id="img_roll" class="gallery" />
        </div>
        <div>
            <img src="images/image_2.jpg" alt="Photo Gallery" id="img_roll" class="gallery" />
        </div>
        <div>
            <img src="images/image_3.jpg" alt="Photo Gallery" id="img_roll" class="gallery" />
        </div>
        <div>
            <img src="images/image_4.jpg" alt="Photo Gallery" id="img_roll" class="gallery" />
        </div>
    </div>

	<div id="updateArea" class="style" style="width:100%;height:100%;padding-top: 20px;padding-bottom: 40px;">

		<div id="Php">
			<?php
			$fullName=$_POST['fullName'];
			$eMail=$_POST['eMail'];
			$contactNumber=$_POST['contactNumber'];
			$date=$_POST['date'];

			echo("<h1>Processing Booking</h1>");
			echo("<p>Hello $fullName</p>");
			echo("<p>Your booking is being booked for $date.</p>");
			echo("<p>We will send you an email to say that you have being book for this day if it is available. If this day has being book we will contact you at the number that you have put down at($contactNumber). If we can't contact you by phone we will send an email to the following email address as follows($eMail).</p>");
			echo("<p>Thanking you House of Beauty</p>");
			?>
		</div>

	</div>
	<div id="googleMap" class="container-fluid"></div>


<footer>
<h2 style="float:left;"><a href="#top">Back to top</a></h2>
<h2 style="float:right;">&copy; 2015 House of Beauty</h2>
</footer>

</body>
</html>