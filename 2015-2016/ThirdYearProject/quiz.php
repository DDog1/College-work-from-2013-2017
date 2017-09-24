<?php session_start();?>
<?php include 'header.php';?>
<!-- Setting a php cookie in order to keep track of transition between levels
Cookie expires after one minute 


<?php include 'levels/db_conn.php'; ?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<!--<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Quiz</title>

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
	<div class="container">
		<center style="margin-top: 90px;">

        <div id="button_container">
            <h1 class="animated bounce">Quiz</h1>
            <div class="animated fadeInLeft">

                <?php
                //Setting up the varibles
                $username = $_SESSION['user_name'];
                $sql1 = "SELECT score FROM users WHERE user_name = '$username' ";
                $getScore = $dbc->query($sql1);

                $cookie_name = "ReBootNetworking";

                $newScore = 1;

                if($_COOKIE[$cookie_name]==1) {
                    $newScore=0;
                }
                if($_COOKIE[$cookie_name]==2) {
                    $newScore=1;
                }
                if($_COOKIE[$cookie_name]==3) {
                    $newScore=2;
                }

                //////////
                while($row = $getScore->fetch_assoc()){

                }
                /////////


                $query="UPDATE users
		    	SET score='$newScore'
			    WHERE user_name='$username'";
                $dbc->query($query);


                $sql = "SELECT score FROM users WHERE user_name = '$username' ";
                $result = $dbc->query($sql);

                if ($result->num_rows > 0) {
                    while ($row = $result->fetch_assoc()) {
                        if($row['score'] == 0){
                            echo('<button type = "button" class = "btn btn-primary btn-lg btn-block" id="button_color" onclick="window.location.href=\'levels/level1.php\';"> Level 1 </button>');
                            echo('<button type = "button" class = "btn btn-primary btn-lg btn-block" id="button_color" onclick="window.location.href=\'levels/level2.php\';" disabled> Level 2 </button>');
                            echo('<button type = "button" class = "btn btn-primary btn-lg btn-block" id="button_color" onclick="window.location.href=\'levels/level3.php\';" disabled> Level 3 </button>');
                        }
                        else if($row['score'] == 1){
                            echo('<button type = "button" class = "btn btn-primary btn-lg btn-block" id="button_color" onclick="window.location.href=\'levels/level1.php\';"> Level 1 </button>');
                            echo('<button type = "button" class = "btn btn-primary btn-lg btn-block" id="button_color" onclick="window.location.href=\'levels/level2.php\';"> Level 2 </button>');
                            echo('<button type = "button" class = "btn btn-primary btn-lg btn-block" id="button_color" onclick="window.location.href=\'levels/level3.php\';" disabled> Level 3 </button>');
                        }
                        else if($row['score'] == 2){
                            echo('<button type = "button" class = "btn btn-primary btn-lg btn-block" id="button_color" onclick="window.location.href=\'levels/level1.php\';"> Level 1 </button>');
                            echo('<button type = "button" class = "btn btn-primary btn-lg btn-block" id="button_color" onclick="window.location.href=\'levels/level2.php\';"> Level 2 </button>');
                            echo('<button type = "button" class = "btn btn-primary btn-lg btn-block" id="button_color" onclick="window.location.href=\'levels/level3.php\';"> Level 3 </button>');
                        }
                    }
                }

                $dbc->close();
                ?>
                <button type = "button" class = "btn btn-primary btn-lg btn-block" id="button_color" onclick="window.location.href='userHome.php';">
                    Main Menu
                </button>
            </div>

        </div>
		<!--<input type="button" onclick="window.location.href='levels/level1.php';" class="btn btn-default" id ="button_size" value="Level 1">
		<input type="button" onclick="window.location.href='level2.php';" class="btn btn-default" id ="button_size" value="Level 2" disabled>
		<br>
		<input type="button" onclick="window.location.href='level3.php';" class="btn btn-default" id ="button_size" value="Level 3" disabled>
		<input type="button" onclick="window.location.href='userHome.php';" class="btn btn-default" id ="button_size" value="Main Menu">-->

		</center>
	</div>
</body>
</html>