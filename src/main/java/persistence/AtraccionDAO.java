package persistence;

import model.Atraccion;

public interface AtraccionDAO extends GenericDAO<Atraccion> {
	public abstract Atraccion findById(int id);
	public abstract Atraccion findByUsername(String nombre);

}
