<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mi perfil</title>
</head>
<body>
	<h2>Mi perfil</h2>
	<table>

		<tr>
			<td>Nombre de usuario:</td>
			<td>${user.nombreUsuario}</td>
		<tr>
			<td>Correo:</td>
			<td>${user.correo}</td>
		<tr>
			<td>Tipo de usuario:</td>
			<td>${user.tipoUsuario.nombre}</td>
		<tr>
			<td>Fecha de alta:</td>
			<td><fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss" type="both"
					value="${producto.fecha}" /></td>
	</table>

</body>
</html>