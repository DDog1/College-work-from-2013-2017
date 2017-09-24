<html>
<head><title>Comparisons in PHP</title></head>
<body>
<h1>Comparisons in PHP</h1>
<?php

// Note the difference between == and ===
// \$a --- prints out the signs $a --- not the value

$a = "0";
$b = 0;

echo "<pre>";
if ($a == $b)
{
   echo "\$a == \$b\n"; // this is the result
}
else
{
   echo "\$a != \$b\n";
}


if ($a === $b)
{
   echo "\$a === \$b\n";
}
else
{
   echo "\$a !== \$b\n"; // this is the result
}
echo "</pre>";

?>

</body>
</html>
