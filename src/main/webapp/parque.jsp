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
			<h1>
				¡Bienvenidos a Tierra Media!
			</h1>
		</div >
		
		
<div class="container-fluid my-2" >
	<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
     <img src="view/img/montañaRusa.jpg" class="d-block w-100"alt="...">
    </div>
    <div class="carousel-item">
       <img src="view/img/patioComidas.jpg" class="d-block w-100"alt="...">
    </div>
    <div class="carousel-item">
       <img src="view/img/paisaje.jpg" class="d-block w-100"alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
</div>
	
	<!--   CAARRRRRDDDDDDDDD -->
	
	<div>
	<div class="row row-cols-1 row-cols-md-3 g-4">
  <div class="col">
    <div class="card h-100">
      <img src="..." class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Mordor</h5>
        <p class="card-text">Unos minimos detalles.</p>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card h-100">
      <img src="..." class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">El piso es lava</h5>
        <p class="card-text">Unos minimos detalles.</p>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card h-100">
      <img src="..." class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Erebor</h5>
        <p class="card-text">Unos minimos detalles.</p>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card h-100">
      <img src="..." class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Bosque negro</h5>
        <p class="card-text">Unos minimos detalles.</p>
      </div>
    </div>
  </div>
</div>
	</div>
	
</body>
<footer>
<jsp:include page="/view/partials/footer.jsp"></jsp:include>
</footer>
</html>