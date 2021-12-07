package controller.atracciones;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AtraccionService;

@WebServlet("/atracciones/delete.do")
public class DeleteAtraccionesServlet extends HttpServlet {

	private static final long serialVersionUID = -2804822557949520648L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
	
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		atraccionService.delete(id);
		
		response.sendRedirect("/turismo/atracciones/index.do");
	
	}
}
