<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Profiel</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="content/css/profielPagina.css">
<link rel="stylesheet" href="content/css/main.css">
<script src="content/Javascript/profilePage.js"></script>
</head>

<body>

<t:navbar currentPage="ProfielPagina">
	<!-- This should import the navbar -->
</t:navbar>
	<center>

		<div class="top-bar">
			<h1 class="title">Profiel</h1>
		</div>

		<div class="content">

			<div class="container">

				<img id="pfp" class="profielFoto mt-4"
					src="https://png.pngtree.com/png-clipart/20210310/original/pngtree-default-male-avatar-png-image_5939655.jpg"
					alt="Profiel foto">
				<div class="aangepasteDif">
					<table class="table_groote">
						<tr>
							<td>
								<p class="profielLabel text-dark fs-8 m-0 mb-1">Naam</p> <input
								class="inputText mb-1" type="text" id="naam" name="naam"
								placeholder="${Student.voornaam} ${Student.tussenvoegsel} ${Student.achternaam}"
								tabindex="-1" readonly="true" />
							</td>
							<td></td>
						</tr>
						<tr>
							<td>
								<p class="profielLabel text-dark fs-8 m-0 mb-1">E-mail</p> <input
								class="inputText mb-1" type="email" name="schoolMail"
								placeholder="${Account.email}" tabindex="-1" readonly="true" />
							</td>
							<td></td>
						</tr>
						<tr>
							<td>
								<p class="profielLabel text-dark fs-8 m-0">Studenten Nummer</p>
								<input class="inputText mb-1" type="number"
								name="studentenNummer" placeholder="${Student.studentNr}"
								tabindex="-1" readonly="true" />
							</td>
							<td></td>
						</tr>

						<s:form action="WijzigWachtwoordCheck" method="post"
							enctype="multipart/form-data">
							<tr>
								<td><label class="wachtwoordWijzigLabel">Oud
										Wachtwoord</label> <s:textfield class="inputText" type="password"
										id="wachtwoord" name="oudww" placeholder="Oud wachtwoord"
										tabindex="-1" required="true" /></td>
								<td></td>
							</tr>
							<tr>
								<td>
									<button type="button" class="" id="wijzig-Button">Wijzig
										Wachtwoord</button>
								</td>
								<td></td>
							</tr>
							<tr>
								<td><label class="wachtwoordWijzigLabel">Nieuw
										Wachtwoord</label> <s:textfield class="inputText" type="password"
										id="NieuwWachtwoord1" name="nieuwww1"
										placeholder="Nieuw wachtwoord" tabindex="-1" required="true"
										minlength="4" /></td>
								<td></td>
							</tr>
							<tr>
								<td><label class="wachtwoordWijzigLabel">Herhaal
										Nieuw Wachtwoord</label> <s:textfield class="inputText"
										type="password" id="NieuwWachtwoord2" name="nieuwww2verify"
										placeholder="Herhaal nieuw wachtwoord" tabindex="-1"
										required="true" minlength="4" /></td>
								<td></td>
							</tr>
							<tr>
								<td><s:submit class="editButton" id="opslaanButton"
										value="Opslaan"></s:submit>
									<button type="button" class="editButton" id="annuleerButton">Annuleer</button>
								</td>
							</tr>
						</s:form>

						<tr>
							<td>
								<form action="logout" method="POST">
									<input id="logout-Button" type="submit" value="Log uit" />
								</form>
							</td>
							<td></td>
						</tr>
					</table>

				</div>

				<div class="PrivacyDiv">
					<a href="privacyRegelement">Privacyregelement</a>
				</div>
			</div>
			<br> <br> <br>
		</div>
	</center>
</body>
</html>