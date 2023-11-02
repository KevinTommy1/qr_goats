<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link href="http://fonts.cdnfonts.com/css/centrale-sans-regular"
	rel="stylesheet">
<link rel="stylesheet" href="content/css/absentie.css">

<style>
@import url('http://fonts.cdnfonts.com/css/centrale-sans-regular');
</style>
</head>

<body>
	<a class="terugButton">
		<p class="terug"><</p>
	</a>

	<img id="sandImage" src="content/embed/zandklok.png">
	</img>
	<div class="overzichtHeader">

		<h2>Absentie overzicht</h2>
	</div>

	<div class="totale-presentie-view">
		<div class="geno">
			<div class="totale-presentie">

				<h2>Aanwezig</h2>
				Aantal lesuren<br>
				<p class="toon-uren">
					<label>0</label>&nbsp;uur
				</p>
				<br> Aantal uren<br>
				<p class="toon-uren">
					<label>0</label>&nbsp;uur
				</p>
			</div>
			<div class="totale-presentie">
				<h2>Geoorloofd afwezig</h2>
				Aantal lesuren<br>
				<p class="toon-uren">
					<label>0</label>&nbsp;uur
				</p>
				<br> Aantal uren<br>
				<p class="toon-uren">
					<label>0</label>&nbsp;uur
				</p>
			</div>
		</div>
		<div class="geno">
			<div class="totale-presentie">
				<h2 id="idee">Ongeoorloofd</h2>
				Aantal lesuren<br>
				<p class="toon-uren red">
					<label>0</label>&nbsp;uur&nbsp;<i class="flaticon warning-1"></i>
				</p>
				<br> Aantal uren<br>
				<p class="toon-uren red">
					<label>0</label>&nbsp;uur&nbsp;<i class="flaticon warning-1"></i>
				</p>
			</div>
			<div class="totale-presentie last">
				<h2>Niet geregistreerd</h2>
				Aantal lesuren<br>
				<p class="toon-uren">
					<label>0</label>&nbsp;uur
				</p>
				<br> Aantal uren<br>
				<p class="toon-uren">
					<label>0</label>&nbsp;uur
				</p>
			</div>
		</div>
	</div>
</body>

</html>