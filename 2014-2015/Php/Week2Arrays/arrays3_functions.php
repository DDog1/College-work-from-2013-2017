<html>
<head><title>Some array functions in PHP</title></head>
<body>
<h1>Some array functions in PHP</h1>
<?php

// Using list to give names to elements
// of an indexed array

$product = array(123, 'No-name PC', 549.99);

list ($id, $description, $price) = $product;

echo "<p>";
echo "id = $id<br/>";
echo "description = $description<br/>";
echo "price = $price</p>";

// Assigning a range of values to an array

$count = range(1,10);
$letters = range('a', 'z');

echo "<p>Numeric range is ", var_export($count), "<br/>";
echo "Letter range is ", var_export($letters), "</p>";

// Extracting an array slice from an array

$letters_2 = array_slice($letters, 5, 10); // 'f' to '0'
echo "<p>Slice is ", var_export($letters_2), "<p>";

// Extracting keys for an associative array

$product = array('id' => 123, 'desc' => null, 'price' => 549.99);
$product_keys = array_keys($product);
echo "<p>Associative array is ", var_export($product), "<br/>";
echo "Array of keys is ", var_export($product_keys), "<p>";

// Checking if an array key exists using
// array_key_exists

$product = array('id' => 1, 'desc' => null, 'price' => 549.99);
echo "<p>Associative array is ", var_export($product), "<br/>";
if (array_key_exists('desc', $product))
{
   echo "Key 'desc' exists</p>";
}
else
{
   echo "Key 'desc' does not exist</p>";
}

// Checking if an array key exists and is
// not null using isset

$product = array('id' => 1, 'desc' => null, 'price' => 549.99);
echo "<p>Associative array is ", var_export($product), "<br/>";
if (isset($product['desc']))
{
   echo "isset: Key exists and is not null </p>";
}
else
{
   echo "isset: Key does not exist or is null</p>";
}

?>
</body>
</html>
