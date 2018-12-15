<%--
  Acceso de usuario
  
  Author : Francisco Molina Sanchez
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page errorPage="error.jsp"%>


	<h2><spring:message code="accion.acceder"/></h2>
	<%-- 	Login de Usuario --%>
	<form:form class="form-signin" modelAttribute="usuario" method="POST" action="login">
		
				<label for="nombreUsuario" class="sr-only">
				<spring:message code="usuario.nombre" var="labNombreUsuario"/>
				</label>
				<form:input path="nombreUsuario" required="required" class="form-control" placeholder="${labNombreUsuario}"/>
				<form:errors path="nombreUsuario" cssClass="error" />
				
					
				<label for="contrasena" class="sr-only">
				<spring:message code="usuario.contrasena" var="labContrasena"/>
				</label>
				<form:input path="contrasena" type="password" required="required" class="form-control" placeholder="${labContrasena}"/>
				<form:errors path="contrasena" cssClass="error" />
				
					
				<input type="submit" class="btn btn-lg btn-primary btn-block" value="<spring:message code="accion.acceder"/>"/>
		
		<form:errors cssClass="errorblock" element="div" />
	</form:form>
		<br>
	${msg}
	<a class="nav-link" href="${raiz}/usuario/save"><spring:message code="accion.registrarse" /></a>