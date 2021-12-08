package services;

import model.Usuario;
import model.nullobjects.NullUser;
import persistence.DAOFactory;
import persistence.UserDAO;

public class LoginService {
	
	public Usuario login(String username) {
		UserDAO userDao = DAOFactory.getUserDAO();
		Usuario usuario = userDao.findByUsername(username);
		
		//if(usuario.isNull() || !usuario.checkPassword(password)) {
			//usuario = NullUser.build();
		//}
		return usuario;
	}

}
