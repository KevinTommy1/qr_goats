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
</head>
<body>

<t:navbar currentPage="absent">
	<!-- This should import the navbar -->
</t:navbar>
	<div class="content">
		<center>
			<div class="top-bar">
				<h1 class="title">Absentie</h1>
			</div>
			<div class="container">
				<div class="compleetBalk">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-body">
									<h1 class="card-title">Absent melding</h1>
									<p class="card-text">U bent succesvol afgemeld.</p>
									<a href="qrcode" class="btn btn-primary">Sluiten</a>

								</div>
								<div class="ziekSuccess"></div>
							</div>
						</div>
					</div>
				</div>

				<div class="ziekSuccess">
					<div class="card">
						<div class="card-body">
							<p class="card-title">Als je ziek meldt, moet je nog steeds
								de school bellen.</p>
							<p class="card-text">Bel hier:</p>
							<a href="tel:0118558800" class="btn btn-primary"><img
								src="https://cdn.iconscout.com/icon/free/png-256/phone-1532-458356.png"></a>
						</div>
					</div>
				</div>
			</div>
	</div>






</body>
</html>