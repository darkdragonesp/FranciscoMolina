<%--
  Formulario para añadir nuevas categorías de juegos al sistema
  
  Author : Francisco Molina Sanchez
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page errorPage="error.jsp"%>


	<h3>
		<spring:message code="juego.categoria.nueva" />
	</h3>

	<%-- 	Formulario para categorías --%>
	<form:form class="form-signin" modelAttribute="categoria" method="POST"
		action="${raiz}/categoria/save">
		
			<form:hidden path="idCategoria" value="${idCategoria}" />

			<label for="nombre" class="sr-only">
				<spring:message code="juego.categoria" var="labNombre"/>
			</label>
				<form:input path="nombre" value="${nombre}" required="required" placeholder="${labNombre}" class="form-control"/>
				<form:errors path="nombre" cssClass="error" />

			<input type="submit" class="btn btn-lg btn-primary btn-block"
					value="<spring:message code="accion.guardar"/>" />
			
		
		<form:errors cssClass="errorblock" element="div" />
	</form:form>

	<jsp:include page="${raiz}/tiles/mensaje.jsp" />

	<a class="nav-link" href="${raiz}/inicio"><spring:message code="accion.inicio" /></a>
