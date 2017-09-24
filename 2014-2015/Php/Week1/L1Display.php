

//DISPLAY.PHP

<html>
<head><title>Using echo and print</title></head>
<body>
<h1>Using echo and print</h1>
<?php

// Echo can be used with or without
// parentheses

echo "Hello World<br>";
echo("Hello World<br>");

// If you use it without parentheses
// then there can be several arguments
// separated by commas

echo "Hello ", "World", "<br>";

// print can be used with or without
// parentheses but can only have one
// argument

print "Hello World<br>";
print("Hello World<br>");

// HERE DOCUMENTS are also available in PHP.
// Can put a number of lines with html tags in an echo statement


echo <<<END_DOC
<p>
A bullet list
<ul>
<li>Item 1</li>
<li>Item 2</li>
<li>Item 3</li>
</ul>
</p>
END_DOC;

// There is also a formatted version of print
// called printf which comes from C. You need
// to use preformatted mode to see the proper
// spacing.

$sqrt2 = sqrt(2.0);
printf("<pre>The square root of %d is %0.5f</pre>", 2, $sqrt2);
printf("<pre>The square root of %10d is %20.14f</pre>", 2, $sqrt2);

?>
</body>
</html>

========================================================================
SCALARS.PHP

<html>
<head><title>Scalar Data Types in PHP</title></head>
<body>
<h1>Scalar Data Types in PHP</h1>
<?php

// ------------------------------------------
// PHP is a loosely typed language: there are 8 
// built-in data types. Variable names begin
// with a dollar sign and can have letters,
// digits and underscores as characters
// (first character cannot be a digit).
//
// Names are case sensitive and it seems to
// be a convention to use underscores to
// simulate spaces in variable names
// ------------------------------------------
// The four scalar data types are integer,
// double, string, and boolean
// ------------------------------------------

$number_of_students = 10;
$in_to_cm = 2.54;
$big_num = 1.2345e45;
$greeting = 'Hello World'; // or use " .."

// Any variable in PHP can be evaluated as a
// boolean (there are rules) or the values
// true (1) and false (0) can be used.

$success = true; // 0 is false, non-zero true
$failure = false;

// Use echo or print to display them on a
// web page. Note that variable interpolation
// takes place within double quoted strings.
// Note that \$ is used if you want a literal
// dollar sign in a string

echo "<h2>Interpolation in doubly quoted strings</h2>";
echo "Value of \$number_of_students is $number_of_students<br>";
echo "Value of \$in_to_cm is $in_to_cm<br>";
echo "Value of \$big_num is $big_num<br>";
echo "Value of \$greeting is $greeting<br>";
echo "Value of \$success is $success</br>";

// Default display of false is nothing so
// typecast to see 1 displayed

echo "Value of \$failure is ", $failure, "<br>"; 
echo "Value of (int) \$failure is ", (int) $failure, "<br>"; 

// There is no variable interpolation in
// singly quoted strings:

echo "<h2>No interpolation in singly quoted strings</h2>";
echo 'Value of \$number_of_students is $number_of_students<br>';

?>
</body>
</html>

==========================================================================================
ARITHMETIC.PHP

<html>
<head><title>Arithmetic in PHP</title></head>
<body>
<h1>Arithmetic in PHP</h1>
<?php

// Arithmetic is similar to Perl

$a = 5;
$b = 3;

// Division is done using floating
// point arithmetic

echo "<pre>";
echo "$a + $b = ", $a + $b, "\n";
echo "$a - $b = ", $a - $b, "\n";
echo "$a * $b = ", $a * $b, "\n";
echo "$a / $b = ", $a / $b, "\n\n";

// Type casting must be uses to get an
// integer division

echo "(int) ($a / $b) = ", (int)($a / $b), "\n";
echo "$a % $b = ", $a % $b, "\n\n";

// There are also the arithmetic assignment
//  operators such as +=, and *= and the
// increment ++ and decrement -- operators.

// Conversions among string and numeric types

$a = 123;
$b = '345Hello';
$c = 456;

$sum = $a + $b; // this gives 123 + 345 = 468
$str = $a . $c; // integer converted to string

echo "The sum of $a and '$b' is $sum\n";
echo "The concatenation of '$a' and $c is $str\n";
echo "</pre>";
?>
</body>
</html>

