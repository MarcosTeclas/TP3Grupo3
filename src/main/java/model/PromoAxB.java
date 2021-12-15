package model;

import java.util.List;
import java.util.ListIterator;

public class PromoAxB extends Promocion {

	public PromoAxB(int id, String nombre, TipoDeAtraccion tipo, List<Atraccion> atraccionesIncluidas) {
		super(id, tipo, nombre, atraccionesIncluidas);
		this.costo = getCosto();
		this.tiempoNecesario = super.getTiempoNecesario();
	}

	@Override
	public double getCosto() {
		double costo = 0;
		ListIterator<Atraccion> itr = atraccionesIncluidas.listIterator(1);
		while (itr.hasNext()) {
			costo += itr.next().getCosto();
		}
		return costo;
	}

	@Override
	public String stringAtraccionesIncluidas() {
		String resultado = "";
		ListIterator<Atraccion> itr = atraccionesIncluidas.listIterator(1);
		while (itr.hasNext()) {
			resultado += itr.next().getNombre() + " ";
		}
		resultado += "atracción gratuita: " + atraccionesIncluidas.get(0).getNombre();
		return resultado;
	}

	@Override
	public String toString() {
		return "PROMO: " + nombre + ", costo: " + costo + ", tiempo necesario: " + tiempoNecesario + ", tipo: " + tipo
				+ ", atracciones Incluidas: " + stringAtraccionesIncluidas();
	}


}
