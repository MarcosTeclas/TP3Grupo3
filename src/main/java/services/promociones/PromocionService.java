package services.promociones;

import java.util.List;

import model.Atraccion;
import model.PromoPorcentual;
import model.Promocion;
import model.TipoDeAtraccion;
import persistence.DAOFactory;
import persistence.PromocionDAO;


public class PromocionService {
	
	public List<Promocion> list(){
		return DAOFactory.getPromocionDAO().findAll();
	}
	
	public PromoPorcentual create(String nombre, TipoDeAtraccion tipoAtraccion, int descuento,
			List<Atraccion> atraccionesIncluidas) {
		
		PromoPorcentual promo = new PromoPorcentual(nombre, tipoAtraccion, descuento, atraccionesIncluidas);
		
		if(promo.isValid()) {
			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			promocionDAO.insert(promo);
		}		
		return promo;
	}
	
	public void delete(Integer id) {
		Promocion promocion = DAOFactory.getPromocionDAO().findById(id);
		
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		//promocionDAO.delete(promocion);
	}
	
	public Promocion find(Integer id) {
		PromocionDAO atraccionDAO = DAOFactory.getPromocionDAO();
		return atraccionDAO.findById(id);
	}


}
