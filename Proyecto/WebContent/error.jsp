<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>
<body>
	<h1>Atenci�n</h1>
	<h2>La aplicaci�n ha dejado de funcionar. Int�ntelo de nuevo m�s tarde.</h2>

	<a href="index.jsp">�Volver!  </a>
	<hr>
	${error}
	<br>
	

</body>
</html>