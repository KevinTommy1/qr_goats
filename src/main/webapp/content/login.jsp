<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
<link rel="stylesheet" href="content/css/login.css">
<style>
@import url('http://fonts.cdnfonts.com/css/centrale-sans-regular');
</style>

</head>
<body>
	<center>
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-sm-4 col-xs-12">
					<span class="error">${param.error}</span>
				</div>
				<div class="col-md-4 col-sm-4 col-xs-12">
					<img id="logo" class="spin" src="content/embed/qrgoatslogo.png">
					</img>
					<div class="form-group">
						<%-- <s:form cssClass="form-container" action="logincheck" method="post">--%>
						<%-- <s:textfield name="acc.email" label="Email" type="email"--%>
						<%-- cssClass="form-control"></s:textfield>--%>
						<%-- <s:textfield name="acc.wachtwoord" label="wachtwoord"--%>
						<%-- type="password" cssClass="form-control"></s:textfield>--%>
						<%-- <s:submit value="Log in" class="btn7 btn-primary btn-block" />--%>
						<%-- </s:form>--%>
						
						<form action="logincheck" method="post" class="form-container">
							<input name="acc.email" type="email" class="form-control"
								placeholder="Email"> <input name="acc.wachtwoord"
								type="password" class="form-control" placeholder="Password">
							<input type="submit" value="Log in"
								class="btn btn-primary btn-block">
						</form>
					</div>
				</div>
			</div>
		</div>
	</center>
</body>
</html>