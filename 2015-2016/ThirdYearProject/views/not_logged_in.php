<?php
// show potential errors / feedback (from login object)
if (isset($login)) {
    if ($login->errors) {
        foreach ($login->errors as $error) {
            echo $error;
        }
    }
    if ($login->messages) {
        foreach ($login->messages as $message) {
            echo $message;
        }
    }
}
?>

<!-- login form box -->
<div class="animated fadeInLeft">
    <form method="post" action="index.php" name="loginform">

        <div class="form-group">
            <label for="login_input_username">Username</label>
            <input id="login_input_username" class="login_input" type="user_name" name="user_name" placeholder="Enter Name" required />
        </div>
        <br>

        <div class="form-group">
            <label for="login_input_password">Password</label>
            <input id="login_input_password" class="login_input" type="password" name="user_password" autocomplete="off" placeholder="Enter Password" required />
        </div>

        <div id="space">
            <input type="submit" name="login" value="Login">
            <input type="reset" value="Reset">
        </div>

        <a href="accountreset.php">Account Issues?</a>

    </form>

    <a href="register.php">Register new account</a>
</div>