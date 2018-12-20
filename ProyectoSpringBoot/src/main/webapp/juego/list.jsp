<%--
  Muestra los datos de los juegos del sistema
  
  Author : Francisco Molina Sanchez
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page errorPage="error.jsp"%>

<!-- Iconos de botones -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--     Funciones ajax -->
<script src="${raiz}/js/misFunciones/ajaxListaJuegos.js"></script>


<h2>
	<spring:message code="accion.listar.juegos" />
</h2>
<!-- 	Mensaje de información -->
<jsp:include page="${raiz}/tiles/mensaje.jsp" />

<%-- 	Filtrado de Juegos --%>
<form:form class="form-inline input-group" modelAttribute="juego" name="filtrarJuegos"
	method="GET" action="javascript:filtrar()">
	<form:hidden path="idJuego" />


	<label for="titulo" class="sr-only"> <spring:message
			code="juego.titulo" var="labTitulo" />
	</label>
	<form:input path="titulo" class="form-control"
		placeholder="${labTitulo}" />

	<label for="categoria.idCategoria" class="sr-only"> <spring:message
			code="accion.elegir.categoria" var="labCategoria" />
	</label>
	<form:select path="categoria.idCategoria" class="form-control">
		<form:option value="">${labCategoria}</form:option>
		<form:options items="${listaCategorias}" itemLabel="nombre"
			itemValue="idCategoria" />
	</form:select>

	<label for="plataforma.idPlataforma" class="sr-only"> <spring:message
			code="accion.elegir.plataforma" var="labCategoria" />
	</label>
	<form:select path="plataforma.idPlataforma" class="form-control">
		<form:option value="">${labCategoria}</form:option>
		<form:options items="${listaPlataformas}" itemLabel="nombre"
			itemValue="idPlataforma" />
	</form:select>

	<input type="submit" class="btn btn-default"
		value="<spring:message code="accion.filtrar"/>" />
	<input type="button" class="btn btn-default"
		onclick="listar()"
		value="<spring:message code="accion.limpiar"/>" />


</form:form>
<%-- Lista de Juegos --%>
<jsp:include page="${raiz}/juego/table.jsp" />

<br>
<a class="nav-link" href="${raiz}/inicio"><spring:message
		code="accion.inicio" /></a>
		