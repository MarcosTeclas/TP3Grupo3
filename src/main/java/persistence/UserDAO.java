package persistence;

import model.Usuario;

public interface UserDAO extends GenericDAO<Usuario> {

	public abstract Usuario findById(int id);
	public abstract Usuario findByUsername(String username);
	
}