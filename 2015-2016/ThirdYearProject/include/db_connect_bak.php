<?php
function db_connect($db_name)
{
   $host_name = "localhost:8889";
   $user_name = "root";
   $password = "ffdeadbeaf";
   $db_link = mysql_connect($host_name, $user_name, $password)
      or die("Could not connect to $host_name");
   mysql_select_db($db_name)
      or die("Could not select database $db_name");
   return $db_link;
}
?>