<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/view/partials/head.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="/view/partials/nav.jsp"></jsp:include>
	
	<div class = "text-center mt-5  shadow">
	<h1><strong><c:out value="${detalles.nombre}"></c:out></strong></h1>
	<hr>
	</div>
	
	<!-- ACA PONGO LA IMAGEN -->
	
	<div>
		<img alt="" src="imagen de la atraccion">
		<br>
		<c:out value="${detalles.detalle}"></c:out>
	</div>
	
	<div class="mt-5 container-fluid bg-dark text-white d-block">
	<ul>
	<li> <strong> Costo: $</strong><c:out value="${detalles.costo}"></c:out> </li>
	<br>
	<li><strong> Tiempo: $</strong><c:out value="${detalles.costo}"></c:out> </li>
	</ul>
	</div>
	
	<footer>
	<jsp:include page="/view/partials/footer.jsp"></jsp:include>
</footer>
</body>
</html>