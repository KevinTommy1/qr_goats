        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html> 
    <head>
    	<link rel="stylesheet" href="content/css/main.css">
    </head>
    
    <body>
        <s:form action="logout" method="POST">
            <input type="submit" value="logout"/>
            </s:form>   
        <h1>Dit is de start pagina</h1>
        <s:form action="ProfielPagina" method="POST">
            <input type="submit" value="ProfielPagina"/>
        </s:form>
        <s:form action="absent" method="POST">
            <input type="submit" value="absent"/>
        </s:form>
        
          <s:form action="FAQ" method="POST">
            <input type="submit" value="FAQ"/>
		  </s:form>
		
         <s:form action="login" method="POST">
            <input type="submit" value="loginpage"/>
		</s:form>
		
         <s:form action="privacy" method="POST">
            <input type="submit" value="privacy"/>
		</s:form>

    </body>
</html>