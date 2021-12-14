package model;

import java.util.HashMap;

public class Atraccion extends Producto{
	
	private HashMap<String, String> errors;
	private int activa;
	private String detalle;

	public Atraccion(int id, String nombre, double costo,double tiempoNecesario, int cupoPersonas, TipoDeAtraccion tipo, String detalle) {
		super(id, nombre, costo, tiempoNecesario, cupoPersonas, tipo);
		this.detalle = detalle;
		this.activa = 1;
	}

	public Atraccion(String nombre, double costo,double tiempoNecesario, int cupoPersonas, TipoDeAtraccion tipo, String detalle) {
		super(nombre, costo, tiempoNecesario, cupoPersonas, tipo);
		this.detalle = detalle;
		this.activa = 1;
	}

	public boolean quedaCupo() {
		return this.cupoPersonas > 0;
	}
	
	public void ocuparAtraccion() {
		if (quedaCupo()) {
			this.cupoPersonas--;
		}
	}
	
	@Override
	public boolean esPromo() {
		return false;
	}
	
	@Override
	public String toString() {
		return "Atraccion: " + nombre + ", costo: " + costo + ", tiempo necesario: " + tiempoNecesario
				+ ", tipo de Atracci�n=" + tipo;
	}

	@Override
	public double getCosto() {
		return this.costo;
	}

	@Override
	public double getTiempoNecesario() {
		return this.tiempoNecesario;
	}

	@Override
	public void restarCupo() {
		this.cupoPersonas--;		
	}
	
	public int getCupo() {
		return cupoPersonas;
	}
	
	public String getDetalle() {
		return detalle;
	}
	
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	@Override
	public TipoDeAtraccion getTipo() {
		return tipo;
	}

	@Override
	public String toStringParaMostrar() {
		return "ATRACCI�N: " + getNombre();
	}

	@Override
	public boolean contiene(Producto producto) {
		if(producto.esPromo()) {
			return producto.contiene(this);
		}
		return this.equals(producto);
	}
	
	public boolean isValid() {
		validate();
		
		return errors.isEmpty();
	}
	
	public void validate() {
		
		errors = new HashMap<String,String>();
		
		if(costo <= 0) {
			errors.put("costo", "debe ser positivo");
		}
		if(tiempoNecesario <= 0) {
			errors.put("tiempo necesario", "debe ser positivo");	
		}
		if(cupoPersonas <= 0) {
			errors.put("cupo de personas", "debe ser positivo");	
		}
		if(tipo == null) {
			errors.put("tipo de atracción", "no debe estar vacío");	
		}
	}

	public HashMap<String,String> getErrors(){
		return errors;
	}
	
	public int getActiva() {		
		return activa;
	}
	
}
