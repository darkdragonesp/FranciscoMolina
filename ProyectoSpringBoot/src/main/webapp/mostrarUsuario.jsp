<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page errorPage="error.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title><spring:message code="app.name"/></title>
</head>
<body>
<!-- Perfil de usuario -->
	<h2><spring:message code="usuario.perfil"/></h2>
	
	<table>
		
			<tr><th><spring:message code="usuario.nombre"/></th>
				<td>${usuario.nombreUsuario}</td></tr>
			<tr><th><spring:message code="usuario.correo"/></th>
				<td>${usuario.correo}</td></tr>
			<tr><th><spring:message code="usuario.tipoUsuario"/></th>
				<td>${usuario.tipoUsuario.nombre}</td></tr>
			<tr><th><spring:message code="usuario.fechaAlta"/></th>
				<td><fmt:formatDate value="${usuario.fechaAlta}" pattern="dd-MM-yyyy hh:mm:ss"/></td></tr>

	</table>
	<br>
	<!-- 	Lista de Analisis -->
	<h3><spring:message code="juego.analisis"/></h3>

	<table>
		
			
				<tr>
				<th><spring:message code="juego.analisis.fechaAlta"/></th>	
					<th><spring:message code="juego.titulo"/></th>
					<th><spring:message code="juego.analisis.nota"/></th>
					<th><spring:message code="juego.analisis.comentario"/></th>
					
				</tr>
				<c:forEach items="${usuario.analisis}" var="item">
				<tr>
					<td><fmt:formatDate value="${item.fechaAlta}" pattern="dd-MM-yyyy hh:MM:ss"/></td>
					<td>${item.juego.titulo}</td>	
					
					<td>${item.nota}</td>
					<td>${item.comentario}</td>
				</tr>
		
			
		</c:forEach>
	</table>
	<a href="inicio"><spring:message code="accion.inicio"/></a>
</body>
</html>