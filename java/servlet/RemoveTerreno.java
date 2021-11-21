package br.com.asantos.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.TerrenoDao;
import br.com.asantos.gerenciador.vo.Terreno;

/**
 * Servlet implementation class RemoveTerreno
 * representa a requisição de delete do item cadastrado
 * @author Aline S
 * @version 0.2
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
		
		Terreno t = new Terreno();
		t.setId(id);
		TerrenoDao terrenoDao = new TerrenoDao();

		try {
			terrenoDao.deleteTerreno(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		response.sendRedirect("listaTerrenos");
	
	
	}

}
