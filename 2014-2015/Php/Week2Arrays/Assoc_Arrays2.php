<html>
<head><title>Associative arrays in PHP</title></head>
<body>
<h1>Associative arrays in PHP</h1>
<?php

// Define an associative array using keys
// and values.

$age = array( 'Fred' => 37, 'Gord' => 23, 'Alice' => 17, 'Bob' => 23 );

echo "Original Value ----- Fred's age is {$age['Fred']}<br/>";
echo "Assign a new age to Fred i.e. 65 years <br/> <br/>";

// Assign a new age for Fred

$age['Fred'] = 65;

// Interpolating associative array elements
// requires braces

echo "Fred's age is {$age['Fred']}<br/>";

// Another way to do this is

echo "Fred's age is ", $age['Fred'], "<br/><br/>";

// Using associative array to represent
// a database record

echo "<h3><b> Using an associative array to represent a database record </b></h3><br/>";

$account = array('number' => 123, 'name' => 'Fred', 'balance' => 450.50);
echo 'Account balance is ', $account['balance'], '<br/>';
$account['balance'] += 100; // deposit 100 dollars
echo "New account balance is {$account['balance']}<br/><br/>";

// Associative arrays with arrays as values

echo "<h3><b> Using an associative array with arrays as values </b></h3><br/>";


$colors = array( 'red' => array(255,0,0), 'green' => array(0,255,0),
              'blue' => array(0,0,255), 'yellow' => array(255,255,0),
              'brown' => array(128,64,0) );

// Accessing components

$yellow_array = $colors['yellow'];
$red_component = $colors['yellow'][0];

echo 'color array is ', var_export($colors), '<br/><br/>';
echo 'Yellow array is ', var_export($yellow_array), '<br/><br/>';
echo "Red component of yellow array is $red_component<br/>";

?>
</body>
</html>
