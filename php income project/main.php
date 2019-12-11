<?php include 'duomenys.php'; ?>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Projektas</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            margin: 20px;;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: lightgreen;
        }

        .heading {
            background-color: aquamarine;

        }

        tr:nth-child(even) {
            background-color: #f2f2f2
        }


    </style>
</head>

<body>

<div class="container">
    <div class="row">
        <table>
            <tr>
                <th class="heading"> Vykdomi projektai</th>
            </tr>

            <tr class="heading2">
                <th>
                    <a href="?sort=short_name&order=<?php echo $sortDirection; ?>">
                        Sutrumpinimas
                    </a>
                </th>
                <th>
                    <a href="?sort=year&order=<?php echo $sortDirection; ?>">
                        Metai
                    </a>
                </th>
                <th>
                    <a href="?sort=program&order=<?php echo $sortDirection; ?>">
                        Programa
                    </a>
                </th>
                <th>
                    <a href="?sort=price&order=<?php echo $sortDirection; ?>">
                        Kaina
                    </a>
                </th>
            </tr>

            <?php foreach ($projects as $item) : ?>
                <tr>
                    <td>
                        <?php echo $item['short_name'] ?>
                    </td>

                    <td>
                        <?php echo $item['year'] ?>
                    </td>

                    <td>
                        <?php echo $item['program'] ?>
                    </td>

                    <td>
                        <?php echo $item['price'] ?>€
                    </td>
                </tr>

            <?php endforeach; ?>

        </table>
    </div>
</div>

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

?>

<div class="container">
    <div class="row">
        <table>
            <tr>
                <th class="heading"> Pajamos</th>
            </tr>

            <tr>
                <?php foreach ($pajamos as $key => $year) : ?>
                    <td><?php echo $key; ?></td>
                <?php endforeach; ?>
            </tr>
            <tr>
                <?php foreach ($pajamos as $year) : ?>
                    <td><?php echo $year; ?>€</td>
                <?php endforeach; ?>
            </tr>

        </table>
    </div>
</div>

<?php
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

<div class="container">
    <div class="row">
        <div class="col-8">
            <h3>Pajamos pagal metus</h3>

            <form method="get">
                <select class="form-control" name="year">
                    <option value="year"<?php echo (isset($_GET['year']) && $_GET['year'] == '2008') ? ' selected="selected"' : ''; ?>
                    >2008
                    </option>
                    <option value="2010"<?php echo (isset($_GET['year']) && $_GET['year'] == '2010') ? ' selected="selected"' : ''; ?>
                    >2010
                    </option>
                    <option value="2011"<?php echo (isset($_GET['year']) && $_GET['year'] == '2011') ? ' selected="selected"' : ''; ?>
                    >2011
                    </option>
                    <option value="2012"<?php echo (isset($_GET['year']) && $_GET['year'] == '2012') ? ' selected="selected"' : ''; ?>
                    >2012
                    </option>
                    <option value="2013"<?php echo (isset($_GET['year']) && $_GET['year'] == '2013') ? ' selected="selected"' : ''; ?>
                    >2013
                    </option>
                    <option value="2014"<?php echo (isset($_GET['year']) && $_GET['year'] == '2014') ? ' selected="selected"' : ''; ?>
                    >2014
                    </option>
                    <option value="2015"<?php echo (isset($_GET['year']) && $_GET['year'] == '2015') ? ' selected="selected"' : ''; ?>
                    >2015
                    </option>
                </select>
                <input type="submit" class="btn btn-success mt-3">
            </form>

            <h3> <?php if (isset ($year)) {
                    echo "Pajamos " . $year . " metais is projektu: " . $pajamos . "€";
                }; ?>
            </h3>
        </div>
    </div>

</body>
</html>



