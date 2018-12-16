<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	

	<c:if test="${sessionUser.tipoUsuario.idTipo == 1}">
		<a class="nav-link" href="${raiz}/juego/save"><spring:message code="accion.nuevo" /></a>
	</c:if>
		<a class="nav-link" href="${raiz}/juego/list"><spring:message code="accion.listar.juegos" /></a>
		
		<a class="nav-link" href="${raiz}/juego/usuario/list"><spring:message
				code="accion.listar.juegos.usuario" /></a>
	
		<a class="nav-link" href="${raiz}/usuario/view"><spring:message code="accion.perfil.ver" /></a>
		
		<br> ${msg}
