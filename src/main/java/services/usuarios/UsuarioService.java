package services.usuarios;

import java.util.ArrayList;
import java.util.List;

import model.Producto;
import model.TipoDeAtraccion;
import model.Usuario;
import persistence.DAOFactory;
import persistence.UserDAO;

public class UsuarioService {

	public List<Usuario> list() {
		return DAOFactory.getUserDAO().findAll();
	}

	public Usuario find(Integer id) {
		UserDAO userDAO = DAOFactory.getUserDAO();
		return userDAO.findById(id);
	}

	public Usuario create(String nombre, TipoDeAtraccion tipoAtraccionPreferida, Double dinero, Double tiempo,
			String password) {
		List<Producto> itinerario = new ArrayList<>();
		Usuario usuario = new Usuario(nombre, tipoAtraccionPreferida, dinero, tiempo, itinerario, password);

		if (usuario.isValid()) {
			UserDAO userDAO = DAOFactory.getUserDAO();
			userDAO.insert(usuario);
			// si no devuelve 1 es q hubo más errores
		}
		return usuario;
	}

	public Usuario update(Integer id, String nombre, TipoDeAtraccion tipoAtraccion, Double dinero, Double tiempo,
			String password) {

		UserDAO userDAO = DAOFactory.getUserDAO();
		Usuario usuario = userDAO.findById(id);

		usuario.setNombre(nombre);
		usuario.setPreferida(tipoAtraccion);
		usuario.setDinero(dinero);
		usuario.setTiempo(tiempo);
		usuario.setPassword(password);

		if (usuario.isValid()) {
			userDAO.update(usuario);
			// XXX: si no devuelve "1", es que hubo más errores
		}
		return usuario;
	}
	
	public void delete(Integer id) {
		Usuario usuario = new Usuario(id, null, null, 0, 0, null, null);
		
		UserDAO userDAO = DAOFactory.getUserDAO();
		userDAO.delete(usuario);
	}
}
