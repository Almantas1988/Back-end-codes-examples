<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Kuno mases indeksas</title>
</head>
<body>

<h1>Kuno mases indekso skaiciuokle</h1>

<p>
    Kūno masės indeksas (KMI) – žmogaus masės ir ūgio kvadrato santykis,
    medicinoje ir mityboje naudojamas kaip rodiklis, leidžiantis įvertinti
    ar žmogaus masė yra normali, ar yra antsvoris bei nutukimas, ar svorio trūkumas,
    nors ir nepadedantis nustatyti kūno riebalų procento.
</p>

<form method="get">

    <?php if ( isset( $_GET['kg'] ) ) : ?>
    <div>Svoris (kg):
        <input type="number" name="kg" placeholder="0" value="<?php echo $_GET["kg"];?>"/>
    </div><br>

    <?php else: ?>
    <div>Svoris (kg):
        <input type="number" name="kg" placeholder="0">
    </div><br>
    <?php endif; ?>

    <?php if ( isset( $_GET['cm'] ) ) : ?>
    <div>Ugis (cm):
        <input type="number" name="cm" placeholder="0" value="<?php echo $_GET["cm"]?>">
    </div><br>

    <?php else: ?>
        <div>Ugis (cm):
            <input type="number" name="cm" placeholder="0">
        </div><br>

    <?php endif; ?>

    <input type="submit" value="Skaiciuoti KMI">

</form>

<?php if ( isset( $_GET['kg'] ) && isset( $_GET['cm'] ) ) :

$svoris = $_GET["kg"];
$ugis = $_GET["cm"];

$ugisMetrais = $ugis / 100;

$kmi = $svoris / ($ugisMetrais * $ugisMetrais);

$kmiSuapvalintas = round($kmi, 1);

?>

<h3>Tavo KMI: <?php echo $kmiSuapvalintas?></h3>

<?php endif; ?>

<br>

<table border="1">
    <tr>
        <th>KMI</th>
        <th>Isvada</th>
    </tr>

    <tr>
        <td><18.5</td>
        <td>Per mazas svoris/mitybos nepakankamumas</td>
    </tr>

    <tr>
        <td>18.5-24.9</td>
        <td>Normalus svoris, normali kuno mase</td>
    </tr>

    <tr>
        <td>25.0-29.9</td>
        <td>Antsvoris</td>
    </tr>

    <tr>
        <td>30.0-34.9</td>
        <td>I laipsnio nutukimas</td>
    </tr>

    <tr>
        <td>35.0-39.9</td>
        <td>II laipsnio nutukimas</td>
    </tr>

    <tr>
        <td>>40.0</td>
        <td>III laipsnio nutukimas</td>
    </tr>


</table>

</body>
</html>
