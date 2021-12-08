package controller.session;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = -5038378332615676115L;
	private LoginService loginService;
	
@Override
public void init() throws ServletException {
	super.init();
	loginService = new LoginService();
}

public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	String username = request.getParameter("usuario"); 
	//String password = request.getParameter("password");
	
	Usuario usuario = loginService.login(username);
	
	if(!usuario.isNull()) {
		request.getSession().setAttribute("usuario", usuario);
		response.sendRedirect("welcome.jsp");
	}else {
		request.setAttribute("flash", "Nombre de usuario y contraseña incorrectos");
		
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}
}
}
