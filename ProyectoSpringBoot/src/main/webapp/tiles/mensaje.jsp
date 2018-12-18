<%--
  Muestra un mensaje de información
  
  Author : Francisco Molina Sanchez
 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty msg}">
	<div class="info">
		<span class="closebtn"
			onclick="this.parentElement.style.display='none';">&times;</span>
		${msg}
	</div>
</c:if>