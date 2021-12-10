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

		<c:if test="${attraction != null && !attraction.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al actualizar la atracción.</p>
			</div>
		</c:if>

		<form action="edit.do" method="post">
			<input type="hidden" name="id" value="${attraction.id}">
			<jsp:include page="form.jsp"></jsp:include>
		</form>
	</main>
</body>
</html>
