<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="app.name"/></title>
</head>
<body>
	<a href="mostrarUsuario"><spring:message code="accion.perfil.ver"/></a>
	<br>
	<a href="guardarJuego"><spring:message code="accion.nuevo"/></a>
	<br>
	<a href="listarJuegos"><spring:message code="accion.listar.juegos"/></a>
	<br>
	<a href="listarJuegosPorUsuario"><spring:message code="accion.listar.juegos.usuario"/></a>
	<br>
	<a href="inicio?lang=es"><spring:message code="idioma.es"/></a>
	<a href="inicio?lang=en"><spring:message code="idioma.en"/></a>
</body>
</html>