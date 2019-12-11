<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Viktorina</title>
    <style>
        .true {
            color: green;
            padding: 20px;
            font-size: 20pt;
        }

        .false {
            color: red;
            padding: 20px;
            font-size: 20pt;
        }
    </style>
<body>

<h1>Apklausa</h1>

<form method="get">

    <img src="image/elnias.jpg" height="200px">

    <div> Koks tai gyvunas? </div>

    <?php if ( isset( $_GET['variantas']) && $_GET["variantas"] == 1 ) : ?>

    <div>
        <input type="radio" name="variantas" checked value="1"> Elnias<br>
    </div>

    <?php else: ?>

    <div>
        <input type="radio" name="variantas" value="1"> Elnias<br>
    </div>

    <?php endif; ?>

    <?php if ( isset( $_GET['variantas']) && $_GET["variantas"] == 2 ) : ?>

        <div>
            <input type="radio" name="variantas" checked value="2"> Suo<br>
        </div>

    <?php else: ?>

        <div>
            <input type="radio" name="variantas" value="2"> Suo<br>
        </div>

    <?php endif; ?>

    <?php if ( isset( $_GET['variantas']) && $_GET["variantas"] == 3 ) : ?>

        <div>
            <input type="radio" name="variantas" checked value="3"> Katinas<br>
        </div>

    <?php else: ?>

        <div>
            <input type="radio" name="variantas" value="3"> Katinas<br>
        </div>

    <?php endif; ?>

    <?php if ( isset( $_GET['variantas']) && $_GET["variantas"] == 4 ) : ?>

        <div>
            <input type="radio" name="variantas" checked value="4"> Begemotas<br>
        </div><br>

    <?php else: ?>

        <div>
            <input type="radio" name="variantas" value="4"> Begemotas<br>
        </div><br>

    <?php endif; ?>

    <input type="submit" value="Speti">

    <?php

    if (isset ($_GET["variantas"])) :

        $atsakymas = $_GET["variantas"];

        if ($atsakymas == 1) : ?>
            <div class="true">Teisingai</div>

        <?php else: ?>
            <div class="false">Neteisingai</div>

        <?php endif; ?>

    <?php endif; ?>

</form>

</body>
</html>
