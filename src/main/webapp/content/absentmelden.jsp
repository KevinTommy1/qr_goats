<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="content/Javascript/faq.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="content/css/telaatmelden.css">
<link rel="stylesheet" href="content/css/main.css">

<script>
	function confirmRequest() {
		confirm("Ben je zeker dat je een melding wilt versturen?");
	}
</script>
<title>Absent Melden</title>

<t:navbar currentPage="absent">
	<!-- This should import the navbar -->
</t:navbar>
</head>
<body>


	<center>

		<div class="top-bar">
			<h1 class="title">Absentie</h1>
		</div>

		<div class="content">


			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<div class="card text-white mb-3">
							<div id="melden">
								<h1>Absent melden</h1>
								<div class="card-body">
									<form method="POST">
										<!-- Vorm van melding selecteren -->
										<div class="form-group">
											<label for="exampleFormControlSelect2">Kies uw
												melding</label> <select class="form-control"
												id="exampleFormControlSelect2">
												<option>Kies een optie...</option>
												<option>Ziek melden</option>
												<option>Laat melden</option>
												<option>Verlof aanvragen</option>
												<!-- Nieuwe optie voor verlof aanvraag -->
											</select>
										</div>
									</form>
								</div>
							</div>
						</div>

						<!-- Te laat melden -->
						<div id="telaatmelden">
							<div class="card text-white bg-white mb-3">
								<h1>Laat melden</h1>
								<div class="card-body">
									<form action="laatMelding" method="POST">
										<div class="form-group">
											<label for="exampleFormControlSelect1">Reden</label> <select
												class="form-control" id="exampleFormControlSelect1"
												name="reden">
												<!-- Te laat reden selecteren -->
												<option>Verslapen</option>
												<option>OV vertraging</option>
												<option>Overige</option>
											</select>

											<div id="opmerking">
												<div class="form-group">
													<label for="exampleFormControlTextarea1">Opmerking</label>
													<textarea class="form-control"
														id="exampleFormControlTextarea1" name="opmerking" rows="1"></textarea>
												</div>
											</div>
											<button type="submit" onclick="confirmRequest()"
												class="btn btn-primary">Melden</button>
										</div>
									</form>
								</div>
							</div>
						</div>

						<!-- Ziek melden -->
						<div id="ziekmelden">
							<div class="card text-white bg-white mb-3">
								<h1>Ziek melden</h1>
								<div class="card-body">
									<form action="ziekMelding" method="POST">
										<div class="form-group">
											<label for="exampleFormControlSelect1">Meld hier
												jezelf ziek.</label>
										</div>
										<button type="submit" onclick="confirmRequest()"
											class="btn btn-primary">Melden</button>
									</form>
								</div>
							</div>
						</div>

						<!-- Verlof aanvragen -->
						<div id="verlofaanvragen">
							<div class="card text-white bg-white mb-3">
								<h1>Verlof aanvragen</h1>
								<div class="card-body">
									<form action="verlofaanvraagvoltooid" method="POST">
										<div class="form-group">
											<label for="exampleFormControlTextarea2">Toelichting
											</label>
											<textarea class="form-control"
												id="exampleFormControlTextarea2" name="opmerking" rows="1"
												required></textarea>
											<hr>
											<label for="start">Begindatum</label> <input type="date"
												id="start" name="begindatum" min="" max="2025-12-31"
												required> <label for="appt">Begintijd</label> <input
												type="time" id="appt" name="begintijd" min="" max="16:00"
												required> <label for="end">Einddatum</label> <input
												type="date" id="end" name="einddatum" min=""
												max="2025-12-31" required> <label for="endtime">Eindtijd</label>
											<input type="time" id="endtime" name="eindtijd" min=""
												max="16:00" required>

											<script>
												// Haal de huidige datum en tijd op
												var today = new Date()
														.toISOString().split(
																"T")[0];
												var currentTime = new Date()
														.toLocaleTimeString(
																[],
																{
																	hour : '2-digit',
																	minute : '2-digit',
																	hour12 : false
																});

												// Selecteer de date input elementen
												var startDateInput = document
														.getElementById("start");
												var startTimeInput = document
														.getElementById("appt");
												var endDateInput = document
														.getElementById("end");
												var endTimeInput = document
														.getElementById("endtime");

												// Stel de minimale datum van de startdatum in op vandaag
												startDateInput.min = today;

												// Voeg een event listener toe aan de startdatum input om de minimale waarde van de einddatum dynamisch in te stellen
												startDateInput
														.addEventListener(
																"input",
																function() {
																	endDateInput.min = this.value;

																	// Controleer of de einddatum is ingesteld op een datum eerder dan de nieuwe minimale waarde
																	if (endDateInput.value < endDateInput.min) {
																		endDateInput.value = endDateInput.min;
																	}

																	// Controleer of de begindatum gelijk is aan de huidige datum
																	if (this.value === today) {
																		startTimeInput.min = currentTime;
																	} else {
																		startTimeInput.min = "";
																	}

																	// Controleer of de einddatum gelijk is aan de begindatum
																	if (endDateInput.value === this.value) {
																		endTimeInput.min = startTimeInput.value;
																	} else {
																		endTimeInput.min = "";
																	}
																});

												// Voeg event listeners toe aan de begindatum en begintijd inputs om de minimale waarden bij te werken
												startDateInput
														.addEventListener(
																"change",
																updateMinValues);
												startTimeInput
														.addEventListener(
																"change",
																updateMinValues);

												// Functie om de minimale waarden bij te werken
												function updateMinValues() {
													endDateInput.min = startDateInput.value;

													if (endDateInput.value === startDateInput.value) {
														endTimeInput.min = startTimeInput.value;
													} else {
														endTimeInput.min = "";
													}
												}
											</script>
										</div>
										<button type="submit" onclick="confirmRequest()"
											class="btn btn-primary">Aanvragen</button>
									</form>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>

			<script>
				// Event listener toevoegen aan de knop
				document.getElementById("exampleFormControlSelect2").onchange = voegMelding;

				function voegMelding() {
					// De waarde van de selectie ophalen
					var selectie = document
							.getElementById("exampleFormControlSelect2").value;
					if (selectie === "Ziek melden") {
						// Maak ziek melden div zichtbaar
						document.getElementById("telaatmelden").style.display = "none";
						document.getElementById("ziekmelden").style.display = "block";
						document.getElementById("verlofaanvragen").style.display = "none"; // Verberg verlof aanvragen div
					} else if (selectie === "Kies een optie...") {
						// Maak melding menus onzichtbaar
						document.getElementById("telaatmelden").style.display = "none";
						document.getElementById("ziekmelden").style.display = "none";
						document.getElementById("verlofaanvragen").style.display = "none"; // Verberg verlof aanvragen div
					} else if (selectie === "Laat melden") {
						// Maak te laat melden zichtbaar
						document.getElementById("telaatmelden").style.display = "block";
						document.getElementById("ziekmelden").style.display = "none";
						document.getElementById("verlofaanvragen").style.display = "none"; // Verberg verlof aanvragen div
					} else if (selectie === "Verlof aanvragen") {
						// Maak verlof aanvragen zichtbaar
						document.getElementById("telaatmelden").style.display = "none";
						document.getElementById("ziekmelden").style.display = "none";
						document.getElementById("verlofaanvragen").style.display = "block"; // Toon verlof aanvragen div
					}
				}
			</script>

			<script>
				// Event listener toevoegen aan de knop
				document.getElementById("exampleFormControlSelect1").onchange = voegCommentaar;

				function voegCommentaar() {
					// De waarde van de selectie ophalen
					var selectie = document
							.getElementById("exampleFormControlSelect1").value;
					// Als de selectie gelijk is aan "Overige" dan maak het commentaar veld zichtbaar
					if (selectie === "Overige") {
						// Zorgt voor focus op het commentaar veld
						setTimeout(function() {
							document.getElementById(
									"exampleFormControlTextarea1").focus();
						}, 100);
						document.getElementById("opmerking").style.display = "block";
					} else {
						// Maak het commentaar veld onzichtbaar
						document.getElementById("opmerking").style.display = "none";
					}
				}
			</script>