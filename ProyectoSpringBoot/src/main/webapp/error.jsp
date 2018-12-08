<%--
  Página de error general
  
  Author : Francisco Molina Sanchez
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="app.name" /></title>
</head>
<body>
	<spring:message code="mensaje.error" />
	<br>
	<br> ${error}
	<br>
	<a href="inicio"><spring:message code="accion.inicio" /></a>
</body>
</html>