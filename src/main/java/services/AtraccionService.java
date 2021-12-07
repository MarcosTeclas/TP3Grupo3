package services;

import java.util.List;

import model.Atraccion;
import model.TipoDeAtraccion;
import persistence.AtraccionDAO;
import persistence.DAOFactory;

public class AtraccionService {
	
	public List<Atraccion> list(){
		return DAOFactory.getAtraccionDAO().findAll();
	}
	
	public Atraccion create(String nombre, Integer costo, Double tiempoNecesario, Integer cupoPersonas, TipoDeAtraccion tipoAtraccion) {
		Atraccion atraccion = new Atraccion (nombre, costo, tiempoNecesario, cupoPersonas, tipoAtraccion);
		
		if(atraccion.isValid()) {
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
			atraccionDAO.insert(atraccion);
			//si no devuelve 1 es q hubo más errores
		}
		return atraccion;
	}

	public void delete(Integer id) {
		Atraccion atraccion = new Atraccion(0, null, 0, 0, 0, null);
		
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		atraccionDAO.delete(atraccion);
	}
	
	public Atraccion find(Integer id) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		return atraccionDAO.findById(id);
	}
	
	public Atraccion update(int id, String nombre, double costo,double tiempoNecesario, int cupoPersonas, TipoDeAtraccion tipo) {

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		Atraccion atraccion = atraccionDAO.findById(id);

		atraccion.setNombre(nombre);
		atraccion.setCosto(costo);
		atraccion.setTiempoNecesario(tiempoNecesario);
		atraccion.setCupoPersonas(cupoPersonas);
		atraccion.setTipo(tipo);

		if (atraccion.isValid()) {
			atraccionDAO.update(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return atraccion;
	}
}
