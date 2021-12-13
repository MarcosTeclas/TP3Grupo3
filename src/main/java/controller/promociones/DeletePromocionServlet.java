package controller.promociones;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.promociones.PromocionService;

@WebServlet("/delete.do")
public class DeletePromocionServlet extends HttpServlet {

	private static final long serialVersionUID = 1978922477776738426L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
	
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		promocionService.delete(id);
		
		response.sendRedirect("promociones.do");
	
	}
}
