package br.com.asantos.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.TerrenoDao;

/**
 * Servlet implementation class RemoveTerreno
 * representa a requisição de delete do item cadastrado
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/removeTerreno")
public class RemoveTerreno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String terrenoId = request.getParameter("id");
		Integer id = Integer.valueOf(terrenoId);
		
		TerrenoDao terrenos = new TerrenoDao();
		terrenos.removeTerreno(id);
		
		response.sendRedirect("listaTerrenos");
	
	
	}

}
