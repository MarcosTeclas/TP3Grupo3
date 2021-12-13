package services.promociones;

import java.util.List;

import model.Promocion;
import persistence.DAOFactory;
import persistence.PromocionDAO;


public class PromocionService {
	
	public List<Promocion> list(){
		return DAOFactory.getPromocionDAO().findAll();
	}
	
	public void delete(Integer id) {
		//Promocion promocion = new Promocion(id, null, 0, 0, 0, null);
		
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		//promocionDAO.delete(promocion);
	}
	
	public Promocion find(Integer id) {
		PromocionDAO atraccionDAO = DAOFactory.getPromocionDAO();
		return atraccionDAO.findById(id);
	}

}
