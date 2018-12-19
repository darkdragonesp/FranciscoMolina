<%--
  Formulario de registro para nuevos usuarios
  
  Author : Francisco Molina Sanchez
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="error.jsp"%>


	<h2>
		<c:choose>
			<c:when test="${not empty sessionUser}">
				<spring:message code="accion.usuario.editar" />
			</c:when>
			<c:otherwise>
				<spring:message code="accion.registrarse" />
			</c:otherwise>		
		</c:choose>
		
		
	</h2>
	<%-- 	Formulario de registro de Usuario --%>
	<form:form class="form-signin" modelAttribute="usuario" method="POST"
		action="${raiz}/usuario/save">
		
				<form:hidden path="idUsuario"/>
				<form:hidden path="tipoUsuario.idTipo"/>
				
				
				<label for="nombreUsuario" class="sr-only">
				<spring:message code="usuario.nombre" var="labNombreUsuario"/>
				</label>
				<form:input path="nombreUsuario" required="required" class="form-control" placeholder="${labNombreUsuario}"/>
				<form:errors path="nombreUsuario" cssClass="error" />
			

				<label for="correo" class="sr-only">
				<spring:message code="usuario.correo" var="labCorreo"/>
				</label>
				<form:input path="correo" type="email" required="required" class="form-control" placeholder="${labCorreo}"/>
				<form:errors path="correo" cssClass="error" />
			
				<label for="contrasena" class="sr-only">
				<spring:message code="usuario.contrasena" var="labContrasena"/>
				</label>
				<form:input path="contrasena" type="password"
						required="required" class="form-control" placeholder="${labContrasena}"/>
				<form:errors path="contrasena" cssClass="error" />
			
				<c:choose>
					<c:when test="${not empty sessionUser}">
						<spring:message code="accion.guardar" var="botonSubmit"/>
					</c:when>
					<c:otherwise>
						<spring:message code="accion.registrar" var="botonSubmit"/>
					</c:otherwise>
				
				</c:choose>
				
				<input type="submit" class="btn btn-lg btn-primary btn-block"
					value="${botonSubmit}" />
			

		<form:errors cssClass="errorblock" element="div" />
	</form:form>
<!-- 	Mensaje de información -->
	<jsp:include page="${raiz}/tiles/mensaje.jsp" />

	<c:if test="${empty sessionUser}">
		<a class="nav-link" href="${raiz}/usuario/login"><spring:message code="accion.acceder" /></a>
	</c:if>