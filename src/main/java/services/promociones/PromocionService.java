package services.promociones;

import java.util.List;

import model.Atraccion;
import model.PromoAbsoluta;
import model.PromoAxB;
import model.PromoPorcentual;
import model.Promocion;
import model.TipoDeAtraccion;
import persistence.DAOFactory;
import persistence.PromocionDAO;


public class PromocionService {
	
	public List<Promocion> list(){
		return DAOFactory.getPromocionDAO().findAll();
	}
	
	public PromoPorcentual createPromoPorcentual(String nombre, TipoDeAtraccion tipoAtraccion, int descuento,
			List<Atraccion> atraccionesIncluidas) {
		
		PromoPorcentual promo = new PromoPorcentual(nombre, tipoAtraccion, descuento, atraccionesIncluidas);
		
		if(promo.isValid()) {
			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			promocionDAO.insert(promo);
		}		
		return promo;
	}
	
	public PromoAbsoluta createPromoAbsoluta(String nombre, TipoDeAtraccion tipoAtraccion, Double costo,
			List<Atraccion> atraccionesIncluidas) {
		
		PromoAbsoluta promo = new PromoAbsoluta(nombre, tipoAtraccion, costo, atraccionesIncluidas);
		
		if(promo.isValid()) {
			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			promocionDAO.insert(promo);
		}
		return promo;
	}
	
	public PromoAxB createPromoAxB(String nombre, TipoDeAtraccion tipoAtraccion, List<Atraccion> atraccionesIncluidas) {

		PromoAxB promo = new PromoAxB(nombre, tipoAtraccion, atraccionesIncluidas);
		
		if(promo.isValid()) {
			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			promocionDAO.insert(promo);
		}
		return promo;
	}
	
	public void delete(Integer id) {
		Promocion promocion = DAOFactory.getPromocionDAO().findById(id);
		
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		promocionDAO.delete(promocion);
	}
	
	public Promocion find(Integer id) {
		PromocionDAO atraccionDAO = DAOFactory.getPromocionDAO();
		return atraccionDAO.findById(id);
	}
}
