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
		<spring:message code="accion.registrarse" />
	</h2>
	<%-- 	Formulario de registro de Usuario --%>
	<form:form class="form-signin" modelAttribute="usuario" method="POST"
		action="${raiz}/usuario/save">
				
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
			

			
				<input type="submit" class="btn btn-lg btn-primary btn-block"
					value="<spring:message code="accion.registrar"/>" />
			

		<form:errors cssClass="errorblock" element="div" />
	</form:form>
<!-- 	Mensaje de información -->
	<c:if test="${not empty msg}">		
		<div class="info">
		 	<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
		 	${msg}
		</div>
	</c:if>
	
	<a class="nav-link" href="${raiz}/usuario/login"><spring:message code="accion.acceder" /></a>
