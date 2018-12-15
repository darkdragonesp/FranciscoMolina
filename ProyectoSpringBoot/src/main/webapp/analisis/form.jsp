<%--
  Formulario para añadir nuevos análisis de juegos al sistema
  
  Author : Francisco Molina Sanchez
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page errorPage="error.jsp"%>


	<h3>
		<spring:message code="juego.analisis" />
	</h3>

	<%-- 	Formulario para analisis --%>
	<form:form class="form-signin" modelAttribute="analisis" method="POST"
		action="${raiz}/analisis/save">
		<form:hidden path="juego.idJuego" value="${juego.idJuego}" />
		<form:hidden path="usuario.idUsuario" value="${usuario.idUsuario}" />
		

			<label for="nota" class="sr-only">
				<spring:message code="juego.analisis.nota" var="labNota"/>
			</label>
				<form:input path="nota" type="number" min="0" max="100"
						step="1" required="required" placeholder="${labNota}" class="form-control"/>
				<form:errors path="nota" cssClass="error" />
			

			<label for="comentario" class="sr-only">
				<spring:message code="juego.analisis.comentario" var="labComentario"/>
			</label>
				<form:textarea path="comentario" required="required" rows="8" placeholder="${labComentario}" class="form-control"/>
				<form:errors path="comentario" cssClass="error" />

				<input type="submit" class="btn btn-lg btn-primary btn-block"
					value="<spring:message code="accion.guardar"/>" />
			
		
		<form:errors cssClass="errorblock" element="div" />
	</form:form>
	${msg}
	<br>
	<a
		href="${raiz}/${analisis.juego.idJuego}/juego/view">
		<spring:message code="accion.volver" />
	</a>
	<a href="${raiz}/inicio"><spring:message
			code="accion.inicio" /></a>
