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

	<main class="container">

		<c:if test="${usuario != null && !usuario.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al modificar un usuario.</p>
			</div>
		</c:if>

		<form action="editarUsuario.do" method="post">
			<input type="hidden" name="id" value="${usuario.id}">
			<jsp:include page="form.jsp"></jsp:include>
		</form>
	</main>
</body>
</html>
