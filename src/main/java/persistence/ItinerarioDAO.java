package persistence;

import java.util.List;

import model.Producto;
import model.Usuario;

public interface ItinerarioDAO{

	public abstract List<Producto> findAllOfUser(int id);
	public abstract int countAllOfUser(int id);
	public abstract int insert(Producto t, Usuario u);
	public abstract int update(Producto t, Usuario u);
	public abstract int delete(Usuario usuario);
}
