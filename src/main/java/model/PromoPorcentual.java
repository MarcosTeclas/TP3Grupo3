package model;

import java.util.List;

public class PromoPorcentual extends Promocion {

	private int descuento;

	public PromoPorcentual(int id, String nombre, TipoDeAtraccion tipo, int descuento, List<Atraccion> atraccionesIncluidas) {
		super(id, tipo, nombre, atraccionesIncluidas);
		this.descuento = descuento;
		this.costo = getCosto();
		this.tiempoNecesario = super.getTiempoNecesario();
	}

	@Override
	public double getCosto() {
		double costo = 0;
		for (Atraccion atrac : atraccionesIncluidas) {
			costo += atrac.getCosto();
		}
		double descuento = (costo * this.descuento) / 100;
		return costo - descuento;
	}

}
