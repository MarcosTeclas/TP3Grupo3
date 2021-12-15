package persistence;

import model.Promocion;

public interface PromocionDAO extends GenericDAO<Promocion> {
	public abstract Promocion findById(int id);
	public abstract Promocion findByUsername(String nombre);

}
