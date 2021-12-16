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

	<div class="bg-light p-4 rounded my-2 text-center">
		<h1>¡Bienvenidos a Tierra Media!</h1>
	</div>


	<div class="container-fluid my-2">
		<div id="carouselExampleIndicators" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#carouselExampleIndicators"
					data-bs-slide-to="0" class="active" aria-current="true"
					aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#carouselExampleIndicators"
					data-bs-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-bs-target="#carouselExampleIndicators"
					data-bs-slide-to="2" aria-label="Slide 3"></button>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="view/img/montañaRusa.jpg" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="view/img/patioComidas.jpg" class="d-block w-100"
						alt="...">
				</div>
				<div class="carousel-item">
					<img src="view/img/paisaje.jpg" class="d-block w-100" alt="...">
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	</div>

	<hr class="featurette-divider">
	<div class="row featurette">
		<div class="col-md-7">
			<h2 class="featurette-heading">MORDOR</h2>
			<p class="lead bold">
				Ascenso de palestra natural de 20 metros de longitud con tomas
				artificiales. <br>Juego apto para personas mayores de 10 años.
			</p>
		</div>
		<div class="col-md-5">
			<img src="view/img/mordor.png" class="d-block w-90"
				style="height: 300px;" alt="" />
		</div>
	</div>

	<hr class="featurette-divider">

	<div class="row featurette">
		<div class="col-md-7 order-md-2">
			<h2 class="featurette-heading">EL SUELO ES LAVA</h2>
			<p class="lead">Rememorando nuestras infancias una nueva versión
				del clásico infantil, solo no hay que temerle a la altura.</p>
		</div>
		<div class="col-md-5 order-md-1">
			<img src="view/img/sueloLava.png"
				class="d-block w-90" style="height: 300px;" alt="" />
		</div>
	</div>

	<hr class="featurette-divider">

	<div class="row featurette">
		<div class="col-md-7">
			<h2 class="featurette-heading">EREBOR</h2>
			<p class="lead">Un trekking espectacular, de fácil acceso. Se
				ingresa en un angosto cañadón con paredes de más de 70 metros de
				altura.</p>
		</div>
		<div class="col-md-5">
			<img src="view/img/Erebor.png"
				class="d-block w-90" style="height: 300px;" alt="" />
		</div>
	</div>
	<hr class="featurette-divider">
	<div class="row featurette">
		<div class="col-md-7 order-md-2">
			<h2 class="featurette-heading">BOSQUE NEGRO</h2>
			<p class="lead">Recorrido a través de un bosque artificial,
				mezclando aventura y paisaje en un mismo lugar.</p>
		</div>
		<div class="col-md-5 order-md-1">
			<img src="view/img/bosqueNegro.png"
				class="d-block w-90" style="height: 300px;" alt="" />
		</div>
	</div>
	<hr class="featurette-divider">

</body>
<footer>
	<jsp:include page="/view/partials/footer.jsp"></jsp:include>
</footer>
</html>