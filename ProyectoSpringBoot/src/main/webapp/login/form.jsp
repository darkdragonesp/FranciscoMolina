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
	<form:form modelAttribute="usuario" method="POST" action="login">
		<table>
				<tr><th><spring:message code="usuario.nombre"/></th>
					<td><form:input path="nombreUsuario" required="required"/></td>
					<td><form:errors path="nombreUsuario" cssClass="error" /></td>
				</tr>
					
				<tr><th><spring:message code="usuario.contrasena"/></th>
					<td><form:input path="contrasena" type="password" required="required"/></td>
					<td><form:errors path="contrasena" cssClass="error" /></td>
				</tr>
					
				<tr><td><input type="submit" value="<spring:message code="accion.acceder"/>"/></td></tr>
		</table>
		<form:errors cssClass="errorblock" element="div" />
	</form:form>
		<br>
	${msg}
