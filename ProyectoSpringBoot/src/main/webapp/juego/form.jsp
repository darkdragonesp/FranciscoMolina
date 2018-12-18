<%--
  Formulario para añadir nuevos juegos al sistema
  
  Author : Francisco Molina Sanchez
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page errorPage="error.jsp"%>


	<h2>
		<c:choose>
			<c:when test="${empty juego.idJuego}">
				<spring:message code="accion.nuevo" />
			</c:when>
			<c:otherwise>
				<spring:message code="accion.editar.juego" />
			</c:otherwise>
		</c:choose>
	</h2>
	<%-- 	Formulario de registro de un Juego nuevo --%>
	<form:form class="container custom-container" modelAttribute="juego" method="POST"
		action="${raiz}/juego/save">
		<form:hidden path="idJuego" />
		

			<label for="titulo" class="sr-only">
				<spring:message code="juego.titulo" var="labTitulo"/>
		</label>
				<form:input path="titulo" required="required" class="form-control" placeholder="${labTitulo}"/>
				<form:errors path="titulo" cssClass="error" />
			

			<label for="categoria.idCategoria" class="sr-only">
				<spring:message code="juego.categoria"/>
		</label>
				<form:select path="categoria.idCategoria"
						items="${listaCategorias}" itemLabel="nombre"
						itemValue="idCategoria" required="required" class="form-control"/>
			

			<label for="plataforma.idPlataforma" class="sr-only">
				<spring:message code="juego.plataforma"/>
		</label>
				<form:select path="plataforma.idPlataforma"
						items="${listaPlataformas}" itemLabel="nombre"
						itemValue="idPlataforma" required="required" class="form-control"/>
			

			<label for="fechaLanzamiento" class="sr-only">
				<spring:message code="juego.fechaLanzamiento" var="labFechaLanzamiento"/>
		</label>
				<form:input path="fechaLanzamiento"
						value="${fechaLanzamiento}" type="date" required="required" class="form-control" />
				<form:errors path="fechaLanzamiento" cssClass="error" />
			

			<label for="descripcion" class="sr-only">
				<spring:message code="juego.descripcion" var="labDescripcion"/>
		</label>
				<form:textarea path="descripcion" rows="8" placeholder="${labDescripcion}" class="form-control"/>
				<form:errors path="descripcion" cssClass="error" />
			


			
				<input type="submit" class="btn btn-lg btn-primary btn-block" value="<spring:message code="accion.guardar"/>" />
			
		
		<form:errors cssClass="errorblock" element="div" />
	</form:form>
	
	<a class="nav-link" href="${raiz}/juego/list"><spring:message
			code="accion.listar.juegos" /></a>
			
			
<!-- 		Mensaje de información		 -->
	<jsp:include page="${raiz}/tiles/mensaje.jsp" />