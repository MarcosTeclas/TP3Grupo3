package services.promociones;

import java.util.HashMap;
import java.util.Map;

import model.Atraccion;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.DAOFactory;
import persistence.UserDAO;

public class ComprarPromocionService {
	
	AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
	UserDAO userDAO = DAOFactory.getUserDAO();

	public Map<String, String> comprar(Integer usuarioId, Integer atraccionId){
		Map<String, String>errors = new HashMap<String, String>();
		
		/*Usuario usuario = userDAO.findById(usuarioId);
		Atraccion atraccion = atraccionDAO.findById(atraccionId);
	
		if(!atraccion.hayCupo()) {
			errors.put("atraccion", "No hay cupo disponible");
		}
		if(!usuario.puedePagar(atraccion)) {
			errors.put("usuario", "No tienes dinero suficiente");
		}
		if(!usuario.tieneTiempo(atraccion)) {
			errors.put("usuario", "No tienes tiempo suficiente");
		}
		
		if(errors.isEmpty()) {
			usuario.comprarProducto(atraccion);
			
			//atraccionDAO.update(atraccion);
			//userDAO.update(usuario);
		}*/
		return errors;
	}
}
