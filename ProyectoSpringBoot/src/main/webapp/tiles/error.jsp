<%--
  Página de error general
  
  Author : Francisco Molina Sanchez
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isErrorPage="true"%>

	<spring:message code="mensaje.error" />
	<br>
	<br> ${error}
	<br>
	<a class="nav-link" href="${raiz}/inicio"><spring:message code="accion.inicio" /></a>
