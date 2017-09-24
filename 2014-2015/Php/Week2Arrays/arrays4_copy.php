<html>
<head><title>Copying arrays in PHP</title></head>
<body>
<h1>Copying arrays in PHP</h1>
<?php
 
// Define an associative array using keys
// and values, make a copy, change entry in
// copy. This shows that assignment is a copy
// operation in PHP

// NOTE: In Java array assignment is not an
// array copy operation. It just makes
// another reference to the array

$age = array( 'Fred' => 37, 'Gord' => 23, 'Alice' => 17, 'Bob' => 23 );
$age_copy = $age;
$age_copy['Fred'] = 45; // only changes copy

echo '<p>Original array is ', var_export($age), '<br/>';
echo 'Copy is ', var_export($age_copy), '</p>';
echo '<p>Copy after change is ', var_export($age_copy), '<br/>';
echo 'Original array after change is ', var_export($age), '</p>';

?>
</body>
</html>
