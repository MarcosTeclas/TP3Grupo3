<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	<div class="mb-3">
		<label for="name" class="col-form-label">Nombre:</label> <input
			type="text" placeholder="Ingrese el nombre de la nueva atraccion" class="form-control" id="nombre" name="nombre"
			required value="${atraccion.nombre}">
			
	</div>
	<div class="mb-3">
		<label for="cost"
			class='col-form-label ${atraccion.errors.get("costo") != null ? "is-invalid" : "" }'>Costo:</label>
		<input class="form-control" placeholder="Ingrese el costo del boleto" type="number" min=0.5 step=0.5 id="costo" name="costo"
			required value="${atraccion.costo}"></input>
		<div class="invalid-feedback">
			<c:out value='${atraccion.errors.get("costo")}'></c:out>
			
		</div>
	</div>
	<div class="mb-3">
		<label for="duration"
			class='col-form-label ${atraccion.errors.get("tiempoNecesario") != null ? "is-invalid" : "" }'>tiempo de la atraccion:</label>
		<input class="form-control" placeholder="Tiempo de duracion" type="number" min=0.5 step=0.5 id="tiempoNecesario" name="tiempoNecesario"
			required value="${atraccion.tiempoNecesario}"></input>
		<div class="invalid-feedback">
			<c:out value='${atraccion.errors.get("tiempoNecesario")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="capacity"
			class='col-form-label ${atraccion.errors.get("cupo") != null ? "is-invalid" : "" }'>Cupo:</label>
		<input class="form-control" placeholder="Cupo maximo para el evento" type="number" min=1 id="cupo" name="cupo"
			required value="${atraccion.cupo}"></input>
		<div class="invalid-feedback">
			<c:out value='${atraccion.errors.get("cupo")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="tipo" class="form-label">Tipo de atraccion</label>
		<select class="form-select" required name="tipo" aria-label="default select example" id="tipo">
		
		<option selected value="">Seleccione un tipo de atraccion</option>
		<option value="AVENTURA">AVENTURA</option>
		<option value="DEGUSTACION">DEGUSTACION</option>
		<option value="PAISAJE">PAISAJE</option>
		</select>
	</div>
	
</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
