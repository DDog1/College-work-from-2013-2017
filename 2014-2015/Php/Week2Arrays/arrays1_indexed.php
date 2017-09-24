<html>
<head><title>Defining indexed arrays in PHP</title></head>
<body>
<h1>Defining indexed arrays in PHP</h1>
<?php

// Defining an empty array

$a = array();

// Defining an array simply by assigning
// values (arrays ara dynamic)

$b[0] = 100;
$b[1] = 200;
$b[] = 300; // same as $b[2] = 300;
$b[] = 400; // same as $b[3] = 400;

// Defining arrays using array(...)

$c = array(100,200,300,400);
$day_names = array('Sunday', 'Monday', 'Tuesday', 'Wednesday',
   'Thursday', 'Friday', 'Saturday');

// Array elements dont need to all be
// of the same type

$mix = array('off', 0, 'on', 1);

// var_export displays info about a variable
// (useful for debugging)
// Also see print_r and var_dump

// The count function returns the number
// of elements in an array

echo "Using VAR_EXPORT() to print the array". "<br> <br>";
echo "Using COUNT() to count the number of elements in the array". "<br> <br>";

echo 'Elements in array B :', var_export($b), "<br/>";

echo 'Elements in array C :',var_export($c), "<br/>";

echo 'Elements in array Day_Names :',var_export($day_names), "<br/>";
echo 'The number of elements in this array is ', count($day_names), "<br/>";
echo 'A mixed type array is ', var_export($mix), "<br/>";

?>
</body>
</html>
