<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	2<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="content/css/FAQ.css">
<link rel="stylesheet" href="content/css/main.css">
<script>
	var accMachtigingen = ${
		acc.machtigingen
	};
</script>
</head>
<body>
<t:navbar currentPage="FAQ">
	<!-- This should import the navbar -->
</t:navbar>
<center>

	<div class="top-bar">
		<h1 class="title">FAQ</h1>
	</div>

	<div class="content" id="content">

		<c:if test="${acc.machtigingen == 2 }">

			<div class="faqdiv">
				<button type="button" class="faqbtn" data-bs-toggle="modal" data-bs-target="#addfaq">+</button>
			</div>
		</c:if>


		<!-- modal voor de FAQ -->
		<div class="modal" id="addfaq" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content divfaq">
					<div class="modal-header">
						<h3 class="modal-title">FAQ aanmaken</h3>
						<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
					</div>

					<div class="modal-body ">
						<form action="addFaq">
							<div class="col-lg-12 thfaq">
								<div class="form-floating mb-3">
									<input name="question" type="text" class="form-control form-control-lg"
										   placeholder="Vraag">
									<label for="question" class="col-form-label form-label-group">Vraag</label>
								</div>
							</div>

							<div class="col-lg-12">
								<div class="form-floating mb-3">
									<input name="answer" type="text" class="form-control form-control-lg"
										   placeholder="Antwoord">
									<label for="answer" class="col-form-label form-label-group">Antwoord</label>
								</div>
							</div>

							<input type="submit" class="btn submit-button" name="voeg-submit" value="Voeg toe">
						</form>
					</div>

				</div>
			</div>
		</div>

	</div>


	<table id="faqs" style="width: 90%;">
		<c:forEach items="${opleiding.questions}" var="q">
			<tr>
				<td>
					<div class="divfaq">
						<table class="divfaq">
							<tr>
								<th class="thfaq">
									<button type="button"
											class="collapseButtonFAQ btn btn-primary"
											data-bs-toggle="collapse"
											data-bs-target="#demo<c:out value="${q.id}"/>">
										<c:out value="${q}" />
									</button>
									<div class="row">
									    <div class="col">
									        <c:if test="${acc.machtigingen == 2 }">
									            <button type="button" class="btn btn-trash" data-bs-id="<c:out value="${q.id}"/>" data-bs-toggle="modal" data-bs-target="#delete"><i class="bi bi-trash3"></i></button>
								            </c:if>
								        </div>
								    </div>
								</th>
							</tr>
							<tr>
								<td>
									<div id="demo<c:out value="${q.id}"/>" class="collapse">
										<c:forEach items="${q.answers}" var="a">
										<p class="text-center">
											<c:out value="${a.answerName}" />
										</p>
										</c:forEach>
										</div>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</c:forEach>
	</table>

	<!-- modal voor het verwijderen van de faq -->
	<div class="modal" id="delete" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content divfaq">
				<div class="modal-header">
					<h3 class="modal-title">FAQ verwijderen</h3>

				</div>

				<div class="modal-body ">
					<form action="faqverwijderen" method="post">
						<div class="col-lg-12 thfaq">
							<p1 style="font-size: 20px;">Weet u zeker dat je een faq wilt verwijderen?</p1>
							<input type="hidden" name="id" id="faq-id">
							<button type="submit" class="btn">Delete</button>
							<button type="button" class="btn" data-bs-dismiss="modal">Annuleren</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script>
		const verwijderen = document.getElementById('delete');
		verwijderen.addEventListener('show.bs.modal', function(event) {
			let button = event.relatedTarget;
			let id = button.getAttribute('data-bs-id')
			let modalBodyInput = document.getElementById('faq-id');
			modalBodyInput.value = id
		})
	</script>

</center>
</body>
</html>