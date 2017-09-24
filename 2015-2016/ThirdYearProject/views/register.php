<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <!--<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>

    <link rel="icon" type="image/ico" href="images/icon.png">
    <style> @import "css/bootstrap.css";</style>
    <style> @import "css/bootstrap.min.css";</style>
    <script src="javaScript/jquery.js" type="text/javascript"></script>
    <script src="javaScript/bootstrap.js" type="text/javascript"></script>
    <script src="javaScript/bootstrap.min.js" type="text/javascript"></script>
    <style> @import "css/style.css";</style>

    <!-- TESTING ANIMATE -->
    <style> @import "../css/animate.css";</style>
    <!-- TESTING ANIMATE -->
</head>
<body>
<div class="animated fadeInDownBig" style="z-index: 99; position: relative;">
    <?php include 'include/header.php';?>
</div>
<div class="container">
    <div style="margin-top: 70px;text-align: center;">
        <h1 class="animated bounce">Sign Up</h1>

        <?php
        // show potential errors / feedback (from registration object)
        if (isset($registration)) {
            if ($registration->errors) {
                foreach ($registration->errors as $error) {
                    echo $error;
                }
            }
            if ($registration->messages) {
                foreach ($registration->messages as $message) {
                    echo $message;
                }
            }
        }
        ?>

        <div class="animated fadeInLeft">
            <!-- register form -->
            <form method="post" action="register.php" name="registerform">
                <div class="form-group">
                    <!-- the user name input field uses a HTML5 pattern check -->
                    <label for="login_input_username">Username</label>
                    <input id="login_input_username" class="login_input" type="text" pattern="[a-zA-Z0-9]{2,64}" name="user_name" required />
                </div>

                <div class="form-group">
                    <!-- the email input field uses a HTML5 email type check -->
                    <label for="login_input_email">E-mail</label>
                    <input id="login_input_email" class="login_input" type="email" name="user_email" required />
                </div>

                <div class="form-group">
                    <label for="login_input_password_new">Password (min. 6 characters)</label>
                    <input id="login_input_password_new" class="login_input" type="password" name="user_password_new" pattern=".{6,}" required autocomplete="off" />
                </div>

                <div class="form-group">
                    <label for="login_input_password_repeat">Repeat password</label>
                    <input id="login_input_password_repeat" class="login_input" type="password" name="user_password_repeat" pattern=".{6,}" required autocomplete="off" />
                </div>

                <div class="form-group">
                    <label for="nationality">Nationality</label>
                        <select name="nationality" required>
                            <option value="english">English</option>
                            <option value="german">German</option>
                            <option value="french">French</option>
                            <option value="spanish">Spanish</option>
                        </select>
                </div>
                    <br>
                    <div id="space">
                        <input type="submit"  name="register" value="Register" />
                        <input type="reset" value="Reset">
                    </div>


            </form>
        </div>
    </div>
</div>
<!-- backlink -->
<center>
<a href="index.php">Back to Login Page</a>
</center>
</body>
</html>