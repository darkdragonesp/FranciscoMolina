<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de usuario</title>
</head>
<body>
	<h2>Registro de usuario</h2>
	<form action="/registrarUsuario" method="POST">
			<table>
			<tr><td>Nombre de usuario: </td><td><input type="text" name="nombreUsuario" required="required" maxlength="20"/></td>
			<tr><td>Contraseña: </td><td><input type="password" name="contrasena" required="required"  maxlength="20"/></td>
			<tr><td>Correo: </td><td><input type="email" name="email" required="required" /></td>
			<tr><td><input type="submit" value="Registrar"/></td>
			</table>
		</form>
</body>
</html>