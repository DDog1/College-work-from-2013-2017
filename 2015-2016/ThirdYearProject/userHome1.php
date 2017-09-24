<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<!--<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Menu</title>

	<link rel="icon" type="image/ico" href="images/icon.png">
	<style> @import "css/bootstrap.css";</style>
	<style> @import "css/bootstrap.min.css";</style>
	<script src="javaScript/jquery.js" type="text/javascript"></script>
	<script src="javaScript/bootstrap.js" type="text/javascript"></script>
	<script src="javaScript/bootstrap.min.js" type="text/javascript"></script>
	<style> @import "css/style.css";</style>
    <link rel="stylesheet" type="text/css" href="css/slicebox.css" />
    <link rel="stylesheet" type="text/css" href="css/custom.css" />
	<script  src="javaScript/anamations.js" type="text/javascript"></script>
    <script type="text/javascript" src="javaScript/modernizr.custom.46884.js"></script>
    <script type="text/javascript" src="javaScript/jquery.slicebox.js"></script>
    <script type="text/javascript">
        $(function() {
            var Page = (function() {
                var $navArrows = $( '#nav-arrows' ).hide(),
                    $navOptions = $( '#nav-options' ).hide(),
                    $shadow = $( '#shadow' ).hide(),
                    slicebox = $( '#sb-slider' ).slicebox( {
                        onReady : function() {

                            $navArrows.show();
                            $navOptions.show();
                            $shadow.show();
                        },
                        orientation : 'h',
                        cuboidsCount : 3
                    } ),
                    init = function() {
                        initEvents();
                    },
                    initEvents = function() {
                        // add navigation events
                        $navArrows.children( ':first' ).on( 'click', function() {
                            slicebox.next();
                            return false;
                        } );
                        $navArrows.children( ':last' ).on( 'click', function() {
                            slicebox.previous();
                            return false;
                        } );
                        $( '#navPlay' ).on( 'click', function() {
                            slicebox.play();
                            return false;
                        } );
                        $( '#navPause' ).on( 'click', function() {
                            slicebox.pause();
                            return false;
                        } );
                    };
                return { init : init };
            })();
            Page.init();
        });
    </script>
</head>
<body>

    <nav class="navbar navbar-default navbar-fixed-top" style="background-color:#732C7B">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               	<h1 id="title">Reboot Networking</h1>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a href="index.php?logout">Log Out</a>
                    </li>
                    <li>
                        <a href="about.php">About</a>
                    </li>
                    <li>
                        <a href="contact.php">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    <br>
<div class="container">

        <br>
		<h1 align="center">Main Menu</h1>
        <div class="wrapper">

            <ul id="sb-slider" class="sb-slider">
                <li>
                    <a href="quiz.php"><img src="images/playButton.png" alt="Play Now!"/></a>
                </li>
                <li>
                  	<a href="score.php"><img src="images/scoreButton.png" alt="My Score"/></a>
                </li>
                <li>
                    <a href="settings.php"><img src="images/settingsButton.png" alt="Settings"/></a>
                </li>
            </ul>

            <div id="shadow" class="shadow"></div>

            <div id="nav-arrows" class="nav-arrows">
                <a href="#">Next</a>
                <a href="#">Previous</a>
            </div>

            <div id="nav-dots" class="nav-dots">
                <span class="nav-dot-current"></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </div>

        </div><!-- /wrapper -->
        <!--
        <input type="button" onclick="window.location.href='index.php?logout';" class="btn btn-default" id="button_size" value="Logout">
    		<input type="button" onclick="window.location.href='score.php';" class="btn btn-default" id="button_size" value="Score">
    		<br>
    		<input type="button" onclick="window.location.href='quiz.php';" class="btn btn-default" id="button_size" value="Quiz">
    		<input type="button" onclick="window.location.href='settings.php';" class="btn btn-default" id="button_size" value="Settings">
        -->
</div>
</body>

</html>