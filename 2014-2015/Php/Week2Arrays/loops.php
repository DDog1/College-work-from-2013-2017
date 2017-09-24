<html>
<head><title>Loop structures in PHP</title></head>
<body>
<h1>Loop structures in PHP</h1>
<?php

// The standard for loop for counting

   echo "<h3> Using a Standard For Loop  for Counting </h3>";

   for ($count = 1; $count <= 10; $count++)
   {
      echo $count, ' ';
   }
   echo "<br>";

// The standard for loop for an indexed array.
// Here count is a function that returns the number
// of elements in the array

   echo "<h3> Using a For Loop  for and Indexed Array </h3>";

   $ages = array(34, 56, 45, 57);

   for ($k = 0; $k < count($ages); $k++)
   {
      echo "$ages[$k] ";
   }
   echo "<br>";

// The foreach loop for indexed arrays is better in this
// case since we don't need to use the index:


   echo "<h3> Using a Foreach Loop  for an Indexed Array </h3>";

   foreach ($ages as $age)
   {
      echo "$age ";
   }
   echo "<br>";

// The foreach loop for associative arrays


   echo "<h3> Using a Foreach Loop  for an Associative Array </h3>";

   $product = array('id' => 1, 'desc' => 'No-name PC', 'price' => 150.0);

   foreach ($product as $key => $value)
   {
      echo "<br>key = $key, value = $value";
   }
   echo "<br>";

// Iterator form using a while loop
// More efficient than foreach since foreach makes a copy of the array

   echo "<h3> Using While (list ..)  Loop  for an Associative Array </h3>";

   reset($product);
   while( list($key, $value) = each($product))
   {
      echo "<br>key = $key, value = $value";
   }
   echo "<br>";

?>
</body>
</html>
