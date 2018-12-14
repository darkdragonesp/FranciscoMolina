<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page errorPage="error.jsp"%>

	<a href="${pageContext.request.contextPath}/usuario/save"><spring:message code="accion.registrarse" /></a>
	<br>
	<a href="${pageContext.request.contextPath}/usuario/view"><spring:message code="accion.perfil.ver" /></a>
	<br>
	<a href="${pageContext.request.contextPath}/juego/save"><spring:message code="accion.nuevo" /></a>
	<br>
	<a href="${pageContext.request.contextPath}/juego/list"><spring:message code="accion.listar.juegos" /></a>
	<br>
	<a href="${pageContext.request.contextPath}/juego/usuario/list"><spring:message
			code="accion.listar.juegos.usuario" /></a>
	<br>
	<a href="${pageContext.request.contextPath}/inicio?lang=es"><spring:message code="idioma.es" /></a>
	<a href="${pageContext.request.contextPath}/inicio?lang=en"><spring:message code="idioma.en" /></a>

	<br> ${msg}
