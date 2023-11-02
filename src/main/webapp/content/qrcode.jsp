<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="content/Javascript/qrcode.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fancyapps/ui@4.0/dist/fancybox.css">
	    <script src="https://cdn.jsdelivr.net/npm/@fancyapps/ui@4.0/dist/fancybox.umd.js"></script>
	<link rel="stylesheet" href="content/css/qrcode.css">
	<link rel="stylesheet" href="content/css/main.css">
	
	
	<script> let inchecktijd = ${ optijd } </script>

</head>
<body>
<t:navbar currentPage="qrcode">
	<!-- This should import the navbar -->
</t:navbar>


	<div class="top-bar">
		<h1 class="title">QR Code</h1>

		<!-- The Modal -->
		<div class="modal" id="myModal">
			<div class="modal-dialog modal-fullscreen-sm-down">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">Incheckregistraties</h4>
						<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<s:iterator value="registraties" var="r">
							<s:property value="r" />
							<br>
						</s:iterator>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-danger"
							data-bs-dismiss="modal">Sluiten</button>
					</div>

				</div>
			</div>
		</div>


		<div class="time" id="time"></div>

		<script>
			const time = document.getElementById("time");
			function updateTime() {
				let date = new Date();
				let hours = String(date.getHours()).padStart(2, "0");
				let minutes = String(date.getMinutes()).padStart(2, "0");
				let seconds = String(date.getSeconds()).padStart(2, "0");
				time.textContent = hours + ":" + minutes + ":" + seconds;
				setTimeout(updateTime, 1000);
			}
			updateTime();
		</script>


	</div>
	<div class="content">

		<h1>
			Welkom,
			<c:out value="${stud.voornaam }" />
		</h1>

		<h3>${optijdBericht}</h3>
		<center>
			<a class="qrcodediv"><img id="qrcode-image" data-fancybox="groep1" src="data:image/png;base64,${QRImage}" alt="QR Code"></a></center>
		</center>
		<br> <a href="../qr_goats/FAQ">Problemen met inchecken?</a><br>
		<span>U heeft laatst ingecheckt<b><br>${lastcardlog}</b></span> <br>
		<br>
		<br>
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#myModal">Incheckregistraties</button>

		<div id="telaat" style="display: none;">
			<div id="telaatbuttons">
				<span id="header">Je bent te laat</span> <span id="footer">Meld
					je bij je coach</span>
				<button id="sluiten">Sluiten</button>
			</div>
		</div>
</body>
</html>