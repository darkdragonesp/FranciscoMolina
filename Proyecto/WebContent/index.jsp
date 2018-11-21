<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Repositorio de Videojuegos - Acceder</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		<fieldset>
			<legend>Inicio de sesión</legend>
			Nombre de usuario:<br>
			<input type="text" required="required"><br>
			Contraseña: <input type="password" required="required"><br>
		</fieldset>
		<input type="submit" value="Acceder">
	</form>

</body>
</html>