<html>
<head><title>Some string functions in PHP</title></head>
<body>
<h1>Some string functions in PHP</h1>
<?php

// Adding slashes for strings that go in databases:
// single quotes, double quotes, backslash and nulls
// are escaped with a backslash

$str_1 = 'Hello " " \\';
$str_2 = addslashes($str_1);
$str_3 = stripslashes($str_2);
?>

<pre>
Before addslashes: <?php echo $str_1?> 
After addslashes:  <?php echo $str_2?> 
After stripslahes: <?php echo $str_3?> 
</pre>

<?php

// htmlspecialchars converts just enough html to
// entities so that the html is displayed as text.
// htmlentities translates all HMTL entities.
// See function references in the PHP manual.
// there is also html_entity_decode to do the inverse 

$str_1 = '<h1>"Design"  <<< & >>> Code</h1>';
$str_2 = htmlspecialchars($str_1);
$str_3 = htmlentities($str_1);
?>

<p>Before conversion : <?php echo $str_1?></p> 
<p>After conversion with htmlspecialchars:  <?php echo $str_2?></p>
<p>After conversion with htmlentities:      <?php echo $str_3?></p>

</body>
</html>

