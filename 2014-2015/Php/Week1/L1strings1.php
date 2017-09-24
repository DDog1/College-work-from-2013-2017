<html>
<head><title>Strings in PHP</title></head>
<body>
<h1>Strings in PHP</h1>
<?php

// Defined using single quotes

$str = 'Hello World';

// Interpolation occurs in doubly quoted strings
// for variables, \, ", and
// control chars such as newlines (\n)

echo "The string is \"$str\""; // use \" to get "

// but not in single quoted strings,
// except for ' and \

echo '<br>The string is "$str"';
echo '<br>This string contains a backslash \\ and \'single\' quotes';

// String concatenation uses the . operator

$str = "Hello " . "World"; // same as $str = "Hello World"
echo "<br>String concatenation gives $str";

// The heredoc syntax can also be used but its
// not as useful in PHP as it is in Perl

$big_string = <<<END
<br>This is line 1
<br>This is line 2
<br>This is line 3
<br>Variable interpolation works: $str 
END;

echo $big_string;

?>

</body>
</html>
