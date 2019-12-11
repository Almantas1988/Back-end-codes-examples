<?php
$pajamos = [];

foreach ($projects as $project) {

    if (isset($pajamos[$project['year']])) {
        $pajamos[$project['year']] += $project['price'];
    } else {
        $pajamos[$project['year']] = 0;
        $pajamos[$project['year']] += $project['price'];
    }
}

ksort($pajamos);

$year = $_GET['year'];

$pajamos = getYears($projects, $year);

function getYears($projects, $year)
{
    $suma = 0;
    foreach ($projects as $key) {
        if ($key['year'] === $year) {
            $suma += $key['price'];
        }
    }
    return $suma;
}







?>


