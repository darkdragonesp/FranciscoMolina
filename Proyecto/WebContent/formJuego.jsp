<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Añadir/Modificar juego</title>
</head>
<body>
	<h2>Añadir/Modificar juego</h2>
	<form action="/guardarJuego" method="POST">
			<input type="hidden" name="id" value="${juego.idJuego}"/>
			<table>
			<tr><td>Título</td><td><input type="text" name="titulo" value="${juego.titulo}" required="required"/></td>
	<!-- 		Categoría -->
					<tr>
				<td>Categoría</td>
				<td>
				<select name="categoria" required="required">
					<c:forEach items="${listaCategorias}" var="cat">
						<c:choose>
							<c:when test="${juego.categoria.idCategoria == cat.idCategoria}">
							<option value="${cat.idCategoria}" selected="selected">${cat.nombre}</option>
							</c:when>
							<c:otherwise>
							<option value="${cat.idCategoria}">${cat.nombre}</option>
							</c:otherwise>
						</c:choose>
						
					</c:forEach>
				</select>
				</td>
			</tr>
	<!-- 		Plataforma -->
					<tr>
				<td>Plataforma</td>
				<td>
				<select name="plataforma" required="required">
					<c:forEach items="${listaPlataformas}" var="plat">
						<c:choose>
							<c:when test="${juego.plataforma.idPlataforma == plat.idPlataforma}">
							<option value="${plat.idPlataforma}" selected="selected">${plat.nombre}</option>
							</c:when>
							<c:otherwise>
							<option value="${plat.idPlataforma}">${plat.nombre}</option>
							</c:otherwise>
						</c:choose>
						
					</c:forEach>
				</select>
				</td>
			</tr>
	
				<tr><td>Fecha Lanzamiento</td><td><input type="date" name="fecha" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${juego.fechaLanzamiento}"/>"/></td>
	
			<tr><td>Comentario</td><td><input type="text" name="comentario" value="${juego.comentario}"/></td>
			
	
			<tr><td><input type="submit" value="Guardar"/></td>
			</table>
		</form>
</body>
</html>