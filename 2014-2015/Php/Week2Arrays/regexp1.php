<html>
<head><title>Regular Expression examples</title></head>
<body>
<?php

// Strings consisting of one or more digits
// Note that the perl style needs delimiters
// inside the string

$regex_posix = "^[0-9]+$";


$string = "1234567890";

// Posix style

if ( ereg($regex_posix, $string) )
   echo "match<br/>";
else
   echo "no match<br/>";


?>
</body>
</html>
