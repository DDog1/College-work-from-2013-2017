<html>
<head><title>Sorting arrays in PHP</title></head>
<body>
<h1>Sorting arrays in PHP</h1>
<?php

// sort: increasing alphabetical order
// rsort: decreasing alphabetical order

echo "<br> <u><b> SORT() </b></u> -- sort in ascending sequence";
echo "<br> <u><b> RSORT() </b></u> --- sort in descending sequence </br><p>";

$names = array("Fred", "Ted", "Barney", "Gord", "Ralph");
sort($names);
echo var_export($names), '<br/>';
rsort($names);
echo var_export($names), '<br/>';

// Sorting numbers in either order

$numbers = array(4,3,550,6,8,7);
sort($numbers);
echo var_export($numbers), '<br/>';
rsort($numbers);
echo var_export($numbers), '<br/>';

// sorting associative array by values or keys
echo "<br> <u><b> ASORT() </b></u> -- sort an ASSOCIATIVE ARRAY by VALUES";
echo "<br> <u><b> KSORT() </b></u> --- sort an ASSOCIATIVE ARRAY by KEYS </br><p>";

$ages = array('Fred' => 34, 'Ted' => 45, 'Barney' => 23, 'Gord' => 15);
asort($ages);
echo var_export($ages), '<br/>';
ksort($ages);
echo var_export($ages), '<br/>';

?>
</body>
</html>
