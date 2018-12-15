<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page errorPage="error.jsp"%>

	<a href="${raiz}/usuario/save"><spring:message code="accion.registrarse" /></a>
	<br>
	<a href="${raiz}/usuario/view"><spring:message code="accion.perfil.ver" /></a>
	<br>
	<a href="${raiz}/juego/save"><spring:message code="accion.nuevo" /></a>
	<br>
	<a href="${raiz}/juego/list"><spring:message code="accion.listar.juegos" /></a>
	<br>
	<a href="${raiz}/juego/usuario/list"><spring:message
			code="accion.listar.juegos.usuario" /></a>
	<br>
	<a href="${raiz}/inicio?lang=es"><spring:message code="idioma.es" /></a>
	<a href="${raiz}/inicio?lang=en"><spring:message code="idioma.en" /></a>

	<br> ${msg}
